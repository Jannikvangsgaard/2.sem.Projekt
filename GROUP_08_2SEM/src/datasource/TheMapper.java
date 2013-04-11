/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import domain.Customer;
import domain.Order;
import domain.Item;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Mike
 */
public class TheMapper {
    
    /**
     * Read from database
     */
    
    public ArrayList getOrder(Connection conn) {
        
        ArrayList<Order> order = new ArrayList();
        ArrayList<Item> item = new ArrayList();
        Order o = null;
        
        String SQLString1 = "SELECT * FROM ordre";  //Get order
        String SQLString2 = "SELECT * FROM ordredetails"; //Get orderdetails

        PreparedStatement statement = null;
        PreparedStatement statement2 = null;
        
        try {
            //Get order
            statement = conn.prepareStatement(SQLString1);
            statement2 = conn.prepareStatement(SQLString2);
            
            ResultSet rs = statement.executeQuery();
            ResultSet rs2 = statement2.executeQuery();
            
            while (rs2.next()) 
            {
                int itemNo = rs2.getInt(1);
                int itemQty = rs2.getInt(2);
                int orderNo = rs2.getInt(3);
                
            }
            while (rs.next()) 
            {
                int orderNo = rs.getInt(1);
                int kundeNo = rs.getInt(2);
                
                o = new Order(orderNo, odArr);
                order.add(o);
            }
        } catch (Exception ex) {
            System.out.println("Error in OrderMapper - getOrdre");
        }
        return order;
    }
    
    public ArrayList<Item> getItems(Connection conn) {
//        Item i = null;
        ArrayList<Item> itemsArr = new ArrayList();
        
        String SQLString = "SELECT * FROM varer";
        
        PreparedStatement statement = null;
        
        try {
            statement = conn.prepareStatement(SQLString);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                int vNo = rs.getInt(1);
                String vNa = rs.getString(2);
                int vQtotal = rs.getInt(3);
                
                Item i = new Item(vNo, vNa, vQtotal);
                itemsArr.add(i);
            }
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getItems");
        }
        
        return itemsArr;
    }
    
    public ArrayList<Customer> getCustomer(Connection conn) {
//        System.out.println("themapper her");
        String SQLString = "SELECT * FROM kunde";
        
        PreparedStatement statement = null;
        ArrayList<Customer> customer = new ArrayList();
        try {
            //Get order
            statement = conn.prepareStatement(SQLString);
            
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int customerNo = rs.getInt(1);
                String customerName = rs.getString(2);
                Customer c = new Customer(customerNo, customerName);
                customer.add(c);
            }
        } catch (Exception ex) {
            System.out.println("Error in TheMapper - getCustomer");
            System.out.println(ex.getMessage());
        }
        return customer;
    }

    /**
     * Write to database
     */
    public boolean saveOrder(ArrayList<Order> order, Connection con) {
        int rowsInserted = 0;
        int tal = 0;
        String SQLString1 = "insert into ordre values(?,?,?)";
        String SQLString2 = "insert into ordreDetails values(?,?,?)";
        String SQLString3 = "select ordreseq.nextval from dual";
        
        
        
        PreparedStatement statement = null;
        for (int j = 0; j< order.size() ;j++){
            Order otest = order.get(j);
            System.out.println("1 for");
            
            if(otest.getOrderNo() != 0){
                tal++;
                System.out.println(tal +"tal her");
            }}
        
        
        try {
            statement = con.prepareStatement(SQLString3);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) { 
                  
                for (int k = 0; order.size() > k; k++) {
                   
                    Order o = order.get(k);
                    
                    o.setOrderNo(rs.getInt(1));
                }
                }
                
            statement = con.prepareStatement(SQLString1);
            
          
                for(int j =tal; tal< order.size(); j++){
                    System.out.println("Forløkke saveorder");
                    Order o = order.get(j);
                System.out.println(o.getOrderNo());
                statement.setInt(1, o.getOrderNo());
                statement.setInt(2, o.getCustomer().getCustomerID());
                statement.setInt(3, o.getState());
                
                rowsInserted += statement.executeUpdate();
                }
            
           
            if (rowsInserted == 1) {
                rowsInserted = 0;
                statement = con.prepareStatement(SQLString2);
                
                for (int i = 0; i < order.size(); i++) {
                    Order o = order.get(i);
                    for (int j = 0; j < o.getItemlist().size(); j++) {
                        statement.setInt(1, o.getItemlist().get(j).getItemNo());
                        statement.setInt(2, o.getItemlist().get(j).getItemAmount());
                        statement.setInt(3, o.getOrderNo());
                        rowsInserted += statement.executeUpdate();
                    }
                    
                }
            } else {
                System.out.println("Fejl i OrdreMapper - Part 1");
            }
            
        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveOrder");
            e.printStackTrace();
        }
        return rowsInserted == order.size();
        
    }
    
    public boolean saveAvailableItem(ArrayList<Item> freeItems, Connection con) {
        int rowsInserted = 0;
        String SQLString1 = "update tilrådighed set antal = ? where varerNo = ?; ";
        
        PreparedStatement statement = null;
        
        try {
            statement = con.prepareStatement(SQLString1);
            
            for (int i = 0; i < freeItems.size(); i++) {
                statement.setInt(1, freeItems.get(i).getItemAmount());
                statement.setInt(2, freeItems.get(i).getItemNo());
                
                rowsInserted += statement.executeUpdate();
            }
            
            
            
            
            
            
            
        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == freeItems.size();
        
    }

    public boolean saveCustomer(ArrayList<Customer> customer, Connection con) {

        int rowsInserted = 0;
        String SQLString1 = "insert into kunde values(?,?)";
        String SQLString2 = "select kundeseq.nextval from dual";
        PreparedStatement statement = null;
        
        try {
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
             if (rs.next()) {
                for (int j = 0; customer.size() > j; j++) {
                    Customer o = customer.get(j);
                    o.setCustomerID(rs.getInt(1));
                }
            
            statement = con.prepareStatement(SQLString1);
            for (int i = 0; i < customer.size(); i++) {
                Customer cus = customer.get(i);
                statement.setInt(1,customer.get(i).getCustomerID());
                statement.setString(2, customer.get(i).getName());
            }
           
            }
            
            
            
            
            
            rowsInserted += statement.executeUpdate();
            
            
            
        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == customer.size();
        
    }
    public ArrayList<Item> getAvailableItem(Connection conn) {
//       
        String SQLString = "SELECT * FROM tilrådighed";
        
        PreparedStatement statement = null;
        ArrayList<Item> availableItem = new ArrayList();
        try {
            statement = conn.prepareStatement(SQLString);
            
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int itemNo = rs.getInt(1);
                int availableItemCount = rs.getInt(2);
                String itemName = rs.getString(3);
                Item i = new Item(itemNo, itemName, availableItemCount);
                availableItem.add(i);
            }
        } catch (Exception ex) {
            System.out.println("Error in TheMapper - getAvailableItem");
            System.out.println(ex.getMessage());
        }
        return availableItem;
    }
}

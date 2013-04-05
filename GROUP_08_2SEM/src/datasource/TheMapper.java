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
public class TheMapper
{
    
    static boolean testRun = false;
    
     /**
     * Read from database
     */

    public Order getOrders(int ono, Connection conn)
    {
        Order o = null;

        String SQLString1 = "SELECT * FROM ordre";  //Get order
        String SQLString2 = "SELECT varerno, antal FROM ordredetails WHERE ordreno = ?"; //Get orderdetails

        PreparedStatement statement = null;
        PreparedStatement statement2 = null;

        try
        {
            //Get order
            statement = conn.prepareStatement(SQLString1);
            statement2 = conn.prepareStatement(SQLString2);
            ArrayList<Item> vare = new ArrayList();

            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                statement2.setInt(1, ono);
                int VareNo = rs.getInt(2);
                String vNa = rs.getString(3);
                int qty = rs.getInt(4);
                Item v = new Item(VareNo, vNa, qty);
                vare.add(v);
            }
            while (rs.next())
            {
                o = new Order(ono, vare);
            }
        } catch (Exception ex)
        {
            System.out.println("Error in OrderMapper - getOrdre");
            System.out.println(ex.getMessage());
        }

        if (testRun)
        {
            System.out.println("Retrieved Order: " + o);
        }
        return o;
    }
    
    
    
    public ArrayList<Item> getItems(Connection conn)
    {
        Item i = null;
        ArrayList<Item> itemsArr = new ArrayList();
        
        String SQLString = "SELECT * FROM varer";
        
        PreparedStatement statement = null;
        
        try 
        {
            statement = conn.prepareStatement(SQLString);
            
            ResultSet rs = statement.executeQuery();
            
            while (rs.next())
            {
                int vNo = rs.getInt(1);
                String vNa = rs.getString(2);
                int vQtotal = rs.getInt(3);
                
                i = new Item(vNo, vNa, vQtotal);
                itemsArr.add(i);
            }
        }
        
        catch (Exception e)
        {
            System.out.println("Fejl i TheMapper - getItems");
        }
        
        return itemsArr;
    }
    
    public ArrayList<Customer> getCustomer(Connection conn){
//        System.out.println("themapper her");
        String SQLString = "SELECT * FROM kunde";
        
        PreparedStatement statement = null;
        ArrayList<Customer> customer = new ArrayList();
        try
        {
            //Get order
            statement = conn.prepareStatement(SQLString);
            
            
            ResultSet rs = statement.executeQuery();
            while (rs.next()) 
            {
                int customerNo = rs.getInt(1);
                String customerName = rs.getString(2);
                Customer c = new Customer(customerNo, customerName);
                customer.add(c);
            }
        }
         
        catch(Exception ex)
        {
            System.out.println("Error in TheMapper - getCustomer");
            System.out.println(ex.getMessage());
        }
        System.out.println(customer);
        return customer;
    }

    
    /**
     * Write to database
     */
    
    public boolean saveOrder(ArrayList<Order> order, Connection con)
    {
        int rowsInserted = 0;
        String SQLString1 = "insert into ordre values(?,?,?)";
        String SQLString2 = "insert into ordreDetails values(?,?,?)";
        String SQLString3 = "select employeeseq.nextval from dual";



        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString3);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                for (int k = 0; order.size() > k; k++)
                {
                    Order o = order.get(k);
                    o.setOrderNo(rs.getInt(1));
                }

            }

            statement = con.prepareStatement(SQLString1);

            for (int i = 0; i < order.size(); i++)
            {
                Order o = order.get(i);
                statement.setInt(1, o.getOrderNo());
                statement.setInt(2, o.getCustomerID());
                statement.setInt(3, o.getState());

                rowsInserted += statement.executeUpdate();
            }

            if (rowsInserted == order.size())
            {
                rowsInserted = 0;
                statement = con.prepareStatement(SQLString2);

                for (int i = 0; i < order.size(); i++)
                {
                    Order o = order.get(i);
                    for (int j = 0; j < o.getItemlist().size(); j++)
                    {
                        statement.setInt(1, o.getItemlist().get(j).getItemNo());
                        statement.setInt(2, o.getItemlist().get(j).getItemAmount());
                        statement.setInt(3, o.getOrderNo());
                    }
                    rowsInserted += statement.executeUpdate();
                }
            } else
            {
                System.out.println("Fejl i OrdreMapper - Part 1");
            }

        } catch (Exception e)
        {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == order.size();

    }

    public boolean saveItem(ArrayList<Item> freeItems, Connection con)
    {
        int rowsInserted = 0;
        String SQLString1 = "update tilrådighed set antal = ? where varerNo = ?; ";

        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);

            for (int i = 0; i < freeItems.size(); i++)
            {
                Item fi = freeItems.get(i);
                statement.setInt(1, freeItems.get(i).getItemAmount());
                statement.setInt(2, freeItems.get(i).getItemNo());


            }



            rowsInserted += statement.executeUpdate();



        } catch (Exception e)
        {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == freeItems.size();

    }
}
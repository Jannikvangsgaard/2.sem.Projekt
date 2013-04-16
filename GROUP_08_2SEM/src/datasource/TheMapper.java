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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Mike
 */
public class TheMapper
{

    /**
     * Read from database
     */
    public ArrayList<Order> getAllOrders(Connection conn)
    {
        ArrayList<Order> orders     = new ArrayList();
        ArrayList<Item> items       = new ArrayList();
        PreparedStatement statement = null;
        Order o                     = null;
        Item i                      = null;
        int     orderNo         = 0, 
                customerNo      = 0, 
                itemNo          = 0, 
                qty             = 0, 
                state           = 0, 
                totalAmount     = 0;
        String  itemName, date        = "";
        
        String SQLString = "SELECT * FROM ordre NATURAL JOIN ordredetails NATURAL JOIN varer";
        
        try
        {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                itemNo         = rs.getInt(1);
                orderNo        = rs.getInt(2);
                System.out.println(orderNo);
                customerNo     = rs.getInt(3);
                state          = rs.getInt(4);
                date           = rs.getString(5);
                qty            = rs.getInt(6);
                itemName       = rs.getString(7);
                totalAmount    = rs.getInt(8);
                i = new Item(itemNo, itemName, qty);
                items.add(i);
            }
            o = new Order(customerNo, items,date);
            orders.add(o);
        }
        catch (Exception e)
        {
            System.out.println("Fejl i TheMapper - getAllOrders");
        }
        
        return orders;
    }
    
    public Order getSingleOrder(int ono, Connection conn)
    {
        ArrayList<Item> items   = new ArrayList();
        PreparedStatement statement = null;
        Order o = null;
        Item i  = null;
        int     customerNo    = 0, 
                itemNo        = 0, 
                qty           = 0, 
                state         = 0, 
                totalAmount   = 0;
        String  itemName, date = "";
        
        String SQLString =  "SELECT * FROM ordre NATURAL JOIN ordredetails NATURAL JOIN varer WHERE ordreno = ?";
        
        try
        {
            statement       = conn.prepareStatement(SQLString);
            statement.setInt(1, ono);
            ResultSet rs    = statement.executeQuery();
            while (rs.next())
            {
                itemNo         = rs.getInt(1);
                customerNo     = rs.getInt(3);
                state          = rs.getInt(4);
                date           = rs.getString(5);
                qty            = rs.getInt(6);
                itemName       = rs.getString(7);
                totalAmount    = rs.getInt(8);
                i = new Item(itemNo, itemName, qty);
                items.add(i);
            }
            o = new Order(customerNo, items, date);
        }
        
        catch (Exception e)
        {
            System.out.println("Fejl i TheMapper - getSingleOrder");
        }
        
        return o;
    }

    public ArrayList<Item> getItems(Connection conn)
    {
//        Item i = null;
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

                Item i = new Item(vNo, vNa, vQtotal);
                itemsArr.add(i);
            }
        } catch (Exception e)
        {
            System.out.println("Fejl i TheMapper - getItems");
        }

        return itemsArr;
    }

    public ArrayList<Customer> getCustomer(Connection conn)
    {
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
        } catch (Exception ex)
        {
            System.out.println("Error in TheMapper - getCustomer");
            System.out.println(ex.getMessage());
        }
        return customer;
    }

    /**
     * Write to database
     */
    public boolean saveOrder(ArrayList<Order> order, Connection con) throws SQLException
    {
//        
//        con.setAutoCommit(false);
        System.out.println(order.size() + "order size");
        int rowsInserted = 0;
        int tal = 0;
        String SQLString1 = "insert into ordre values(?,?,?,?)";
        String SQLString2 = "insert into ordreDetails values(?,?,?)";
        String SQLString3 = "select ordreseq.nextval from dual";


        
        PreparedStatement statement = null;
        for (int j = 0; j < order.size(); j++)
        {
            Order otest = order.get(j);

            if (otest.getOrderNo() != 0)
            {
                tal++;
            }
        }

        
        try
        {
            statement = con.prepareStatement(SQLString3);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {

                for (int k = tal; order.size() > k; k++)
                {

                    Order o = order.get(k);

                    o.setOrderNo(rs.getInt(1));
                }
            }

            statement = con.prepareStatement(SQLString1);


            for (int j = tal; j < order.size(); j++)
            {
                Order o = order.get(j);
                statement.setInt(1, o.getOrderNo());
                statement.setInt(2, o.getCustomer().getCustomerID());
                statement.setInt(3, o.getState());
                statement.setString(4, o.getDateString());

                rowsInserted += statement.executeUpdate();
            }


            if (rowsInserted == order.size() - tal)
            {
                rowsInserted = 0;
                statement = con.prepareStatement(SQLString2);

                for (int i = tal; i < order.size(); i++)
                {
                    Order o = order.get(i);
                    System.out.println(tal + "tal til for");
                    for (int j = 0; j < o.getItemlist().size(); j++)
                    {
                        statement.setInt(1, o.getItemlist().get(j).getItemNo());
                        statement.setInt(2, o.getItemlist().get(j).getItemAmount());
                        statement.setInt(3, o.getOrderNo());
                        rowsInserted += statement.executeUpdate();
                    }

                }
            } else
            {
                System.out.println("Fejl i OrdreMapper - Part 1");
            }

        } catch (Exception e)
        {
            System.out.println("Fejl i OrdreMapper - SaveOrder");
            e.printStackTrace();
        }
        System.out.println(rowsInserted + "row");
        System.out.println(order.size()- tal + "size");
        return rowsInserted == order.get(tal).getItemlist().size();

    }

    public boolean saveAvailableItem(ArrayList<Item> freeItems, Connection con) throws SQLException
    {
//        con.setAutoCommit(false);
        int rowsInserted = 0;
        String SQLString1 = "update tilrådighed set antal = ? where varerNo = ?";

        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);

            for (int i = 0; i < freeItems.size(); i++)
            {
                statement.setInt(1, freeItems.get(i).getItemAmount());
                statement.setInt(2, freeItems.get(i).getItemNo());
                rowsInserted += statement.executeUpdate();
            }







        } catch (Exception e)
        {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return true;

    }

    public boolean saveCustomer(ArrayList<Customer> customer, Connection con)
    {

        int rowsInserted = 0;
        String SQLString1 = "insert into kunde values(?,?)";
        String SQLString2 = "select kundeseq.nextval from dual";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                for (int j = 0; customer.size() > j; j++)
                {
                    Customer o = customer.get(j);
                    o.setCustomerID(rs.getInt(1));
                }

                statement = con.prepareStatement(SQLString1);
                for (int i = 0; i < customer.size(); i++)
                {
                    Customer cus = customer.get(i);
                    statement.setInt(1, customer.get(i).getCustomerID());
                    statement.setString(2, customer.get(i).getName());
                }

            }





            rowsInserted += statement.executeUpdate();



        } catch (Exception e)
        {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == customer.size();

    }

    public ArrayList<Item> getAvailableItem(Connection conn)
    {
//       
        String SQLString = "SELECT * FROM tilrådighed";

        PreparedStatement statement = null;
        ArrayList<Item> availableItem = new ArrayList();
        try
        {
            statement = conn.prepareStatement(SQLString);


            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                int itemNo = rs.getInt(1);
                int availableItemCount = rs.getInt(2);
                String itemName = rs.getString(3);
                Item i = new Item(itemNo, itemName, availableItemCount);
                availableItem.add(i);
            }
        } catch (Exception ex)
        {
            System.out.println("Error in TheMapper - getAvailableItem");
            System.out.println(ex.getMessage());
        }
        return availableItem;
    }
    public void commit(Connection con) throws SQLException
    {
        con.commit();
    }
    
public boolean increaseItem(ArrayList<Item> newItems, Connection con)
    {
        int rowsInserted = 0;
        int nyTotal;
        String SQLString1 = "Select antal from varer where varerNo = ?";
        String SQLString2 = "Select antal from tilrådighed where varerNo = ?";
        String SQLString3 = "update varer set antal = ? where varerNo = ?";
        String SQLString4 = "update tilrådighed set antal = ? where varerNo = ?";

        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString1);
            
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
            for (int i = 0; i < newItems.size(); i++)
            {
                
                statement.setInt(1, newItems.get(i).getItemNo());
                int bums = rs.getInt(3);
                Item it = newItems.get(i);
                nyTotal = bums  +  it.getItemAmount();
                
                statement = con.prepareStatement(SQLString3);
                
                statement.setInt(1, nyTotal);
                statement.setInt(2, newItems.get(i).getItemNo());
                rowsInserted += statement.executeUpdate();
                
            }
            }
            
            
                statement = con.prepareStatement(SQLString2);

               while (rs.next())
            {
            for (int i = 0; i < newItems.size(); i++)
            {
                
                statement.setInt(1, newItems.get(i).getItemNo());
                int bums = rs.getInt(3);
                Item it = newItems.get(i);
                nyTotal = bums  +  it.getItemAmount();
                
                statement = con.prepareStatement(SQLString4);
                
                statement.setInt(1, nyTotal);
                statement.setInt(2, newItems.get(i).getItemNo());
                
                rowsInserted += statement.executeUpdate();
            }
            }


        } catch (Exception e)
        {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return newItems.size()*2 == rowsInserted;

    }
}

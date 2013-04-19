/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import domain.Customer;
import domain.Order;
import domain.Item;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

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
        ArrayList<Order> orders = new ArrayList();
        ArrayList<Item> items = new ArrayList();
        PreparedStatement statement = null;
        Order o = null;
        Item i = null;
        int tjek = 0;
        int orderNo = 0,
                customerNo = 0,
                itemNo = 0,
                qty = 0,
                state = 0,
                totalAmount = 0;
        String itemName = "";
        Calendar cal = Calendar.getInstance();
        Date depositumdate = cal.getTime(), bestillingsdate = cal.getTime();
        String SQLString = "SELECT * FROM ordre NATURAL JOIN ordredetails NATURAL JOIN varer";
        try
        {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                itemNo = rs.getInt(1);
                orderNo = rs.getInt(2);
                customerNo = rs.getInt(3);
                state = rs.getInt(4);
                qty = rs.getInt(5);
                depositumdate = rs.getDate(6);
                bestillingsdate = rs.getDate(7);
                itemName = rs.getString(8);
                totalAmount = rs.getInt(9);
                if(tjek != orderNo && tjek != 0)
                {
                    o = new Order(tjek, items, depositumdate, bestillingsdate);
                    orders.add(o);
                    i = new Item(itemNo, itemName, qty);
                    
                    items.add(i);
                }else
                {
                    System.out.println("tjek 2");
                    i = new Item(itemNo, itemName, qty);
                    items.add(i);
                
                }
                tjek = rs.getInt(2);
                
                    
                
            }
            if(rs.next() == false)
            {
                o = new Order(orderNo, items, depositumdate, bestillingsdate);
                orders.add(o);
                System.out.println(items);
            }
        } catch (Exception e)
        {
            System.out.println("Fejl i TheMapper - getAllOrders");
        }
        System.out.println(orders.size());
        System.out.println(orders);
        return orders;
    }

    public Order getSingleOrder(int ono, Connection conn)
    {
        ArrayList<Item> items = new ArrayList();
        PreparedStatement statement = null;
        Order o = null;
        Item i = null;
        int customerNo = 0,
                itemNo = 0,
                qty = 0,
                state = 0,
                totalAmount = 0;
        String itemName = "";
        Calendar cal = Calendar.getInstance();
        Date depositumdate = cal.getTime(), bestillingsdate = cal.getTime();

        String SQLString = "SELECT * FROM ordre NATURAL JOIN ordredetails NATURAL JOIN varer WHERE ordreno = ?";

        try
        {
            statement = conn.prepareStatement(SQLString);
            statement.setInt(1, ono);
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                itemNo = rs.getInt(1);
                customerNo = rs.getInt(3);
                state = rs.getInt(4);
                depositumdate = rs.getDate(5);
                bestillingsdate = rs.getDate(6);
                qty = rs.getInt(7);
                itemName = rs.getString(8);
                totalAmount = rs.getInt(9);
                i = new Item(itemNo, itemName, qty);
                items.add(i);
            }
            o = new Order(customerNo, items, depositumdate, bestillingsdate);
        } catch (Exception e)
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

//        con.setAutoCommit(false);
        int rowsInserted = 0;
        int tal = 0;
        String SQLString1 = "insert into ordre values(?,?,?)";
        String SQLString2 = "insert into ordreDetails values(?,?,?,?,?)";
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


                rowsInserted += statement.executeUpdate();
            }


            if (rowsInserted == order.size() - tal)
            {
                rowsInserted = 0;
                statement = con.prepareStatement(SQLString2);

                for (int i = tal; i < order.size(); i++)
                {
                    Order o = order.get(i);
                    for (int j = 0; j < o.getItemlist().size(); j++)
                    {
                        statement.setInt(1, o.getItemlist().get(j).getItemNo());
                        statement.setInt(2, o.getItemlist().get(j).getItemAmount());
                        statement.setInt(3, o.getOrderNo());
                        java.sql.Date sqlDate = new java.sql.Date(o.getDepositumDate().getTime());
                        java.sql.Date sqlDate2 = new java.sql.Date(o.getBestillingsDate().getTime());
                        statement.setDate(4, sqlDate);
                        statement.setDate(5, sqlDate2);
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

    
    public boolean increaseItem(ArrayList<Item> newItems, Connection con) {
        int rowsInserted = 0;
        String SQLString2 = "update varer set varerantaltotal = ? where varerNo = ?";

        PreparedStatement statement2 = null;

        try 
        {
            statement2 = con.prepareStatement(SQLString2);
         
            for (int j = 0; j < newItems.size(); j++)
            {
                statement2.setInt(2, newItems.get(j).getItemNo());
                statement2.setInt(1, newItems.get(j).getAmountTotal());

                int rows = statement2.executeUpdate();
                if (rows != 0)
                {
                    System.out.println("INCREASEITEM VIRKER");
                }
                else
                {
                    System.out.println("INCREASEITEM VIRKER IKKE");
                }
            }
            

        } catch (Exception e) 
        {
            System.out.println("Fejl i OrdreMapper - increaseItem");
            e.printStackTrace();
        }
        
        return newItems.size() == rowsInserted;

    }
     public boolean saveNewItem(ArrayList<Item> newItem, Connection con)
    {

        int rowsInserted = 0;
        String SQLString1 = "insert into varer values(?,?,?)";
        String SQLString2 = "select varerseq.nextval from dual";
        PreparedStatement statement = null;

        try
        {
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
            if (rs.next())
            {
                for (int j = 0; newItem.size() > j; j++)
                {
                    Item it = newItem.get(j);
                    it.setItemNo(rs.getInt(1));
                }

                statement = con.prepareStatement(SQLString1);
                for (int i = 0; i < newItem.size(); i++)
                {
                    Item ni = newItem.get(i);
                    statement.setInt(1,newItem.get(i).getItemNo());
                    statement.setString(2, newItem.get(i).getItemName());
                    statement.setInt(3, newItem.get(i).getItemAmount());
                }

            }





            rowsInserted += statement.executeUpdate();



        } catch (Exception e)
        {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == newItem.size();

    }

    
}

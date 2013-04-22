package datasource;

import domain.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Thomas Kragsberger
 */
public class DBFacade
{
    private static DBFacade instance;
    private TheMapper tm;
    private Connection con;
//    private static DBFacade instance;

    public DBFacade()
    {
        tm = new TheMapper();
        con = new DBConnector().getConnection();

    }

    public static DBFacade getInstance()
    {
        if (instance == null)
        {
            instance = new DBFacade();
        }
        return instance;
    }

    public Order loadSingleOrder(int ono)
    {
        return tm.getSingleOrder(ono, con);
    }
    
    public ArrayList<Order> loadAllOrders()
    {
        return tm.getAllOrders(con);
    }

    public ArrayList getCustomer()
    {
//        System.out.println("dbfacade her");
        return tm.getCustomer(con);
    }

    public ArrayList getVare()
    {
//        System.out.println("DBFacade");
        return tm.getItems(con);
    }

    public boolean saveOrder(ArrayList<Order> o) throws SQLException
    {
    
        return tm.saveOrder(o, con);
    }

    public boolean saveItem(ArrayList<Item> i) throws SQLException
    {
        return tm.saveAvailableItem(i, con);
    }
    public boolean saveCustomer(ArrayList<Customer> customer){
        return tm.saveCustomer(customer, con);
    }
    public ArrayList getAvailableItems(){
    return tm.getAvailableItem(con);
    }
    
    public void commit() throws SQLException
    {
        tm.commit(con);
    }
    public boolean increaseAmount(ArrayList<Item> it){
    
    return tm.increaseItem(it, con);
    }
    
    public boolean saveNewItem(ArrayList<Item> it)
    {
        return tm.saveNewItem(it, con);
    }
    
     public boolean saveEmployee(ArrayList<Employee> employee){
        return tm.saveEmployee(employee, con);
    }
   
}

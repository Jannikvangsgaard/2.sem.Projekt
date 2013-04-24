/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import domain.Customer;
import domain.Employee;
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
public class TheMapper {

    /**
     * Read from database
     */
    public ArrayList<Order> getAllOrders(Connection conn) {
        ArrayList<Order> orders = new ArrayList();
        ArrayList<Item> itemlist = new ArrayList();
        PreparedStatement statement = null;
        Order o = null;
        int tjek = 0;
        int orderNo = 0;
        String SQLString = "SELECT * FROM ordre NATURAL JOIN ordredetails NATURAL JOIN varer";
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                o = getSingleOrder(orderNo = rs.getInt(2), conn);
                if (orders.isEmpty()) {
                    orders.add(o);
                } else if (orders.get(tjek).getOrderNo() != o.getOrderNo()) {
                    orders.add(o);
                    tjek++;
                }
            }
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getAllOrders");
        }
        return orders;
    }

    public Order getSingleOrder(int ono, Connection conn) {
        ArrayList<Item> items = new ArrayList();
        PreparedStatement statement = null;
        Order o = null;
        Item i = null;
        int orderNo = 0,
                itemNo = 0,
                qty = 0,
                state = 0,
                totalAmount = 0,
                customerNo = 0;
        String itemName = "";
        Customer customer = null;
        Calendar cal = Calendar.getInstance();
        Date depositumdate = cal.getTime(), bestillingsdate = cal.getTime();

        String SQLString = "SELECT * FROM ordre NATURAL JOIN ordredetails NATURAL JOIN varer WHERE ordreno = ?";
        try {
            statement = conn.prepareStatement(SQLString);
            statement.setInt(1, ono);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                itemNo = rs.getInt(1);
                orderNo = rs.getInt(2);
                customerNo = rs.getInt(3);
                state = rs.getInt(4);
                depositumdate = rs.getDate(6);
                bestillingsdate = rs.getDate(7);
                qty = rs.getInt(5);
                itemName = rs.getString(8);
                totalAmount = rs.getInt(9);
                customer = getSingleCustomer(conn, customerNo);
                i = new Item(itemNo, itemName, qty);
                items.add(i);
            }
            o = new Order(orderNo, items, depositumdate, bestillingsdate, customer, state);
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getSingleOrder");
        }
        return o;
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

    public Customer getSingleCustomer(Connection conn, int cno) {
//        System.out.println("themapper her");
        String SQLString = "SELECT * FROM kunde WHERE kundeno = ?";

        PreparedStatement statement = null;
        Customer c = null;
        try {
            //Get order
            statement = conn.prepareStatement(SQLString);
            statement.setInt(1, cno);


            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int customerNo = rs.getInt(1);
                String customerName = rs.getString(2);
                c = new Customer(customerNo, customerName);
            }
        } catch (Exception ex) {
            System.out.println("Error in TheMapper - getCustomer");
            System.out.println(ex.getMessage());
        }
        return c;
    }

    /**
     * Write to database
     */
    public int saveOrder(ArrayList<Order> order, Connection con) throws SQLException {

//        con.setAutoCommit(false);
        int rowsInserted = 0;
        int tal = 0;
        String SQLString1 = "insert into ordre values(?,?,?)";
        String SQLString2 = "insert into ordreDetails values(?,?,?,?,?)";
        String SQLString3 = "select ordreseq.nextval from dual";



        PreparedStatement statement = null;
        for (int j = 0; j < order.size(); j++) {
            Order otest = order.get(j);

            if (otest.getOrderNo() != 0) {
                tal++;
            }
        }


        try {
            statement = con.prepareStatement(SQLString3);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {

                for (int k = tal; order.size() > k; k++) {

                    Order o = order.get(k);

                    o.setOrderNo(rs.getInt(1));
                }
            }

            statement = con.prepareStatement(SQLString1);


            for (int j = tal; j < order.size(); j++) {
                Order o = order.get(j);
                statement.setInt(1, o.getOrderNo());
                statement.setInt(2, o.getCustomer().getCustomerID());
                statement.setInt(3, o.getState());


                rowsInserted += statement.executeUpdate();
            }


            if (rowsInserted == order.size() - tal) {
                rowsInserted = 0;
                statement = con.prepareStatement(SQLString2);

                for (int i = tal; i < order.size(); i++) {
                    Order o = order.get(i);
                    for (int j = 0; j < o.getItemlist().size(); j++) {
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
            } else {
                System.out.println("Fejl i OrdreMapper - Part 1");
            }

        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveOrder");
            e.printStackTrace();
        }
        return order.get(order.size()-1).getOrderNo();

    }


    public boolean saveCustomer(ArrayList<Customer> customer, Connection con) {

        boolean didItWork = false;
        String SQLString1 = "insert into kunde values(?,?,?,?,?,?,?)";
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
                    System.out.println(cus.getCustomerID());
                    statement.setInt(1, cus.getCustomerID());
                    statement.setString(2, cus.getName());
                    statement.setString(3, cus.getAddress());
                    statement.setString(4, cus.getPostnr());
                    statement.setString(5, cus.getBy());
                    statement.setString(6, cus.getEmail());
                    statement.setString(7, cus.getNr());
                    statement.executeQuery();
                    didItWork = true;
                }

            }

        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return didItWork;

    }


    public boolean increaseItem(ArrayList<Item> newItems, Connection con) {
        int rowsInserted = 0;
        String SQLString2 = "update varer set varerantaltotal = ? where varerNo = ?";

        PreparedStatement statement2 = null;

        try {
            statement2 = con.prepareStatement(SQLString2);

            for (int j = 0; j < newItems.size(); j++) {
                statement2.setInt(2, newItems.get(j).getItemNo());
                statement2.setInt(1, newItems.get(j).getAmountTotal());

                int rows = statement2.executeUpdate();
                if (rows != 0) {
                    System.out.println("INCREASEITEM VIRKER");
                } else {
                    System.out.println("INCREASEITEM VIRKER IKKE");
                }
            }


        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - increaseItem");
            e.printStackTrace();
        }

        return newItems.size() == rowsInserted;

    }

    public boolean saveNewItem(ArrayList<Item> newItem, Connection con) {

        int rowsInserted = 0;
        String SQLString1 = "insert into varer values(?,?,?)";
        String SQLString2 = "select varerseq.nextval from dual";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                for (int j = 0; newItem.size() > j; j++) {
                    Item it = newItem.get(j);
                    it.setItemNo(rs.getInt(1));
                }

                statement = con.prepareStatement(SQLString1);
                for (int i = 0; i < newItem.size(); i++) {
                    Item ni = newItem.get(i);
                    statement.setInt(1, newItem.get(i).getItemNo());
                    statement.setString(2, newItem.get(i).getItemName());
                    statement.setInt(3, newItem.get(i).getItemAmount());
                }

            }

            rowsInserted += statement.executeUpdate();



        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == newItem.size();

    }

    public boolean deleteItem(int itemNo, Connection con) {

        boolean rowsInserted = true;
        String SQLString1 = "delete from varer where varerno = ?";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
            statement.setInt(1, itemNo);

            if (statement.executeUpdate()==0){
                return false;
            }
            
            


        } catch (Exception e) {
            System.out.println("TheMapper fejl - Varen findes i en ordre" );
        }
        return rowsInserted;

    }

    public boolean saveEmployee(ArrayList<Employee> employee, Connection con) {

        int rowsInserted = 0;
        String SQLString1 = "insert into medarbejder values(?,?,?,?,?,?,?,?)";
        String SQLString2 = "select medarbejderseq.nextval from dual";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                for (int j = 0; employee.size() > j; j++) {
                    Employee o = employee.get(j);
                    o.setEmployeeID(rs.getInt(1));
                }

                statement = con.prepareStatement(SQLString1);
                for (int i = 0; i < employee.size(); i++) {
                    Employee emp = employee.get(i);
                    statement.setInt(1, emp.getEmployeeID());
                    statement.setString(2, emp.getName());
                    statement.setString(3, emp.getPosition());
                    statement.setString(4, emp.getPhoneNumber());
                    statement.setString(5, emp.getEmail());
                    statement.setString(6, emp.getZipCode());
                    statement.setString(7, emp.getAdress());
                    statement.setString(8, emp.getCity());
                }

            }

            rowsInserted += statement.executeUpdate();

        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == employee.size();

    }
    
      public boolean updateDepositum(Order o, Connection con) {
        int rowsInserted = 0;
        String SQLString1 = "update ordre set state = ? where ordreNo = ?";

        PreparedStatement statement2 = null;

        try 
        {
            statement2 = con.prepareStatement(SQLString1);
         
            {
                statement2.setInt(2, o.getOrderNo());
                statement2.setInt(1, o.getState() );

                statement2.executeUpdate();
          
            }
            

        } catch (Exception e) 
        {
            System.out.println("Fejl i OrdreMapper - increaseItem");
            e.printStackTrace();
        }
        
        return 1 == rowsInserted;

    }
      
        public Employee getSingleEmployee(int eno, Connection conn) {
       
          String SQLString = "SELECT * FROM medarbejder NATURAL JOIN medarbejderdetails where medarbejderNo = ? ";

        PreparedStatement statement = null;
        ArrayList dates = new ArrayList();
        String position = "";
        String employeeName = "";
        int employeeID = 0;
        String number = "";
        String email = "";
        String zipCode = "";
        String adresse = "";
        String city = "";
        Date dato;
        
        Employee e = null;
        try {
            //Get order
            statement = conn.prepareStatement(SQLString);
            statement.setInt(1, eno);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                position = rs.getString(3);
                employeeName = rs.getString(2);
                employeeID = rs.getInt(1);
                dato = rs.getDate(9);
                number = rs.getString(4);
                email = rs.getString(5);
                zipCode = rs.getString(6);
                adresse = rs.getString(7);
                city = rs.getString(8);
                dates.add(dato);
            }
            
             e = new Employee(employeeID, employeeName, position,number , email ,zipCode, city , adresse, dates);
        } catch (Exception ex) {
            System.out.println("Error in TheMapper - getEmployees");
            System.out.println(ex.getMessage());
        }
        return e;
    }
        
        
        public ArrayList<Employee> getAllEmployees(Connection conn) {
         
        ArrayList<Employee> employees = new ArrayList();
        PreparedStatement statement = null;
        Employee es = null;
        int tjek = 0;
        int employeeNo = 0;
        String SQLString = "SELECT * FROM medarbejder NATURAL JOIN medarbejderdetails";
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                es = getSingleEmployee(employeeNo = rs.getInt(1), conn);
                if (employees.isEmpty()) {
                    employees.add(es);
                } else if (employees.get(tjek).getEmployeeID() != es.getEmployeeID()) {
                    employees.add(es);
                    tjek++;
                }
            }
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getAllOrders");
        }
        return employees;
    }
        
}

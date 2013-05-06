/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;
import domain.Package;
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
                customerNo = 0,
                price = 0; 
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
                price = rs.getInt(10);
                customer = getSingleCustomer(conn, customerNo);
                i = new Item(itemNo, itemName, qty, price);
                items.add(i);
            }
            o = new Order(orderNo, items, depositumdate, bestillingsdate, customer, state);
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getSingleOrder");
        }
        return o;
    }

    public ArrayList<Item> getItems(Connection conn) {
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
                int price = rs.getInt(4);

                Item i = new Item(vNo, vNa, vQtotal, price);
                itemsArr.add(i);
            }
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getItems");
        }

        return itemsArr;
    }

    public ArrayList<Customer> getCustomer(Connection conn) {
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
                String customerAdresse = rs.getString(3);
                String customerPostNr = rs.getString(4);
                String customerTown = rs.getString(5);
                String customerEmail = rs.getString(6);
                String customerNummer = rs.getString(7);
                Customer c = new Customer(customerNo, customerName, customerAdresse, customerPostNr, customerTown, customerEmail, customerNummer);
                customer.add(c);
            }
        } catch (Exception ex) {
            System.out.println("Error in TheMapper - getCustomer");
            System.out.println(ex.getMessage());
        }
        return customer;
    }

    public Customer getSingleCustomer(Connection conn, int cno) {
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
                        java.sql.Date sqlDate2 = new java.sql.Date(o.getorderDate().getTime());
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
        int tal = 0;
        String SQLString1 = "insert into kunde values(?,?,?,?,?,?,?)";
        String SQLString2 = "select kundeseq.nextval from dual";
        PreparedStatement statement = null;

                   for (int j = 0; j < customer.size(); j++) {
            Customer ctest = customer.get(j);

            if (ctest.getCustomerID()!= 0) {
                tal++;
            }
        }
        
        try {
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                for (int j = tal; customer.size() > j; j++) {
                    Customer o = customer.get(j);
                    o.setCustomerID(rs.getInt(1));
                }

                statement = con.prepareStatement(SQLString1);
                for (int i = tal; i < customer.size(); i++) {
                    Customer cus = customer.get(i);
                    statement.setInt(1, cus.getCustomerID());
                    statement.setString(2, cus.getName());
                    statement.setString(3, cus.getAddress());
                    statement.setString(4, cus.getZip());
                    statement.setString(5, cus.getTown());
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

        boolean didItWork = true;
        String SQLString1 = "insert into varer values(?,?,?,?)";
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
                    statement.setInt(1, ni.getItemNo());
                    statement.setString(2, ni.getItemName());
                    statement.setInt(3, ni.getItemAmount());
                    statement.setInt(4, ni.getPrice());
                }

            }

            statement.executeUpdate();



        } catch (Exception e) {
            didItWork = false;
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return didItWork;

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

        boolean didItWork = true;
        int tal=0;
        String SQLString1 = "insert into medarbejder values(?,?,?,?,?,?,?,?)";
        String SQLString2 = "select medarbejderseq.nextval from dual";
        String SQLString3 = "insert into medarbejderdetails values(?,?)";
        PreparedStatement statement = null;
        Calendar cal = Calendar.getInstance();
        Date joinDate = cal.getTime();
        java.sql.Date sqlDate = new java.sql.Date(joinDate.getTime());
        
        
           for (int j = 0; j < employee.size(); j++) {
            Employee etest = employee.get(j);

            if (etest.getEmployeeID()!= 0) {
                tal++;
            }
        }
        
        

        try {
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                for (int j = tal; employee.size() > j; j++) {
                    Employee o = employee.get(j);
                    o.setEmployeeID(rs.getInt(1));
                }

                statement = con.prepareStatement(SQLString1);
                for (int i = tal; i < employee.size(); i++) {
                    Employee emp = employee.get(i);
                    statement.setInt(1, emp.getEmployeeID());
                    statement.setString(2, emp.getName());
                    statement.setString(3, emp.getPosition());
                    statement.setString(4, emp.getPhoneNumber());
                    statement.setString(5, emp.getEmail());
                    statement.setString(6, emp.getZipCode());
                    statement.setString(7, emp.getAdress());
                    statement.setString(8, emp.getCity());
                    statement.executeUpdate();
                    
                }
                statement = con.prepareStatement(SQLString3);
                for(int k = tal; k<employee.size(); k++){
                    Employee em = employee.get(k);
                    statement.setInt(1,em.getEmployeeID());
                    statement.setDate(2, sqlDate);
//                statement.setInt(3, em.getOrdreNo());
                    
                }

            }

            statement.executeUpdate();

        } catch (Exception e) {
            didItWork = false;
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return didItWork;

    }
    
      public boolean updateDepositum(Order o, Connection con) {
          boolean didItWork = true;
          String SQLString1 = "update ordre set state = ? where ordreNo = ?";

        PreparedStatement statement2 = null;

        try 
        {
            statement2 = con.prepareStatement(SQLString1);
         
            {
                statement2.setInt(2, o.getOrderNo());
                statement2.setInt(1, o.getState());

                statement2.executeUpdate();
          
            }
            

        } catch (Exception e) 
        {
            didItWork = false;
            System.out.println("Fejl i OrdreMapper - increaseItem");
            e.printStackTrace();
        }
        
        return didItWork;

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
                
                number = rs.getString(4);
                email = rs.getString(5);
                zipCode = rs.getString(6);
                adresse = rs.getString(7);
                city = rs.getString(8);
                dato = rs.getDate(9);
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
        boolean tjek = false;
        int employeeNo = 0;
        String SQLString = "SELECT * FROM medarbejder NATURAL JOIN medarbejderdetails";
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                es = getSingleEmployee(employeeNo = rs.getInt(1), conn);
                if (employees.isEmpty()) {
                    employees.add(es);
                }else
                {
//                    tjek = 1;
                for(int i = 0; i < employees.size(); i++)
                {
                if (employees.get(i).getEmployeeID() != es.getEmployeeID()) {
                    tjek = true;
                }else
                {
                    for(int j = 0; j < employees.get(i).getDates().size(); j++)
                    {
                    if(!employees.get(i).getDates().get(j).equals(es.getDates().get(j)))
                    {
                        employees.get(i).getDates().add(es.getDates().get(j));
                    }
                    }
                    tjek = false;
                    break;
                }
                }
                if(tjek)
                {
                    employees.add(es);
                }
                }
            }
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getAllEmployees");
        }
        return employees;
    }
        
        public boolean giveEmployeeDate(ArrayList<Employee> employeeDates, Connection con) {

        int rowsInserted = 0;
        String SQLString1 = "insert into medarbejderdetails values(?,?,?)";
        PreparedStatement statement = null;

        try {
            statement = con.prepareStatement(SQLString1);
      
                statement = con.prepareStatement(SQLString1);
                
                for (int i = 0; i < employeeDates.size(); i++) {
                    
                    Employee ed = employeeDates.get(i);
                    statement.setInt(1, ed.getEmployeeID());
                    java.sql.Date sqlDate = new java.sql.Date(ed.getDato().getTime());
                    statement.setDate(2, sqlDate);
                    statement.setInt(3, ed.getOrdreNo());
                }

            

            rowsInserted += statement.executeUpdate();



        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == employeeDates.size();

    }
        
        public boolean saveEmployeeWithDate(Employee em, Connection con) {

        int rowsInserted = 0;
        String SQLString1 = "insert into medarbejderdetails values(?,?)";
        PreparedStatement statement = null;
        ArrayList<Date> dates = new ArrayList();
        dates = em.getDates();

        try {
            statement = con.prepareStatement(SQLString1);
            
            
            for (int j = 0; dates.size() > j; j++) {
                    Date date = dates.get(j);
                    
                    statement.setInt(1, em.getEmployeeID());
                    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
                    statement.setDate(2, sqlDate);
                    rowsInserted += statement.executeUpdate();
            }

            



        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == dates.size();

    }
        
        
        
     public boolean saveItemList(ArrayList<Package> packList, Connection con) {

        int rowsInserted = 0;
        int tal = 0;
        String SQLString1 = "insert into pakker values(?,?,?)";
        String SQLString2 = "select pakkeseq.nextval from dual";
        String SQLString3 = "insert into pakkedetails values(?,?,?)";
        PreparedStatement statement = null;

           for (int j = 0; j < packList.size(); j++) {
            Package ptest = packList.get(j);

            if (ptest.getPackageNo() != 0) {
                tal++;
            }
        }
        
        
        try {
            
            
            statement = con.prepareStatement(SQLString2);
            ResultSet rs = statement.executeQuery();
             if (rs.next()) {
                for (int j = tal; packList.size() > j; j++) {
                    Package pk = packList.get(j);
                    pk.setPakkeNo(rs.getInt(1));
                }
             }
             
             statement = con.prepareStatement(SQLString1);
              for (int j = tal; j < packList.size(); j++) {
                Package pk = packList.get(j);
                statement.setInt(1, pk.getPackageNo());
                statement.setString(2, pk.getPackageName());
                statement.setInt(3, pk.getPrice());


                rowsInserted += statement.executeUpdate();
            }
              
              statement = con.prepareStatement(SQLString3);

              
                for (int i = tal; i < packList.size(); i++) {
                    Package pk = packList.get(i);
                    for (int j = 0; j < pk.getItems().size(); j++) {
                        statement.setInt(2, pk.getItems().get(j).getItemNo());
                        statement.setInt(1, pk.getPackageNo());
                        statement.setInt(3, pk.getItems().get(j).getItemAmount());
                        rowsInserted += statement.executeUpdate();
                    }
                }

        } catch (Exception e) {
            System.out.println("Fejl i OrdreMapper - SaveNewProject");
            e.printStackTrace();
        }
        return rowsInserted == packList.size();

    }
     
      public Package getSinglePackages(int packNo, Connection conn) {
        ArrayList<Item> itemlist = new ArrayList();
        PreparedStatement statement = null;
        Package p = null;
        Item i = null;
        int packageNo = 0;
        String packageName = "";
        int price = 0;
        int itemNo = 0;
        int amount = 0;
        
        String SQLString = "SELECT * FROM pakker NATURAL JOIN pakkedetails where pakkeNo = ?";
        try {
            
            statement = conn.prepareStatement(SQLString);
            statement.setInt(1, packNo);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
            packageNo = rs.getInt(1);
            packageName = rs.getString(2);
            price = rs.getInt(3);
            itemNo = rs.getInt(4);
            amount = rs.getInt(5);
            
            i = new Item(amount,itemNo);
            itemlist.add(i);
            }
            p = new Package(packageNo, packageName, itemlist, price);
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getAllOrders");
        }
        return p;
    }

      
      public ArrayList<Package> getAllPackages(Connection conn) {
        ArrayList<Package> packages = new ArrayList();
        PreparedStatement statement = null;
        Package p = null;
        int tjek = 0;
        int packNo = 0;
        String SQLString = "SELECT * FROM pakker NATURAL JOIN pakkedetails";
        try {
            statement = conn.prepareStatement(SQLString);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                p = getSinglePackages(packNo = rs.getInt(1), conn);
                if (packages.isEmpty()) {
                    packages.add(p);
                } else if (packages.get(tjek).getPackageNo() != p.getPackageNo()) {
                    packages.add(p);
                    tjek++;
                }
            }
        } catch (Exception e) {
            System.out.println("Fejl i TheMapper - getAllOrders");
        }
        return packages;
    }
    public boolean deleteTestEmployees(Connection con)
    {
        boolean didItWork = true;
        ArrayList<Integer> empno = new ArrayList();
        
        String SQLString1 = "SELECT medarbejderno "
                          + "FROM medarbejder "
                          + "WHERE navn = 'test'";
        
        String SQLString2 = "DELETE FROM medarbejderdetails "
                           +"WHERE medarbejderno = ?";
        
        String SQLString3 = "DELETE FROM medarbejder"
                          + " WHERE navn = 'test'";
        
        
        PreparedStatement statement = null;
        try 
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                empno.add(rs.getInt(1));
            }

            statement = con.prepareStatement(SQLString2);
            for(int i = 0; i < empno.size(); i++)
            {
                statement.setInt(1, empno.get(i));
                if(statement.executeUpdate() == 0)
                {
                    didItWork = false;
                }
            }
            
            statement = con.prepareStatement(SQLString3);
            if(statement.executeUpdate() == 0)
            {
                didItWork = false;
            }
        }
        
        
        catch (Exception e)
        {
            System.out.println("Fejl i TheMapper - deleteTestEmployees");
            didItWork = false;
        }
        
        return didItWork;
    }
    
    public boolean deleteTestOrders(Connection con)
    {
        boolean didItWork = true;
        ArrayList<Integer> onos = new ArrayList(); //Indeholder ordrenumre på testordre
        
        String SQLString1 = "SELECT ordreno FROM ordre WHERE kundeno = 1";
        String SQLString2 = "DELETE FROM ordredetails WHERE ordreno = ?";
        String SQLString3 = "DELETE FROM ordre WHERE ordreno = ?";
        
        
        PreparedStatement statement = null;
        try 
        {
            statement = con.prepareStatement(SQLString1);
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                onos.add(rs.getInt(1)); //OrdreNo på ordre fra testperson
            }
            
            statement = con.prepareStatement(SQLString2);
            for(int i = 0; i < onos.size(); i++)
            {
                if(!onos.get(i).equals(999)) //999 er en testordre - må ikke slettes
                {
                    statement.setInt(1, onos.get(i));
                    if(statement.executeUpdate() == 0)
                    {
                        didItWork = false;
                    }
                }
            }
            
            statement = con.prepareStatement(SQLString3);
            for(int j = 0; j < onos.size(); j++)
            {
                if(!onos.get(j).equals(999))
                {
                    statement.setInt(1, onos.get(j));
                    if(statement.executeUpdate() == 0)
                    {
                        didItWork = false;
                    }
                }
            }
        }
        
        
        catch (Exception e)
        {
            System.out.println("Fejl i TheMapper - deleteTestOrdre");
            didItWork = false;
        }
        
        return didItWork;
    }
    
    public boolean deleteTestCustomers(Connection con) throws SQLException
    {
        boolean didItWork = true;

        String SQLString = "DELETE FROM kunde WHERE navn = 'testperson'";
        
        PreparedStatement statement = null;
        statement = con.prepareStatement(SQLString);
        
        try
        {
            if(statement.executeUpdate() == 0)
            {
                System.out.println("Ingen testkunder i databasen");
            }
        }
        catch(Exception e)
        {
            System.out.println("Fejl i TheMapper - deleteTestCustomers");
            didItWork = false;
        }
        
        return didItWork;
    }
    
    public boolean resetStateOnTestOrder(Connection con) throws SQLException
    {
        boolean didItWork = true;
        
        String SQLString = "UPDATE ordre SET state = 0 WHERE ordreno = 999";
        
        PreparedStatement statement = null;
        
        try
        {
            statement = con.prepareStatement(SQLString);
            
            if(statement.executeUpdate() == 0)
            {
                System.out.println("State på testordre (999) er allerede 0");
            }
            else {
                System.out.println("State på testordre (999) ændret til 0");
            }
        }
        catch(Exception ex)
        {
            System.out.println("Fejl i TheMapper - resetStateOnTestOrder");
            didItWork = false;
        }
        
        return didItWork;
    }
        
        
}
        


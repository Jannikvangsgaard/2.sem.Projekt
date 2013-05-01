package datasource;

import domain.Control;
import domain.Customer;
import domain.Employee;
import domain.Item;
import domain.Order;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jannik
 */
public class DBFacadeTest {
    Control c = new Control();
    
    public DBFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
@After
    public void tearDown() 
    {
        /**
         * Sletter de oprettede testpersoner fra databasen, efter den er kørt.
         */
//        DBFacade instance = new DBFacade();
//        instance.deleteTestPersons();
    }

    /**
     * Tester om metoden loadSingleOrder() henter vores "testordre" fra
     * databasen, som har ordrenummer 1000.
     */
    @Test
    public void testLoadSingleOrder() 
    {
        System.out.println("loadSingleOrder");
        c.loadAllOrders();
        DBFacade instance = new DBFacade();
        int expectedOrderNo = 1000;
        int actualOrderNo = instance.loadSingleOrder(1000).getOrderNo();
        
        assertEquals(expectedOrderNo, actualOrderNo);
    }

    /**
     * Tester om metoden loadAllOrders() henter noget fra databasen.
     */
    @Test
    public void testLoadAllOrders() 
    {
        System.out.println("loadAllOrders");
        DBFacade instance = new DBFacade();
        int result = instance.loadAllOrders().size();
        assertTrue(result > 0);
    }

    /**
     * Tester om metoden getCustomers() får kunder fra databasen.
     */
    @Test
    public void testGetCustomers() {
        System.out.println("getCustomer");
        DBFacade instance = new DBFacade();
        int result = instance.getCustomer().size();
        assertTrue(result > 0);
    }

    /**
     * Tester om der bliver hentet varer fra databasen.
     */
    @Test
    public void testGetVarer() {
        System.out.println("getVare");
        DBFacade instance = new DBFacade();
        int result = instance.getVare().size();
        assertTrue(result > 0);
    }

    /**
     * Tester om en ordre bliver gemt i databasen.
     */
    @Test
    public void testSaveOrder() throws Exception 
    {
        DBFacade instance = new DBFacade();
        Calendar cal = Calendar.getInstance();
        ArrayList<Order> o = new ArrayList();
        ArrayList<Item> i = new ArrayList();
        Date d = cal.getTime();
        c.loadItemliste();

        Customer cus = c.loadCustomerlist().get(0);
        Item it = c.getItemList().get(0);
        
        i.add(it);
        Order order = new Order(i, cus, d);
        o.add(order);
        
        assertFalse(instance.saveOrder(o).equals(null));
    }

    /**
     * Tilføjer en ny kunde til databasen.
     */
    @Test
    public void testSaveCustomer() {
        System.out.println("saveCustomer");
        ArrayList<Customer> customer = new ArrayList();
        Customer c = new Customer("testperson", "testadresse", "0000", "testby", "test@email.test", "00000000");
        customer.add(c);
        
        DBFacade instance = new DBFacade();
        boolean expResult = true;
        boolean result = instance.saveCustomer(customer);
        
        assertEquals(expResult, result);
    }
    
     /**
     * Opretter et "testitem" i databasen.
     */
    @Test
    public void testSaveNewItem() {
        System.out.println("saveNewItem");
        ArrayList<Item> it = new ArrayList();
        Item testitem = new Item(0, "testitem", 0, 0);
        it.add(testitem);
        
        DBFacade instance = new DBFacade();
        boolean expResult = true;
        boolean result = instance.saveNewItem(it);
        assertEquals(expResult, result);
    }
    
    /**
     * Ændre antallet af på det tidligere oprettede "testitem" i databasen.
     */
    @Test
    public void testIncreaseAmount() {
        System.out.println("increaseAmount");
        
        c.loadItemliste();
        c.getItemList();
        ArrayList<Item> it = new ArrayList();
        int x = 0;
        
        for(int i = 0; i < c.getItemList().size(); i++)
        {
            if(c.getItemList().get(i).getItemName().equals("testitem"))
            {
                x = i;
            }
        }
        
        c.getItemList().get(x).increaseTotalAmount(2);
        int amountBefore = c.getItemList().get(x).getAmountTotal();
        it.add(c.getItemList().get(x));
        c.increaseAmount(it);
        
        int expResult = amountBefore; 
        int result = c.getItemList().get(x).getAmountTotal();
        assertTrue(expResult == result);
    }
    
     /**
     * Sletter "testitem" fra databasen igen.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        int itemNo = 0;
        c.loadItemliste();
        c.getItemList();
        
        for(int i = 0; i < c.getItemList().size(); i++)
        {
            if(c.getItemList().get(i).getItemName().equals("testitem"))
            {
                itemNo = c.getItemList().get(i).getItemNo();
            }
        }
        
        DBFacade instance = new DBFacade();
        boolean expResult = true;
        boolean result = instance.deleteItem(itemNo);
        assertEquals(expResult, result);
    }

    /**
     * Opretter en medarbejder i databasen.
     */
    @Test
    public void testSaveEmployee() 
    {
        System.out.println("saveEmployee");
        ArrayList<Employee> e = new ArrayList();
        Employee employee = new Employee("test", "test", "00000000", "test@test.test", "0000", "test", "test");
        e.add(employee);
        
        DBFacade instance = new DBFacade();
        boolean expResult = true;
        boolean result = instance.saveEmployee(e);
        assertEquals(expResult, result);
    }



    /**
     * Tester om en ordres depositums-status bliver ændret.
     */
    @Test
    public void testUpdateOrder() 
    {
        
        System.out.println("updateOrder");
        c.loadAllOrders();
        ArrayList<Order> orders = c.getOrderlist();
        Order o = null;
        
        for(int i = 0; i < orders.size(); i++)
        {
            if(orders.get(i).getOrderNo() == 1000) //OrderNo 1000 er en test ordre
            {
                o = orders.get(i);
            }
        }
        
        o.setState(1);
        DBFacade instance = new DBFacade();
        boolean expResult = true;
        boolean result = instance.updateOrder(o);
        assertEquals(expResult, result);
    }

    /**
     * Henter alle medarbejdere fra databasen.
     */
    @Test
    public void testGetAllEmployees() 
    {
        System.out.println("getAllEmployees");
        DBFacade instance = new DBFacade();
        int result = instance.getAllEmployees().size();
        assertTrue(result > 0);
    }

}
package datasource;

import domain.Customer;
import domain.Employee;
import domain.Item;
import domain.Order;
import java.util.ArrayList;
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
    public void tearDown() {
    }

    /**
     * Test of getInstance method, of class DBFacade.
     */
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");
        DBFacade expResult = null;
        DBFacade result = DBFacade.getInstance();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadSingleOrder method, of class DBFacade.
     */
    @Test
    public void testLoadSingleOrder() {
        System.out.println("loadSingleOrder");
        int ono = 0;
        DBFacade instance = new DBFacade();
        Order expResult = null;
        Order result = instance.loadSingleOrder(ono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadAllOrders method, of class DBFacade.
     */
    @Test
    public void testLoadAllOrders() {
        System.out.println("loadAllOrders");
        DBFacade instance = new DBFacade();
        ArrayList expResult = null;
        ArrayList result = instance.loadAllOrders();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomer method, of class DBFacade.
     */
    @Test
    public void testGetCustomer() {
        System.out.println("getCustomer");
        DBFacade instance = new DBFacade();
        ArrayList expResult = null;
        ArrayList result = instance.getCustomer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVare method, of class DBFacade.
     */
    @Test
    public void testGetVare() {
        System.out.println("getVare");
        DBFacade instance = new DBFacade();
        ArrayList expResult = null;
        ArrayList result = instance.getVare();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveOrder method, of class DBFacade.
     */
    @Test
    public void testSaveOrder() throws Exception {
        System.out.println("saveOrder");
        ArrayList<Order> o = null;
        DBFacade instance = new DBFacade();
        int expResult = 0;
        int result = instance.saveOrder(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveCustomer method, of class DBFacade.
     */
    @Test
    public void testSaveCustomer() {
        System.out.println("saveCustomer");
        ArrayList<Customer> customer = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveCustomer(customer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of increaseAmount method, of class DBFacade.
     */
    @Test
    public void testIncreaseAmount() {
        System.out.println("increaseAmount");
        ArrayList<Item> it = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.increaseAmount(it);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveNewItem method, of class DBFacade.
     */
    @Test
    public void testSaveNewItem() {
        System.out.println("saveNewItem");
        ArrayList<Item> it = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveNewItem(it);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveEmployee method, of class DBFacade.
     */
    @Test
    public void testSaveEmployee() {
        System.out.println("saveEmployee");
        ArrayList<Employee> employee = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.saveEmployee(employee);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteItem method, of class DBFacade.
     */
    @Test
    public void testDeleteItem() {
        System.out.println("deleteItem");
        int itemNo = 0;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.deleteItem(itemNo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateOrder method, of class DBFacade.
     */
    @Test
    public void testUpdateOrder() {
        System.out.println("updateOrder");
        Order o = null;
        DBFacade instance = new DBFacade();
        boolean expResult = false;
        boolean result = instance.updateOrder(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllEmployees method, of class DBFacade.
     */
    @Test
    public void testGetAllEmployees() {
        System.out.println("getAllEmployees");
        DBFacade instance = new DBFacade();
        ArrayList expResult = null;
        ArrayList result = instance.getAllEmployees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}

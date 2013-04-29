package jtest;

import domain.Control;
import domain.Customer;
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
public class ControlTest extends Control {
    ArrayList<Customer> cus = new ArrayList();
    Control c = new Control();

    public ControlTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testCreateCustomer() {
      int a = 0;
        if (c.getCustomerlist().isEmpty()){
            c.loadCustomerlist();
        }
        a = c.getCustomerlist().size()-1;
        for (int i=0; i<c.getCustomerlist().size(); i++){
            if (c.getCustomerlist().get(i).getName().equals("testperson")){
                assertTrue(c.getCustomerlist().get(i).getName().matches("testperson"));
            } else if (i==a){
               if (!c.getCustomerlist().get(i).getName().equals("testperson")){
                   c.createCustomer("testperson", "testaddress", "test", "test", "test@test.test", "testtest");
                   
               }
            }
            
        }
        cus = c.getCustomerlist();
        c.saveCustomer(cus);
        
    }
}

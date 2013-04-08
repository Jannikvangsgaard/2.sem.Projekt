/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Control;
import domain.Customer;
import domain.Item;
import domain.Order;
import java.util.ArrayList;

/**
 *
 * @author Mike
 */
public class Main {
    
    public static void main(String[] args) {
        Control c = new Control();
//         c.getCustomerlist().get(0);
//         c.getCustomerlist().get(1);
//        ArrayList  customer= new ArrayList();
//        customer = c.getCustomerlist();
//        for (int i = 0; i < customer.size(); i++)
//        {
//            System.out.println(customer.get(i));
//        }
//        ArrayList  item= new ArrayList();
//        item = c.getItemliste();
//        for (int i = 0; i < item.size(); i++)
//        {
//            System.out.println(item.get(i));
//        }
        ArrayList order = new ArrayList();
       ArrayList varer = new ArrayList();
       ArrayList customerlist = new ArrayList();
       Item i = new Item(1024,"glas",4);
       Item i2 = new Item(1023,"hoppeborg",2);
       Customer customer = new Customer("Mike");
       customerlist.add(customer);
       c.saveCustomer(customerlist);
       varer.add(i);
       varer.add(i2);
       Order o = new Order(varer, customer);
       order.add(o);
       c.saveOrder(order);
        
    }
    
    
    
    
   
    
}

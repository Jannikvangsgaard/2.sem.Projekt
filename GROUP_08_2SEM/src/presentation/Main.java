/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Control;
import domain.Item;
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
        ArrayList  customer= new ArrayList();
        customer = c.getCustomerlist();
        for (int i = 0; i < customer.size(); i++)
        {
            customer.get(i);
        }
        ArrayList  item= new ArrayList();
        item = c.getItemliste();
        for (int i = 0; i < item.size(); i++)
        {
            System.out.println(item.get(i));
        }
        
        
    }
    
    
    
    
   
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domain.Control;

/**
 *
 * @author Mike
 */
public class Main {
    
    public static void main(String[] args) {
        Control c = new Control();
         
        
//        for (int i = 0; i < c.getCustomerlist().size(); i++)
//        {
//            c.getCustomerlist().get(i);
//        }
        
        for (int i = 0; i < c.getItemliste().size(); i++)
        {
            c.getItemliste().get(i).toString();
        }
        
        
    }
    
    
    
    
   
    
}

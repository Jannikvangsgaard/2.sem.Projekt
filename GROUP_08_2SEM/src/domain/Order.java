package domain;

import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Order {
    private int orderNo;
    private int customerID;
    private int state;
    private ArrayList<Item> itemlist = new ArrayList<Item>();
    public Order(int no, ArrayList<Item> itemliste){
      this.orderNo = no;
      itemlist = itemliste;          
      state=0;        
              
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int ordreNo) {
        this.orderNo = ordreNo;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int kundeID) {
        this.customerID = kundeID;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    
    
        
}

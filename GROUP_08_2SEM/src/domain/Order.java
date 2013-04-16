package domain;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Jannik
 */
public class Order {
    private int orderNo;
    private int state;
    private Customer customer;
    private ArrayList<Item> itemlist = new ArrayList<Item>();
    private String dateToString = "";
    @Override
    public String toString()
    {
        return "Ordre nummer " + orderNo + ", state " + state;
    }
    
    
    public Order(ArrayList<Item> itemlist, Customer customer){
      this.itemlist = itemlist;          
      state=0;        
      this.customer = customer;        
      Calendar calendar = Calendar.getInstance();
      calendar.add(Calendar.DATE, 3);
      Date date = (Date) calendar.getTime();
      dateToString = new SimpleDateFormat("y M d").format(date);
    }
   
    public Order(int orderNo, ArrayList<Item> itemlist, String date){
    
        this.orderNo = 0;
        this.itemlist = itemlist;
        state = 0;
        dateToString = date;
    }
    public Customer getCustomer(){
        return customer;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int ordreNo) {
        this.orderNo = ordreNo;
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
    public String getDateString(){
        return dateToString;
    }

    
    
        
}

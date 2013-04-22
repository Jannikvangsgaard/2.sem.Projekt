package domain;

import java.util.Date;
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
    private Date depositumDate;
    private Date bestillingsDate;

    @Override
    public String toString() {
        return "Ordre nummer " + orderNo + ", state " + state;
    }

    public Order(ArrayList<Item> itemlist, Customer customer, Date bestillingsDate) {
        this.itemlist = itemlist;
        state = 0;
        this.customer = customer;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 3);
        Date date = (Date) calendar.getTime();
        depositumDate = date;
        this.bestillingsDate = bestillingsDate;
//      java.sql.Date sqlDate = new java.sql.Date(date.getTime());
//      dateToString = new SimpleDateFormat("y M d").format(sqlDate);

    }

    public Order(int orderNo, ArrayList<Item> itemlist, Date depositumDate, Date bestillingsDate, Customer customer, int state) {

        this.orderNo = orderNo;
        this.itemlist = itemlist;
        this.state = state;
        this.bestillingsDate = bestillingsDate;
        this.depositumDate = depositumDate;
        this.customer = customer;
    }

    public Customer getCustomer() {
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

    public Date getDepositumDate() {
        return depositumDate;
    }

    public Date getBestillingsDate() {
        return bestillingsDate;
    }
    public void setBestillingsDate(Date date){
        bestillingsDate = date;
    }

    public String getDepositumDateToString() {
        String res = "";

        java.sql.Date sqlDate = new java.sql.Date(depositumDate.getTime());
        res = new SimpleDateFormat("y M d").format(sqlDate);
        return res;
    }

    public String getBestillingsDateToString() {
        String res = "";

        java.sql.Date sqlDate = new java.sql.Date(bestillingsDate.getTime());
        res = new SimpleDateFormat("y M d").format(sqlDate);
        return res;
    }
}

package domain;

import datasource.DBFacade;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Jannik
 */
public class Control {

    private ArrayList<Item> itemlist = new ArrayList<Item>();
    private ArrayList<Item> itemlistReserved = new ArrayList<Item>();
    private ArrayList<Item> availableItems = new ArrayList<Item>();
    private ArrayList<Order> orderlist = new ArrayList<Order>();
    private ArrayList<Customer> customerlist = new ArrayList<Customer>();
    private DBFacade dbf;

    public Control() {
        dbf = new DBFacade().getInstance();
    }

    public ArrayList<Item> allItemList()
    {
        return dbf.getVare();
    }
    
    public void createItem(int number, String itemName, int amount) {
        Item item = new Item(number, itemName, amount);
        itemlist.add(item);
    }

    public void checkDate() throws ParseException {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Item item1, item2, item3;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < orderlist.size(); i++) {
            c2.setTime(sdf.parse(orderlist.get(i).getDateString()));
            if (c1.after(c2)) {
                orderlist.get(i).setState(2);
                for (int j = 0; j < orderlist.get(i).getItemlist().size(); j++) {
                    item1 = orderlist.get(i).getItemlist().get(j);
                    for (int k = 0; k < availableItems.size(); k++) {
                        item2 = availableItems.get(k);
                        if (item2 == item1) {
                            availableItems.get(k).setItemAmount(item2.getItemAmount() + item1.getItemAmount());
                            orderlist.get(i).getItemlist().remove(j);
                        }
                    }
                    if (orderlist.get(i).getItemlist().size() > 0) {
                        for (int kusse = 0; kusse < orderlist.size(); kusse++) {
                            item3 = orderlist.get(i).getItemlist().get(kusse);
                            availableItems.add(item3);
                        }

                    }
                }
            }
        }
    }

    public ArrayList<Item> getItemList() {
        return itemlist;
    }

    public void createOrder(ArrayList<Item> itemliste2, Customer customer) {
        Order order = new Order(itemliste2, customer);
        orderlist.add(order);
    }

    public Order loadOrderList(int ono) {
        return dbf.loadSingleOrder(ono);
    }

    public ArrayList loadItemliste() {
        itemlist = dbf.getVare();
        return itemlist;
    }

    public void createCustomer(String name) {
        if (name != null) {
            Customer c = new Customer(name);
            customerlist.add(c);
            dbf.saveCustomer(customerlist);
        }

    }

    public ArrayList<Order> getOrderlist() {
        return orderlist;
    }

    public ArrayList<Customer> getCustomerlist() {
        customerlist = dbf.getCustomer();
        return customerlist;
    }

    public String customerToString() {
        String res = "";
        for (int i = 0; i < customerlist.size(); i++) {
            res += customerlist.get(i).toString() + "\n";
        }
        return res;
    }

    public void reservedItem() {
        for (int i = 0; i < orderlist.size(); i++) {
            for (int j = 0; j < orderlist.get(i).getItemlist().size(); j++) {
                itemlistReserved.add(orderlist.get(i).getItemlist().get(j));
                System.out.println(itemlistReserved);

            }
        }
    }

    public void availableItems() {
        Item item1, item2, item3;
        if (availableItems.size() > 0) {
            availableItems.clear();
        }
        for (int i = 0; i < itemlist.size(); i++) {
            for (int j = 0; j < itemlistReserved.size(); j++) {
                if (itemlist.get(i) == itemlistReserved.get(j) && itemlist.get(i).getItemAmount() >= itemlistReserved.get(j).getItemAmount()) {
                    item1 = itemlist.get(j);
                    item2 = itemlistReserved.get(i);
                    item3 = item1;
                    item3.setItemAmount(item1.getItemAmount() - item2.getItemAmount());
                    if (item3.getItemAmount() > 0) {
                        availableItems.add(item3);
                    }
                }
            }
            if (itemlist.get(i).getItemAmount() > 0) {
                availableItems.add(itemlist.get(i));
            }
        }
    }

    public ArrayList<Item> getAvailableItems() {
        return availableItems;
    }

    public void saveFreeItems(ArrayList<Item> test) throws SQLException {
        dbf.saveItem(test);
    }

    public boolean saveOrder() throws SQLException {
        return dbf.saveOrder(orderlist);
    }

    public void saveCustomer(ArrayList<Customer> customer) {
        dbf.saveCustomer(customer);
    }

    public void loadAvailableItems() {
        availableItems = dbf.getAvailableItems();
    }

    public Order loadSingleOrder(int ono) {
        return dbf.loadSingleOrder(ono);
    }

    public void loadAllOrders() {
        System.out.println(dbf.loadAllOrders().size());
        orderlist = dbf.loadAllOrders();
    }

    public void commit() throws SQLException {
        dbf.commit();
    }
}

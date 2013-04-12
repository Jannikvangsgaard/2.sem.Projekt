package domain;

import datasource.DBFacade;
import java.util.ArrayList;

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

    public void createItem(int number, String itemName, int amount) {
        Item item = new Item(number, itemName, amount);
        itemlist.add(item);
    }

    public ArrayList<Item> getItemList() {
        return itemlist;
    }

    public void createOrder(ArrayList<Item> itemliste2, Customer customer) {
        Order order = new Order(itemliste2, customer);
        orderlist.add(order);
    }
    public void loadOrderList(int ono){
    orderlist = dbf.getOrder(ono);
    }
    
    public ArrayList loadItemliste() {
        itemlist = dbf.getVare();
        return itemlist;
    }

    public void createCustomer(String name) {
        if (customerlist != null || customerlist.size() >= 1) {
            int TISSEMAND = customerlist.size() - 1;
            Customer customer = new Customer(name);
            customer.setCustomerID(customerlist.get(TISSEMAND).getCustomerID() + 1);
            customerlist.add(customer);
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
            res += customerlist.get(i).getName() + "\n";
        }
        return res;
    }

    public void reservedItem() {
        System.out.println("reservedItem");
        for (int i = 0; i < orderlist.size(); i++) {
            for (int j = 0; j < orderlist.get(i).getItemlist().size(); j++) {
                itemlistReserved.add(orderlist.get(i).getItemlist().get(j));
                System.out.println(itemlistReserved);

            }
        }
    }

    public void availableItems() {
        System.out.println("availableItems");
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

    public void saveFreeItems() {
        dbf.saveItem(availableItems);
    }

    public boolean saveOrder() {
        return dbf.saveOrder(orderlist);
    }

    public void saveCustomer(ArrayList<Customer> customer) {
        dbf.saveCustomer(customer);
    }
    public void setAvailableItems(){
       availableItems = dbf.getAvailableItems();
        System.out.println(availableItems+"setAvaiableItems");
     }
}

package domain;

import datasource.DBFacade;
import java.util.ArrayList;

/**
 *
 * @author Jannik
 */
public class Control {

    private ArrayList<Item> itemlist = new ArrayList<Item>();
    private ArrayList<Order> orderlist = new ArrayList<Order>();
    private ArrayList<Customer> customerlist = new ArrayList<Customer>();
    private ArrayList<Item> itemlistReserved = new ArrayList<Item>();
    private ArrayList availableItems = new ArrayList();
    private DBFacade dbf = new DBFacade();
    
            
    public void createItem(int number,String itemName, int amount) {
        Item item = new Item(number,itemName, amount);
        itemlist.add(item);

    }

    public void createOrder(int orderNo, ArrayList<Item> Itemliste) {
        Order order = new Order(orderNo, Itemliste);
        orderlist.add(order);
    }

    public ArrayList getItemliste() {
        itemlist = dbf.getVare();
        return itemlist;
    }

    public void createCustomer(int id, String name) {
        if (customerlist!=null){
         int TISSEMAND = customerlist.size()-1;
        Customer customer = new Customer(id, name);
        customer.setCustomerID(customerlist.get(TISSEMAND).getCustomerID()+1);
        customerlist.add(customer);
        }
    }

    public ArrayList getOrderlist() {
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
        for (int i=0;i<orderlist.size();i++){
        for (int j=0;j<orderlist.get(i).getItemlist().size();j++){
            itemlistReserved.add(orderlist.get(j).getItemlist().get(j));
            
        }    
        }
    }
    public void availableItems(){
        for (int i=0; i<itemlistReserved.size();i++){
            for (int j=0; j<itemlist.size();j++){
                if (itemlist.get(j)==itemlistReserved.get(i)){
                    availableItems.add(itemlist.get(j).getItemAmount()-itemlistReserved.get(j).getItemAmount());
                }
            }
        }
    }
}

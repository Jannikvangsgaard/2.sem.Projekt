package domain;

import datasource.DBFacade;
import java.util.Date;
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
    private ArrayList<Item> allItemList = new ArrayList<Item>();
    private ArrayList<Order> orderlistWithDate = new ArrayList();
    private DBFacade dbf;

    public Control() {
        dbf = new DBFacade().getInstance();
    }

    public ArrayList<Item> allItemList()
    {
        allItemList = dbf.getVare();
        return allItemList;
    }
    
    public void createItem(int number, String itemName, int amount) {
        Item item = new Item(number, itemName, amount);
        itemlist.add(item);
    }

    public void checkDate() throws ParseException {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Item item1, item2, item3;
        SimpleDateFormat sdf = new SimpleDateFormat("y M d");
        for (int i = 0; i < orderlist.size(); i++) {
            c2.setTime(sdf.parse(orderlist.get(i).getDepositumDateToString()));
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
                        for (int l = 0; l < orderlist.size(); l++) {
                            item3 = orderlist.get(i).getItemlist().get(l);
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

    public void createOrder(ArrayList<Item> itemliste2, Customer customer, Date bestillingsDato) {
        Order order = new Order(itemliste2, customer, bestillingsDato);
        orderlist.add(order);
    }

    public Order loadOrderList(int ono) {
        return dbf.loadSingleOrder(ono);
    }

    public ArrayList loadItemliste() {
//        availableItems.clear();
//        itemlistReserved.clear();
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
    
    public Item creatItem(int itemNo, String itemName, int itemAmount)
    {
        Item item = new Item(itemNo, itemName, itemAmount);
        return item;
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
        int tjek=0;
        for (int i = 0; i < orderlistWithDate.size(); i++) {
            for (int j = 0; j < orderlistWithDate.get(i).getItemlist().size(); j++) {
                for (int k = 0; k<itemlistReserved.size(); k++){
                if (itemlistReserved.get(k).getItemNo()==orderlistWithDate.get(i).getItemlist().get(j).getItemNo()){
                itemlistReserved.get(k).setItemAmount(itemlistReserved.get(k).getItemAmount() + orderlistWithDate.get(i).getItemlist().get(j).getItemAmount());
                tjek++;
                }
                   
                
                }
                if (tjek == 0){
                itemlistReserved.add(orderlistWithDate.get(i).getItemlist().get(j));
                }
                tjek=0;
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
                if (itemlist.get(i).getItemNo() == itemlistReserved.get(j).getItemNo() && itemlist.get(i).getItemAmount() >= itemlistReserved.get(j).getItemAmount()) {
                    item1 = itemlist.get(i);
                    item2 = itemlistReserved.get(j);
                    item3 = item1;
                    item3.setItemAmount(item1.getItemAmount() - item2.getItemAmount());
//                    if (item3.getItemAmount() > 0) {
//                        availableItems.add(item3);
//                    }
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
        availableItems.clear();
        itemlistReserved.clear();
        orderlist = dbf.loadAllOrders();
    }

    public void commit() throws SQLException {
        dbf.commit();
    }
    public boolean increaseAmount(ArrayList<Item> increasedItem){
    
        return dbf.increaseAmount(increasedItem);
    }
        public boolean varelisteTjek(ArrayList<Item> tjekListe)
    {
        boolean status = false;
        for (int i = 0; i < tjekListe.size(); i++)
        {
            for (int j = 0; j < availableItems.size(); j++)
            {
                if (availableItems.get(j).getItemNo() == tjekListe.get(i).getItemNo())
                {
                    if (availableItems.get(j).getItemAmount() > tjekListe.get(i).getItemAmount())
                    {
                        status = true;
                    } else
                    {
                        status = false;
                    }
                }
            }
        }
        return status;
    }
        
    public boolean saveNewItem(ArrayList<Item> it)
    {
        return dbf.saveNewItem(it);
    }
    
     public void saveEmployee(ArrayList<Employee> employee) {
        dbf.saveEmployee(employee);
    }
     
    public void loadOrdersWithDate(Date dato){
        
        orderlistWithDate.clear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dato);
        int h = 0;
        for(int j = -1; h <2;j++){
        
            if(j==0){
            j=1;
            }
            if(j==2){
            j=1;
            h=3;
            }
            calendar.add(Calendar.DATE, j);
            System.out.println(j);
        
        for(int i = 0; i < orderlist.size();i++){
            System.out.println(
            calendar.getTime());
        if(orderlist.get(i).getBestillingsDate().equals(calendar.getTime())){
        orderlistWithDate.add(orderlist.get(i));
        }
        }
        }
        System.out.println(
        orderlistWithDate);
        reservedItem();
    
   
}
    public void clearOrderlist(){
        orderlistWithDate.clear();
    }
    public void deleteItem(Item item){
        for (int i=0; i<itemlist.size(); i++){
            if (item.equals(itemlist.get(i))){
                dbf.deleteItem(itemlist.get(i).getItemNo());
            }
        }
    }
}

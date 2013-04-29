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
public class Control
{

    private ArrayList<Item> itemlist = new ArrayList<Item>();
    private ArrayList<Item> itemlistReserved = new ArrayList<Item>();
    private ArrayList<Item> availableItems = new ArrayList<Item>();
    private ArrayList<Order> orderlist = new ArrayList<Order>();
    private ArrayList<Customer> customerlist = new ArrayList<Customer>();
    private ArrayList<Item> allItemList = new ArrayList<Item>();
    private ArrayList<Order> orderlistWithDate = new ArrayList();
    private ArrayList<Employee> employeesList = new ArrayList();
    private ArrayList<Employee> availableEmployees = new ArrayList();
    private DBFacade dbf;

    public Control()
    {
        dbf = new DBFacade().getInstance();
    }

    public ArrayList<Item> allItemList()
    {
        allItemList = dbf.getVare();
        return allItemList;
    }

    public void createItem(int number, String itemName, int amount, int price) {
        Item item = new Item(number, itemName, amount, price);
        itemlist.add(item);
    }

    public void checkDate()
    {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Item item1, item2, item3;
        for (int i = 0; i < orderlist.size(); i++)
        {
            c2.setTime(orderlist.get(i).getDepositumDate());
            if (c1.after(c2))
            {
                orderlist.get(i).setState(2);
                for (int j = 0; j < orderlist.get(i).getItemlist().size(); j++)
                {
                    item1 = orderlist.get(i).getItemlist().get(j);
                    if (orderlist.get(i).getItemlist().size() > 0)
                    {
                        for (int l = 0; l < orderlist.size(); l++)
                        {
                            item3 = orderlist.get(i).getItemlist().get(l);
                        }

                    }
                }
            }
        }
    }

    public ArrayList<Item> getItemList()
    {
        return itemlist;
    }

    public void createOrder(ArrayList<Item> itemliste2, Customer customer, Date bestillingsDato)
    {
        Order order = new Order(itemliste2, customer, bestillingsDato);
        orderlist.add(order);
    }

    public Order loadOrderList(int ono)
    {
        return dbf.loadSingleOrder(ono);
    }

    public ArrayList loadItemliste()
    {
        itemlist = dbf.getVare();
        return itemlist;
    }

    public void createCustomer(String name, String address, String postnr,
            String by, String email, String nr)
    {
        if (name != null && address != null && postnr != null && by != null
                && email != null && nr != null)
        {
            Customer c = new Customer(name, address, postnr, by, email, nr);
            customerlist.add(c);
        }

    }

    public Item creatItem(int itemNo, String itemName, int itemAmount, int price) {
        Item item = new Item(itemNo, itemName, itemAmount, price);
        return item;
    }

    public ArrayList<Order> getOrderlist()
    {
        return orderlist;
    }

    public ArrayList<Customer> loadCustomerlist()
    {
        customerlist = dbf.getCustomer();
        return customerlist;
    }

    public String customerToString()
    {
        String res = "";
        for (int i = 0; i < customerlist.size(); i++)
        {
            res += customerlist.get(i).toString() + "\n";
        }
        return res;
    }

    public void reservedItem()
    {
        int tjek = 0;
        for (int i = 0; i < orderlistWithDate.size(); i++)
        {
            for (int j = 0; j < orderlistWithDate.get(i).getItemlist().size(); j++)
            {
                for (int k = 0; k < itemlistReserved.size(); k++)
                {
                    if (itemlistReserved.get(k).getItemNo() == orderlistWithDate.get(i).getItemlist().get(j).getItemNo())
                    {
                        itemlistReserved.get(k).setItemAmount(itemlistReserved.get(k).getItemAmount() + orderlistWithDate.get(i).getItemlist().get(j).getItemAmount());
                        tjek++;
                    }
                }
                if (tjek == 0)
                {
                    itemlistReserved.add(orderlistWithDate.get(i).getItemlist().get(j));
                }
                tjek = 0;
            }
        }
        loadAllOrders();
    }

    public void availableItems()
    {
        Item item1, item2, item3;
        if (availableItems.size() > 0)
        {
            availableItems.clear();
        }
        for (int i = 0; i < itemlist.size(); i++)
        {
            for (int j = 0; j < itemlistReserved.size(); j++)
            {
                if (itemlist.get(i).getItemNo() == itemlistReserved.get(j).getItemNo() && itemlist.get(i).getItemAmount() >= itemlistReserved.get(j).getItemAmount())
                {
                    item1 = itemlist.get(i);
                    item2 = itemlistReserved.get(j);
                    item3 = item1;
                    item3.setItemAmount(item1.getItemAmount() - item2.getItemAmount());
                }
            }
            if (itemlist.get(i).getItemAmount() > 0)
            {
                availableItems.add(itemlist.get(i));
            }
        }
    }

    public ArrayList<Item> getAvailableItems()
    {
        return availableItems;
    }

    public int saveOrder() throws SQLException
    {
        return dbf.saveOrder(orderlist);
    }

    public void saveCustomer()
    {
        dbf.saveCustomer(customerlist);
    }

    public Order loadSingleOrder(int ono)
    {
        return dbf.loadSingleOrder(ono);
    }

    public void loadAllOrders()
    {
        orderlist = dbf.loadAllOrders();
    }

    public boolean increaseAmount(ArrayList<Item> increasedItem)
    {

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

    public void saveEmployee()
    {
        dbf.saveEmployee(employeesList);
    }

    public void loadOrdersWithDate(Date dato)
    {
        orderlistWithDate.clear();
        availableItems.clear();
        itemlistReserved.clear();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dato);
        int h = 0;
        for (int j = -1; h < 2; j++)
        {
            if (j == 0)
            {
                j = 1;
            }
            if (j == 2)
            {
                j = 1;
                h = 3;
            }
            calendar.add(Calendar.DATE, j);

            for (int i = 0; i < orderlist.size(); i++)
            {
                if (orderlist.get(i).getState() != 2 && orderlist.get(i).getBestillingsDate().equals(calendar.getTime()))
                {
                    orderlistWithDate.add(orderlist.get(i));
                }
            }
        }
        reservedItem();
        availableItems();


    }

    public void clearOrderlist()
    {
        orderlistWithDate.clear();
    }

    public void deleteItem(Item item)
    {

        dbf.deleteItem(item.getItemNo());
    }

    public boolean updateOrder(Order o)
    {
        return dbf.updateOrder(o);
    }

    public ArrayList<Employee> loadAllEmployees()
    {
        employeesList = dbf.getAllEmployees();
        return employeesList;
    }

    public String employeeToString()
    {
        String res = "";
        for (int i = 0; i < employeesList.size(); i++)
        {
            res += employeesList.get(i).toString() + "\n";
        }
        return res;
    }

    public void createEmployee(String name, String position, String phoneNumber, String email, String zipCode, String city, String adress)
    {
        Employee emp = new Employee(name, position, phoneNumber, email, zipCode, city, adress);
        employeesList.add(emp);
    }

    public ArrayList<Employee> checkEmployee(Date date)
    {
        availableEmployees.clear();
        int count = 0;
        String res = createDate(date);
        for (int i = 0; i < employeesList.size(); i++)
        {
            count = 0;
            for (int j = 0; j < employeesList.get(i).getDates().size(); j++)
            {
                String tjek = "" + employeesList.get(i).getDates().get(j);
                if (employeesList.get(i).getPosition().equals("Montør") && !tjek.equals(res) && count == 0)
                {
                    count++;
                    int empID = employeesList.get(i).getEmployeeID();
                    Employee emp = new Employee(empID, date, 0);
                    availableEmployees.add(emp);
                }
            }
        }
        return availableEmployees;
    }

    public ArrayList<Customer> getCustomerlist()
    {
        return customerlist;
    }

    public String createDate(java.util.Date utilDate)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String sqlDate = sdf.format(utilDate);
        return sqlDate;
    }
}

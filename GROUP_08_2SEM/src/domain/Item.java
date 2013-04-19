package domain;

/**
 *
 * @author Jannik
 */
public class Item
{
    private String itemName;
    private int itemNo;
    private int itemAmount;
    private int price;
    private int amountTotal;

    public Item(int itemNo, String itemName, int itemAmount)
    {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
    }
    public Item (int amountTotal){
        this.amountTotal = amountTotal;
    }

    public void increaseTotalAmount(int amount)
    {
        setAmountTotal(itemAmount+amount);
    }
    public int getPrice(){
        return price;
    }
    
    public String getItemName()
    {
        return itemName;
    }
    public void setPrice(int price){
        this.price = price;
    }

    public int getItemAmount()
    {
        return itemAmount;
    }

    public void setItemAmount(int ItemAmount)
    {
        this.itemAmount = ItemAmount;
    }

    public int getItemNo()
    {
        return itemNo;
    }

    public void setItemNo(int itemNo)
    {
        this.itemNo = itemNo;
    }
    
    public String toString()
    {
        return "ItemNo: " + itemNo + " Item name: " + itemName + " Item amount: " + itemAmount;
    }
    
    public String toStringGUI()
    {
        return itemName + " ledige: " + itemAmount;
    }
    
    public String toStringGUIReserved()
    {
        return itemName + " ønskede antal " + itemAmount;
    }
    public void setAmountTotal(int amount){
        this.amountTotal = amount;
    }
    public int getAmountTotal(){
        return amountTotal;
    }
}

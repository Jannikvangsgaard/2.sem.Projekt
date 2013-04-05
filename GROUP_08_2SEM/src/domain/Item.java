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
    

    public Item(int itemNo, String itemName, int itemAmount)
    {
        this.itemNo = itemNo;
        this.itemName = itemName;
        this.itemAmount = itemAmount;
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
}

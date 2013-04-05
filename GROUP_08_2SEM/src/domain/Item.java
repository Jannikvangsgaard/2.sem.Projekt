package domain;

/**
 *
 * @author Jannik
 */
public class Item
{
    private int itemNo;
    private int itemAmount;
    

    public Item(int itemNo, int itemAmount)
    {
        this.itemNo = itemNo;
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

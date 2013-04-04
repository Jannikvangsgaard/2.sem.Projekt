package domain;

/**
 *
 * @author Jannik
 */
public class Vare
{
    private int vareNo;
    private int vareAntal;
    

    public Vare(int vareNo, int vareAntal)
    {
        this.vareNo = vareNo;
        this.vareAntal = vareAntal;
    }


    public int getVareAntal()
    {
        return vareAntal;
    }

    public void setVareAntal(int vareAntal)
    {
        this.vareAntal = vareAntal;
    }

    public int getVareNo()
    {
        return vareNo;
    }

    public void setVareNo(int vareNo)
    {
        this.vareNo = vareNo;
    }
}

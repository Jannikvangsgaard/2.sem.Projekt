package domain;

/**
 *
 * @author Jannik
 */
public class Vare
{

    String vareNavn;
    int vareAntal;
    int vareNo;

    public Vare(String vareNavn, int vareAntal, int vareNo)
    {
        this.vareNavn = vareNavn;
        this.vareAntal = vareAntal;
        this.vareNo = vareNo;
    }

    public String getVareNavn()
    {
        return vareNavn;
    }

    public void setVareNavn(String vareNavn)
    {
        this.vareNavn = vareNavn;
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

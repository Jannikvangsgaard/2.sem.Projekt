package domain;

/**
 *
 * @author Jannik
 */
public class Vare
{

    String vareNavn;
    int vareAntal;
    String vareNo;

    public Vare(String vareNavn, int vareAntal, String vareNo)
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

    public String getVareNo()
    {
        return vareNo;
    }

    public void setVareNo(String vareNo)
    {
        this.vareNo = vareNo;
    }
}

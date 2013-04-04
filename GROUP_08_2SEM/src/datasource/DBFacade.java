package datasource;

import domain.*;
import java.sql.Connection;

/**
 *
 * @author Thomas Kragsberger
 */
public class DBFacade
{
    	  private Ordermapper om; 
	  private Connection con;
	  private static DBFacade instance;
	 
	  private DBFacade() {
		  om 	= new Ordremapper();
		  con 	= new DBConnector().getConnection(); 
		  							  
	  }
	  public static DBFacade getInstance()
	  {
		  if(instance == null)
			  instance = new DBFacade();
		  return instance;
	  }
          
          public Order getOrder(int ono) 
	  {
		  return om.getOrder(ono, con);	      
	  }
          
          public Kunde getKunde(int ono)
          {
              return om.getKunde(ono, con);
          }
          
          public boolean gemOrder(Ordre o)
          {
              return om.saveOrder(o, con);
          }
}

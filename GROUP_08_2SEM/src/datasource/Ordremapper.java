/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import domain.Ordre;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Mike
 */
public class Ordremapper {
    
    public boolean saveOrdre(ArrayList<Ordre> ordre, Connection con) {
		int rowsInserted = 0;
		String SQLString1 = "insert into ordre values(?,?,?)";
		String SQLString2 = "insert into ordreDetails values(?,?,?)";

		PreparedStatement statement = null;

		try {
			statement = con.prepareStatement(SQLString1);

			for (int i = 0; i < ordre.size(); i++) {
				Ordre o = ordre.get(i);
				statement.setInt(1, o.getOrdreNo());
				statement.setInt(2, o.getKundeID());
				statement.setInt(3, o.getState());

				rowsInserted += statement.executeUpdate();
			}

			if (rowsInserted == ordre.size()) {
				rowsInserted = 0;
				statement = con.prepareStatement(SQLString2);

				for (int i = 0; i < ordre.size(); i++) {
					Ordre o = ordre.get(i);
                                        
                                        for(int j = 0 ; j < o.getVareliste.size(); j++){
					statement.setInt(1, o.getVareliste(j));
					statement.setInt(2, o.getVareliste(j++));
                                        statement.setInt(3, o.getOrdreNo());
                                        }
					rowsInserted += statement.executeUpdate();
				}
			} else {
				System.out.println("Fejl i ProjectMapper - Part 1");
			}

		} catch (Exception e) {
			System.out.println("Fejl i ProjectMapper - SaveNewProject");
			e.printStackTrace();
		}
		return rowsInserted == ordre.size();

	}
    
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

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
				statement.setInt(1, o.getordreNo());
				statement.setInt(2, o.getkundeNo());
				statement.setInt(3, o.getState());

				rowsInserted += statement.executeUpdate();
			}

			if (rowsInserted == ordre.size()) {
				rowsInserted = 0;
				statement = con.prepareStatement(SQLString2);

				for (int i = 0; i < ordre.size(); i++) {
					Ordre o = ordre.get(i);
                                        
                                        for(int j = 0 ; j < o.getvarerArray.size(); j++){
					statement.setInt(1, o.getvarerArray(j));
					statement.setInt(2, o.getvarerArray(j++));
                                        statement.setInt(3, o.getordreNo());
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

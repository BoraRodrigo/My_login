package facear.edu.facear.dao;

import java.sql.Connection;
import java.sql.SQLException;

import br.edu.facear.util.ConectDB;
import br.edu.facear.util.MyClassException;

public class GenericDAO {
	private ConectDB db = new ConectDB();
	protected Connection con;
	
	public void opeConnection() throws SQLException, MyClassException {
		con= db.getConexao();
	}
	
	public void closeConnection() {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				System.out.println("Erro on Closing Connection");
			}
		}
	}
}

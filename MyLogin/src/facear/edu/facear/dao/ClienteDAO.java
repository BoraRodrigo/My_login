package facear.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.edu.facear.model.Cliente;
import br.edu.facear.util.ConectDB;
import br.edu.facear.util.MyClassException;

public class ClienteDAO extends GenericDAO {
	private PreparedStatement ps;
	private String LOGIN_SQL = "SELECT * FROM TB_CLIENTE WHERE EMAIL=? AND SENHA=?;";
	private String INSERIR="insert into TB_CLIENTE values(?,?,?,?);";
	
	public Cliente autenticar(String email, String senha) throws SQLException, MyClassException {
		Cliente c = null;
		opeConnection();// Abrir Conexão
		// Preparar Scrip
		ps = con.prepareStatement(LOGIN_SQL);
		ps.setString(1, email);
		ps.setString(2, senha);

		ResultSet rs = ps.executeQuery();// seleciona tudo
		if (rs != null) {
			while (rs.next()) {
				c = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("email"),
						rs.getString("senha"));
			}
		}
		closeConnection();
		return c;
	}
	public void  cadastrar(String email, String senha,String nome, String cpf) throws SQLException, MyClassException {
		Cliente c = null;
		opeConnection();
		
		ps=con.prepareStatement(INSERIR);
		ps.setString(1,nome);
		ps.setString(2,cpf);
		ps.setString(3,email);
		ps.setString(4,senha);
		
		ps.execute();
		ps.close();
		
		closeConnection();
		
	}
}

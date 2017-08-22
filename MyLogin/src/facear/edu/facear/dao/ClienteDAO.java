package facear.edu.facear.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Cliente;
import br.edu.facear.util.ConectDB;
import br.edu.facear.util.MyClassException;

public class ClienteDAO extends GenericDAO {
	private PreparedStatement ps;
	private String LOGIN_SQL = "SELECT * FROM TB_CLIENTE WHERE EMAIL=? AND SENHA=?;";
	private String INSERIR = "insert into TB_CLIENTE values(?,?,?,?);";

	private String LISTAR = "Select *from TB_CLIENTE";
	

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

	public void cadastrar(Cliente cliente) throws SQLException, MyClassException {
		opeConnection();

		ps = con.prepareStatement(INSERIR);
		ps.setString(1, cliente.getNome());
		ps.setString(2, cliente.getCpf());
		ps.setString(3, cliente.getEmail());
		ps.setString(4, cliente.getSenha());

		ps.execute();
		ps.close();

		closeConnection();

	}

	public List<Cliente> listarCliente() throws SQLException, MyClassException {
		opeConnection();

		List<Cliente> listaClientes = new ArrayList<>();
		ps = con.prepareStatement(LISTAR);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			Cliente c = new Cliente();
			c.setId(rs.getInt("id"));
			c.setNome(rs.getString("nome"));
			c.setCpf(rs.getString("cpf"));
			c.setEmail(rs.getString("email"));
			c.setSenha(rs.getString("senha"));

			listaClientes.add(c);
		}
		closeConnection();
		return listaClientes;
	}
	public void excluir() {
		
	}
}

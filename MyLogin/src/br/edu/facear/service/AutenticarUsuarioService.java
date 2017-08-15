package br.edu.facear.service;

import java.sql.SQLException;

import br.edu.facear.model.Cliente;
import br.edu.facear.util.MyClassException;
import facear.edu.facear.dao.ClienteDAO;

public class AutenticarUsuarioService {
	public Cliente autenticar(String email, String senha) throws MyClassException {
		ClienteDAO dao = new ClienteDAO();
		Cliente c = null;
		try {
			c = dao.autenticar(email, senha);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}
}

package br.edu.facear.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Cliente;
import br.edu.facear.util.MyClassException;
import facear.edu.facear.dao.ClienteDAO;

public class CadastrarUsuarioService {
	public Cliente cadastrar(String email, String senha,String nome, String cpf) throws SQLException, MyClassException {
	
		ClienteDAO dao = new ClienteDAO();
		Cliente c = new Cliente();
		c.setCpf(cpf);
		c.setEmail(email);
		c.setNome(nome);
		c.setSenha(senha);
		
		dao.cadastrar(c);
		
		return c;
	}
	public List<Cliente> listarClientes() throws SQLException, MyClassException{
		
		List <Cliente> listaCliente = new ArrayList<>();
		ClienteDAO dao = new ClienteDAO();
		
		listaCliente= dao.listarCliente();
		
		return listaCliente;
		
	}

}

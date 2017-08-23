package br.edu.facear.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.facear.model.Cliente;
import br.edu.facear.util.MyClassException;
import facear.edu.facear.dao.ClienteDAO;

public class CadastrarUsuarioService {
	public Cliente cadastrar(String nome, String cpf,String email, String senha) throws SQLException, MyClassException {
	
		ClienteDAO dao = new ClienteDAO();
		Cliente c = new Cliente();
		c.setNome(nome);
		c.setCpf(cpf);
		c.setEmail(email);
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
	public void excluir(int id) throws SQLException, MyClassException {
		
		ClienteDAO dao = new ClienteDAO();
		
		dao.excluir(id);
	}
	public Cliente alterar(String id,String email, String senha,String nome, String cpf) throws SQLException, MyClassException {
		
		Cliente c = new Cliente();
		ClienteDAO dao = new ClienteDAO();
		c.setId(Integer.parseInt(id));
		c.setCpf(cpf);
		c.setEmail(email);
		c.setNome(nome);
		c.setSenha(senha);
		
		dao.alterar(c);
		
		return c;
	}
	public  Cliente buscar (int id) throws SQLException, MyClassException {
		Cliente c= new Cliente();
		ClienteDAO dao= new ClienteDAO();
		
		c=dao.buscar(id);
		System.out.println("Nome do Cliente SERVICE "+c.getNome());
		return c;
		
	}
}

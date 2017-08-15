package br.edu.facear.service;

import br.edu.facear.model.Cliente;
import facear.edu.facear.dao.ClienteDAO;

public class CadastrarUsuarioService {
	public Cliente cadastrar(String email, String senha,String nome, String cpf) {
		ClienteDAO dao = new ClienteDAO();
		Cliente c = null;
		
		
		dao.cadastrar(email, senha, nome, cpf);
		
		return c;
	}

}

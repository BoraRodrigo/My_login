package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.CadastrarUsuarioService;
import br.edu.facear.util.MyClassException;

/**
 * Servlet implementation class AlterarUsuarioServlet
 */
@WebServlet("/AlterarUsuarioServlet")
public class AlterarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlterarUsuarioServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		
		CadastrarUsuarioService service = new  CadastrarUsuarioService();
		try {
			service.alterar(id,email, senha, nome, cpf);
			
			CadastrarUsuarioService service2= new CadastrarUsuarioService();
			service2.listarClientes();
		} catch (SQLException | MyClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

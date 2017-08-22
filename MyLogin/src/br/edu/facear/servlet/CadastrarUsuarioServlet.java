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
import br.edu.facear.service.AutenticarUsuarioService;
import br.edu.facear.service.CadastrarUsuarioService;
import br.edu.facear.util.MyClassException;
import facear.edu.facear.dao.ClienteDAO;

/**
 * Servlet implementation class CadastrarUsuarioServlet
 */
@WebServlet("/CadastrarUsuarioServlet")
public class CadastrarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage;
	    nextPage = "/Cadastrar.html";
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
		/// redirecionamento carrega nova pagina
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome"); 
		String cpf = request.getParameter("cpf");  
		String email = request.getParameter("email"); 
		String senha = request.getParameter("senha"); 
		
		CadastrarUsuarioService cadastrarUsuarioService = new CadastrarUsuarioService();
		try {
			cadastrarUsuarioService.cadastrar(nome, cpf,email,senha);
			
			String nextPage;
		    nextPage = "/Cadastrar.html";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
		
			rd.forward(request, response);
			
		} catch (SQLException | MyClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

package br.edu.facear.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.model.Cliente;
import br.edu.facear.service.AutenticarUsuarioService;
import br.edu.facear.util.MyClassException;

/**
 * Servlet implementation class AutenticarUsuarioServlet
 */
@WebServlet("/AutenticarUsuarioServlet")
public class AutenticarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AutenticarUsuarioServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Acesso negado!Filha da puta");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String email = request.getParameter("email");// pega o nome do login
		System.out.println("Olá " + email);

		String senha = request.getParameter("senha");// pega A senha do login
		System.out.println("Sua senha é " + senha);
		String nextPage = "/index.html";

		AutenticarUsuarioService service = new AutenticarUsuarioService();

		// Obter do banco de dados
		try {
			Cliente c = service.autenticar(email, senha);
			// Colocar na area de memoria de sessão
			request.setAttribute("cliente", c);
			if (c != null) {
				//nextPage = "/principal.jsp";// Somente paginas Jsp obtem informaçoes da sessão
				nextPage = "/Cadastrar.html";
			}
		} catch (MyClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
		/// redirecionamento carrega nova pagina
		rd.forward(request, response);

	}

}

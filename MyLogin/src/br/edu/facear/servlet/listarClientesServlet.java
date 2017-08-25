package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
 * Servlet implementation class listarClientesServlet
 */
@WebServlet("/listarClientesServlet")
public class listarClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public listarClientesServlet() {
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

		CadastrarUsuarioService service = new CadastrarUsuarioService();
		String nextPage = "/Cadastrar.html";
		try {

			List<Cliente> listaClientes = new ArrayList<>();
			listaClientes = service.listarClientes();

			request.setAttribute("listaClientes", listaClientes);
			nextPage = "/listarClientes.jsp";

		} catch (SQLException | MyClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(nextPage);
		/// redirecionamento carrega nova pagina
		rd.forward(request, response);
	}

}

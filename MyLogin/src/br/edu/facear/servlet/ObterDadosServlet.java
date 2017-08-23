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
import facear.edu.facear.dao.ClienteDAO;

/**
 * Servlet implementation class ObterDados
 */
@WebServlet("/ObterDadosServlet")
public class ObterDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ObterDadosServlet() {
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
		String id = request.getParameter("iid");

		System.out.println(id);

		String nextPage = "/alterar.jsp";

		CadastrarUsuarioService cadastrarUsuarioService = new CadastrarUsuarioService();
		try {
			Cliente cliente = new Cliente();
			cliente = cadastrarUsuarioService.buscar(Integer.parseInt(id));
			System.out.println("NOME DO CLIENTE SERVLET: " + cliente.getNome());
			request.setAttribute("cliente", cliente);
			nextPage = "/alterar.jsp";
		} catch (NumberFormatException | SQLException | MyClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextPage);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

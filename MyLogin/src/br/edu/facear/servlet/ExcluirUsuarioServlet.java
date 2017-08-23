package br.edu.facear.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.facear.service.CadastrarUsuarioService;
import br.edu.facear.util.MyClassException;

/**
 * Servlet implementation class ExcluirUsuarioServlet
 */
@WebServlet("/ExcluirUsuarioServlet")
public class ExcluirUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirUsuarioServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CadastrarUsuarioService service = new CadastrarUsuarioService();
		String id = request.getParameter("id");
		int ID = Integer.parseInt(id);
	
		
		try {
			service.excluir(ID);
			
			String nextPage="/listarClientes.jsp";
			
		    RequestDispatcher dispatcher= getServletContext().getRequestDispatcher(nextPage);
			dispatcher.forward(request, response);
			
			
		} catch (NumberFormatException | SQLException | MyClassException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

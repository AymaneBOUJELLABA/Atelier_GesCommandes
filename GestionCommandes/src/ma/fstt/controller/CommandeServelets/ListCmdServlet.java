package ma.fstt.controller.CommandeServelets;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Client;

/**
 * Servlet implementation class ListCmdServlet
 */
@WebServlet("/ListCommandes")
public class ListCmdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Inject
	private CommandeDAO dao;
	private ClientDAO clientDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListCmdServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		dao = new CommandeDAO();
		clientDAO = new ClientDAO();
		
		request.setAttribute("commandes", dao.selectAll());
		request.setAttribute("clients", clientDAO.selectAll());
		
		request.getServletContext().getRequestDispatcher("/vue/commande/commandes.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

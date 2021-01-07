package ma.fstt.controller.CommandeServelets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.CommandeDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Commande;

/**
 * Servlet implementation class DeletecmdServlet
 */
@WebServlet("/DeleteCommande")
public class DeletecmdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Inject
	private CommandeDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletecmdServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Commande cmd ;
		dao = new CommandeDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		cmd = dao.getCommandebyId(id);
		
		dao.delete(cmd);
		
		request.getServletContext().getRequestDispatcher("/ListCommandes").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

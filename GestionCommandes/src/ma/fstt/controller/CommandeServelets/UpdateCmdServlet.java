package ma.fstt.controller.CommandeServelets;

import java.io.IOException;
import java.sql.Date;

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
 * Servlet implementation class UpdateCmdServlet
 */
@WebServlet("/UpdateCommande")
public class UpdateCmdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CommandeDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCmdServlet() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Commande cmd;
		dao = new CommandeDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		cmd = dao.getCommandebyId(id);
		request.setAttribute("commande", cmd);
		
		request.getServletContext().getRequestDispatcher("/updateCommande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Commande cmd;
		dao = new CommandeDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		Date date = Date.valueOf(request.getParameter("date")) ;
		int id_client = Integer.parseInt(request.getParameter("id_client"));
		
		cmd = dao.getCommandebyId(id);
		
		cmd.setDate(date);
		cmd.setId_client(id_client);
		
		
		dao.update(cmd);
		
		request.getServletContext().getRequestDispatcher("/ListCommandes").forward(request, response);

	}

}

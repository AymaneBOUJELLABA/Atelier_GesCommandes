package ma.fstt.controller.CommandeServelets;

import java.io.IOException;
import java.text.SimpleDateFormat;
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
 * Servlet implementation class SaveCmdServlet
 */
@WebServlet("/SaveCommande")
public class SaveCmdServlet extends HttpServlet 
	{
	private static final long serialVersionUID = 1L;
	@Inject
	private CommandeDAO dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCmdServlet() 
    {
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
		
		Date date = Date.valueOf(request.getParameter("date"));
		int id_client = Integer.parseInt(request.getParameter("id_client"));
		
		cmd = new Commande(0,date,id_client);
		dao.save(cmd);
		
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

package ma.fstt.controller.ClientServelets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;
import javax.inject.Inject;
/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ClientDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Client cl ;
		dao = new ClientDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		cl = dao.getClientbyId(id);
		
		String err="";
		try
		{
			dao.delete(cl);
		}catch(SQLException e)
		{
			err = "Vous ne pouvez pas supprimer un client qui a une commande";
		}
			
		request.setAttribute("err",err);
		request.getServletContext().getRequestDispatcher("/ListClient").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

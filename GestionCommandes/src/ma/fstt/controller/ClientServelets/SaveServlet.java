package ma.fstt.controller.ClientServelets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.entities.Client;

/**
 * Servlet implementation class SaveServlet
 */
@WebServlet("/SaveServlet")
public class SaveServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Inject
	private ClientDAO dao;
    /**
     * Default constructor. 
     */
    public SaveServlet() 
    {
       super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Client client;
		dao = new ClientDAO();
		String name = request.getParameter("name") ;
		String email = request.getParameter("email") ;
		String adress = request.getParameter("address") ;
		
		client = new Client(0,name,email,adress);
		dao.save(client);
		
		request.getServletContext().getRequestDispatcher("/ListClient").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

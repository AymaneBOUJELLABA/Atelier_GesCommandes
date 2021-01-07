package ma.fstt.controller.ClientServelets;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/ListClient")
public class ListServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Inject
	private ClientDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		dao = new ClientDAO();
		request.setAttribute("ListClients", dao.selectAll());
		
		request.getServletContext().getRequestDispatcher("/vue/client/clients.jsp").forward(request, response);
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

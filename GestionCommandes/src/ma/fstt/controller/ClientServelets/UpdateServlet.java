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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Inject
	private ClientDAO dao;
       
   
    public UpdateServlet() 
    {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Client cl;
		dao = new ClientDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		cl = dao.getClientbyId(id);
		request.setAttribute("client", cl);
		
		request.getServletContext().getRequestDispatcher("/vue/client/updateClients.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Client cl;
		dao = new ClientDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name") ;
		String email = request.getParameter("email");
		String adress = request.getParameter("address");
		
		cl = dao.getClientbyId(id);
		
		cl.setName(name);
		cl.setEmail(email);
		cl.setAddress(adress);
		
		dao.update(cl);
		
		request.getServletContext().getRequestDispatcher("/ListClient").forward(request, response);
		
	}

}

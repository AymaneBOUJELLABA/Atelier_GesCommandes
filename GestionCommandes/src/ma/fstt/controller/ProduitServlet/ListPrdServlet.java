package ma.fstt.controller.ProduitServlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.ProduitDAO;

/**
 * Servlet implementation class ListPrdServlet
 */
@WebServlet("/ListProduit")
public class ListPrdServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@Inject
	private ProduitDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListPrdServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 dao = new ProduitDAO();
		request.setAttribute("produits", dao.selectAll());
		
		request.getServletContext().getRequestDispatcher("/vue/produit/produits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

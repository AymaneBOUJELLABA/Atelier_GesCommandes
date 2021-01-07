package ma.fstt.controller.ProduitServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.ProduitDAO;
import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class DeletePrdServlet
 */
@WebServlet("/DeleteProduit")
public class DeletePrdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Inject
	private ProduitDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePrdServlet() {
        super();
        // TODO Auto-generated constructor stub
        
		
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Produit prd ;
		dao = new ProduitDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		prd = dao.getProduitbyId(id);
		
		String err ="";
		try
		{
			dao.delete(prd);
		}catch(SQLException e)
		{
			err = "Impossible de supprimer le produit, il est utiliser dans une commande!";
		}
		request.getServletContext().getRequestDispatcher("/ListProduit").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

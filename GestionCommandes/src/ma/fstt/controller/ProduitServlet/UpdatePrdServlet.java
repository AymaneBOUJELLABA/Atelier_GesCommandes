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
import ma.fstt.entities.Client;
import ma.fstt.entities.Produit;

/**
 * Servlet implementation class UpdatePrdServlet
 */
@WebServlet("/UpdateProduit")
public class UpdatePrdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Inject
	private ProduitDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePrdServlet()
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Produit prd;
		dao = new ProduitDAO();
		int id = Integer.parseInt(request.getParameter("id"));
		
		prd = dao.getProduitbyId(id);
		request.setAttribute("produit", prd);
		
		request.getServletContext().getRequestDispatcher("/vue/produit/updateProduits.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Produit prd;
		dao = new ProduitDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		String label = request.getParameter("label") ;
		double price = Double.parseDouble(request.getParameter("price")) ;
		
		
		prd = dao.getProduitbyId(id);
		
		prd.setLabel(label);
		prd.setPrice(price);
		
		dao.update(prd);
		
		request.getServletContext().getRequestDispatcher("/ListProduit").forward(request, response);
		
	}

}

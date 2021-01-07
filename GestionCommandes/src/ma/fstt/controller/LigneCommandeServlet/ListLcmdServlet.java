package ma.fstt.controller.LigneCommandeServlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.ClientDAO;
import ma.fstt.dao.LigneCommandeDAO;
import ma.fstt.dao.ProduitDAO;

/**
 * Servlet implementation class ListLcmdServlet
 */
@WebServlet("/LignesDeCommande")
public class ListLcmdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Inject
	private LigneCommandeDAO dao;   
	private ProduitDAO produitDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListLcmdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		dao = new LigneCommandeDAO();
		produitDAO = new ProduitDAO();
		request.setAttribute("lignescommande", dao.selectAll());
		request.setAttribute("produits", produitDAO.selectAll());
		
		Integer id_cmd;
		if(request.getAttribute("id_commande")==null)
			id_cmd = Integer.parseInt(request.getParameter("id_commande"));
		else
			id_cmd = (Integer)request.getAttribute("id_commande");
			
		request.setAttribute("id_commande", id_cmd);
		
		request.getServletContext().getRequestDispatcher("/vue/commande/commandeDetails.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

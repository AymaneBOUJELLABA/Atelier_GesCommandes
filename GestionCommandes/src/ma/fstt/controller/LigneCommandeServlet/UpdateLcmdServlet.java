package ma.fstt.controller.LigneCommandeServlet;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ma.fstt.dao.LigneCommandeDAO;

import ma.fstt.entities.LigneCommande;

/**
 * Servlet implementation class UpdateLcmdServlet
 */
@WebServlet("/UpdateLigneCommande")
public class UpdateLcmdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Inject
	private LigneCommandeDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateLcmdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LigneCommande lcmd;
		dao = new LigneCommandeDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		lcmd = dao.getLigneCommandebyId(id);
		request.setAttribute("lcmd", lcmd);
		
		request.setAttribute("id_commande", lcmd.getId_commande());
		request.getServletContext().getRequestDispatcher("/vue/commande/updateLigneCommande.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LigneCommande lcmd;
		dao = new LigneCommandeDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int qte = Integer.parseInt(request.getParameter("qte")) ;
		int id_prd = Integer.parseInt(request.getParameter("id_produit"));
		
		int id_cmd = Integer.parseInt(request.getParameter("id_commande"));
		
		lcmd = dao.getLigneCommandebyId(id);
		
		lcmd.setQte(qte);
		lcmd.setId_produit(id_prd);
		lcmd.setId_commande(id_cmd);
		
		dao.update(lcmd);
		
		request.setAttribute("id_commande", lcmd.getId_commande());
		request.getServletContext().getRequestDispatcher("/LignesDeCommande").forward(request, response);
	
	}

}

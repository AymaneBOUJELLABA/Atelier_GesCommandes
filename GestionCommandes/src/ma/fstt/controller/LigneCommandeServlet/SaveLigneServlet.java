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
 * Servlet implementation class SaveLigneServlet
 */
@WebServlet("/SaveLigneCommande")
public class SaveLigneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private LigneCommandeDAO dao;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveLigneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		LigneCommande Lcmd;
		dao = new LigneCommandeDAO();
		
		int qte = Integer.parseInt(request.getParameter("qte") );
		int id_prd = Integer.parseInt(request.getParameter("id_produit") );
		
		int id_cmd = Integer.parseInt(request.getParameter("id_commande") ) ;

		Lcmd = new LigneCommande(0,qte,id_cmd,id_prd);
		
		dao.save(Lcmd);
		
		request.setAttribute("id_commande", Lcmd.getId_commande());
		request.getServletContext().getRequestDispatcher("/LignesDeCommande").forward(request, response);

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

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
import ma.fstt.entities.Client;
import ma.fstt.entities.LigneCommande;

/**
 * Servlet implementation class DeleteLcmdServlet
 */
@WebServlet("/DeleteLigneCommande")
public class DeleteLcmdServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@Inject
	private LigneCommandeDAO dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteLcmdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		LigneCommande lcmd ;
		dao = new LigneCommandeDAO();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		lcmd = dao.getLigneCommandebyId(id);
		
		dao.delete(lcmd);
			
		request.setAttribute("id", lcmd.getId());
		request.setAttribute("id_commande", lcmd.getId_commande());

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

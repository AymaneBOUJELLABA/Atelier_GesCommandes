package ma.fstt.entities;


import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LigneCommande
{
	private int id;
	private int qte;
	private int id_commande;
	private int id_produit;
	
	
	public LigneCommande()
	{
		super();
	}
	
	public LigneCommande(int id, int qte, int id_commande, int id_produit)
	{
		super();
		this.id = id;
		this.qte = qte;
		this.id_commande = id_commande;
		this.id_produit = id_produit;
	}
	
	
	
	@Override
	public String toString()
	{
		return "LigneCommande [id=" + id + ", qte=" + qte + ", id_commande=" + id_commande + ", id_produit=" + id_produit + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQte() {
		return qte;
	}
	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getId_produit() {
		return id_produit;
	}

	public void setId_produit(int id_produit) {
		this.id_produit = id_produit;
	}

	public int getId_commande() {
		return id_commande;
	}

	public void setId_commande(int id_commande) {
		this.id_commande = id_commande;
	}
	
	

}

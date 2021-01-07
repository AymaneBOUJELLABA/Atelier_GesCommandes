package ma.fstt.services;

import java.sql.SQLException;
import java.util.List;
import ma.fstt.entities.Produit;

public interface ProduitRepository
{
	
	public void save(Produit prd);
	
	public void update(Produit prd);
	
	public void delete(Produit prd) throws SQLException;
	
	public List<Produit> selectAll();
	
	public Produit getProduitbyId(int id);
	
}

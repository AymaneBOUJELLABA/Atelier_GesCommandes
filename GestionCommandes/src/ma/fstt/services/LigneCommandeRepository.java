package ma.fstt.services;

import java.util.List;

import ma.fstt.entities.LigneCommande;

public interface LigneCommandeRepository
{
	public void save(LigneCommande lcmd);
	
	public void update(LigneCommande lcmd);
	
	public void delete(LigneCommande lcmd);
	
	public List<LigneCommande> selectAll();
	
	public LigneCommande getLigneCommandebyId(int id);

}

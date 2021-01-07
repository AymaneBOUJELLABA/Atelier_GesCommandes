package ma.fstt.services;

import java.util.List;

import ma.fstt.entities.Commande;

public interface CommandeRepository
{
	
	public void save(Commande cmd);
	
	public void update(Commande cmd);
	
	public void delete(Commande cmd);
	
	public List<Commande> selectAll();
	
	public Commande getCommandebyId(int id);
	
}

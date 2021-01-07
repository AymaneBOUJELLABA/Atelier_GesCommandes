package ma.fstt.services;

import java.sql.SQLException;
import java.util.List;

import ma.fstt.entities.Client;

public interface ClientRepository
{
	
	public void save(Client client);
	
	public void update(Client client);
	
	public void delete(Client client) throws SQLException;
	
	public List<Client> selectAll();
	
	public Client getClientbyId(int id);

}

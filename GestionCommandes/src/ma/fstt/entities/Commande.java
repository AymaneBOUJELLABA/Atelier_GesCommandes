package ma.fstt.entities;
import java.sql.Date;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Commande
{
	private int id;
	private Date date;
	private int id_client;
	
	
	public Commande() 
	{
		super();
	}
	
	public Commande(int id, Date date, int id_client)
	{
		super();
		this.id = id;
		this.date = date;
		this.id_client = id_client;
	}
	
	
	
	@Override
	public String toString()
	{
		return "Commande [id=" + id + ", date=" + date + ", id_client=" + id_client +"]";
	}
	
	public int getId() 
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public Date getDate()
	{
		return date;
	}
	public void setDate(Date date)
	{
		this.date = date;
	}

	public int getId_client()
	{
		return id_client;
	}

	public void setId_client(int id_client)
	{
		this.id_client = id_client;
	}
	
	

}

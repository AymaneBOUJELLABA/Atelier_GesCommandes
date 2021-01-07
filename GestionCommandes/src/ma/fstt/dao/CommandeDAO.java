package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Commande;
import ma.fstt.services.CommandeRepository;
import ma.fstt.tools.ConnectionManager;

public class CommandeDAO implements CommandeRepository
{
	private Connection cnx;
	private PreparedStatement prepstmt;
	private Statement stmt;
	private ResultSet res;

	
	
	public CommandeDAO()
	{
		super();
		cnx = ConnectionManager.getCnx();
	}

	@Override
	public void save(Commande cmd)
	{
		String query = "INSERT INTO commande(Date,Id_Client) VALUES(?,?);";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setDate(1, cmd.getDate());
			prepstmt.setInt(2, cmd.getId_client());

			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Commande cmd)
	{
		String query = "UPDATE commande SET Date=?,Id_Client=? WHERE Id= ?;";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setDate(1, cmd.getDate());
			prepstmt.setInt(2, cmd.getId_client());
			prepstmt.setInt(3, cmd.getId());

			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Commande cmd)
	{
		String query = "DELETE FROM commande WHERE Id= ?;";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1 ,cmd.getId());

			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Commande> selectAll()
	{
		List<Commande> rs = new ArrayList<Commande>();
		String query = "SELECT * FROM commande;";
		try
		{
			stmt = cnx.createStatement();
			res = stmt.executeQuery(query);

			while(res.next())
			{
				rs.add(new Commande(res.getInt(1),res.getDate(2),res.getInt(3)));
			}
			return rs;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Commande getCommandebyId(int id)
	{
		String query = "SELECT * FROM commande WHERE Id= ?";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1, id);
			res = prepstmt.executeQuery();

			if(res.next())
				return new Commande(res.getInt(1),res.getDate(2),res.getInt(3));
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}


}

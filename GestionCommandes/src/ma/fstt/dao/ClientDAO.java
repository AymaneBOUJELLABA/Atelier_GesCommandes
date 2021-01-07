package ma.fstt.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Client;
import ma.fstt.services.ClientRepository;
import ma.fstt.tools.ConnectionManager;

public class ClientDAO implements ClientRepository
{
	private Connection cnx;
	private PreparedStatement prepstmt;
	private Statement stmt;
	private ResultSet res;
	
	public ClientDAO()
	{
		cnx = ConnectionManager.getCnx();
	}

	@Override
	public void save(Client client)
	{
		String query = "INSERT INTO client(Name,Email,Address) values (?,?,?);";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setString(1, client.getName());
			prepstmt.setString(2, client.getEmail());
			prepstmt.setString(3, client.getAddress());

			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Client client) 
	{
		String query = "UPDATE client SET Name = ?,Email = ?, Address = ? WHERE Id=?;";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setString(1, client.getName());
			prepstmt.setString(2, client.getEmail());
			prepstmt.setString(3, client.getAddress());
			prepstmt.setInt(4, client.getId());
			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Client client) throws SQLException
	{
		String query = "DELETE FROM client WHERE Id=?;";

			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1, client.getId());
			prepstmt.execute();
	}

	@Override
	public List<Client> selectAll() 
	{
		List<Client> rs = new ArrayList<Client>();
		String query = "SELECT * FROM client";
		try
		{
			stmt = cnx.createStatement();
			res = stmt.executeQuery(query);
			
			while(res.next())
			{
				rs.add(new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4)));
			}
			
			return rs;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Client getClientbyId(int id)
	{
		String query = "SELECT * FROM client WHERE Id=?";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1, id);
			res = prepstmt.executeQuery();
			
			if(res.next())
				return new Client(res.getInt(1),res.getString(2),res.getString(3),res.getString(4));
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

}

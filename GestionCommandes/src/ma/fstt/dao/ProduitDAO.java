package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.Produit;
import ma.fstt.services.ProduitRepository;
import ma.fstt.tools.ConnectionManager;

public class ProduitDAO implements ProduitRepository
{

	private Connection cnx;
	private PreparedStatement prepstmt;
	private Statement stmt;
	private ResultSet res;
	
	public ProduitDAO()
	{
		cnx = ConnectionManager.getCnx();
	}

	@Override
	public void save(Produit produit)
	{
		String query = "INSERT INTO produit(Label,Price) values (?,?);";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setString(1, produit.getLabel());
			prepstmt.setDouble(2, produit.getPrice());
			
			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(Produit produit) 
	{
		String query = "UPDATE produit SET Label = ?,Price = ? WHERE Id=?;";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setString(1, produit.getLabel());
			prepstmt.setDouble(2, produit.getPrice());
			prepstmt.setInt(3, produit.getId());
			
			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Produit produit) throws SQLException
	{
		String query = "DELETE FROM produit WHERE Id=?;";
		prepstmt = cnx.prepareStatement(query);
		prepstmt.setInt(1, produit.getId());
		prepstmt.execute();
	}

	@Override
	public List<Produit> selectAll() 
	{
		List<Produit> rs = new ArrayList<Produit>();
		String query = "SELECT * FROM produit";
		try
		{
			stmt = cnx.createStatement();
			res = stmt.executeQuery(query);
			
			while(res.next())
			{
				rs.add(new Produit(res.getInt(1),res.getString(2),res.getDouble(3)));
			}
			
			return rs;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Produit getProduitbyId(int id)
	{
		String query = "SELECT * FROM produit WHERE Id=?";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1, id);
			res = prepstmt.executeQuery();
			
			if(res.next())
				return new Produit(res.getInt(1),res.getString(2),res.getDouble(3));
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

package ma.fstt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ma.fstt.entities.LigneCommande;
import ma.fstt.services.LigneCommandeRepository;
import ma.fstt.tools.ConnectionManager;

public class LigneCommandeDAO implements LigneCommandeRepository
{

	private Connection cnx;
	private PreparedStatement prepstmt;
	private Statement stmt;
	private ResultSet res;

	
	
	public LigneCommandeDAO()
	{
		super();
		cnx = ConnectionManager.getCnx();
	}

	@Override
	public void save(LigneCommande Lcmd)
	{
		String query = "INSERT INTO lignecommande(Qte,Id_produit,Id_commande) VALUES(?,?,?);";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1, Lcmd.getQte());
			prepstmt.setInt(2, Lcmd.getId_produit());
			prepstmt.setInt(3, Lcmd.getId_commande());

			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void update(LigneCommande Lcmd)
	{
		String query = "UPDATE lignecommande SET Qte=?,Id_produit=?,Id_commande=? WHERE Id= ?;";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1, Lcmd.getQte());
			prepstmt.setInt(2, Lcmd.getId_produit());
			prepstmt.setInt(3, Lcmd.getId_commande());
			prepstmt.setInt(4, Lcmd.getId());

			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void delete(LigneCommande Lcmd)
	{
		String query = "DELETE FROM lignecommande WHERE Id= ?;";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1 ,Lcmd.getId());

			prepstmt.execute();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<LigneCommande> selectAll()
	{
		List<LigneCommande> rs = new ArrayList<LigneCommande>();
		String query = "SELECT * FROM lignecommande;";
		try
		{
			stmt = cnx.createStatement();
			res = stmt.executeQuery(query);

			while(res.next())
			{
				rs.add(new LigneCommande(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4)));
			}
			return rs;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public LigneCommande getLigneCommandebyId(int id)
	{
		String query = "SELECT Id,Qte,Id_commande,Id_produit FROM lignecommande WHERE Id= ?";
		try
		{
			prepstmt = cnx.prepareStatement(query);
			prepstmt.setInt(1, id);
			res = prepstmt.executeQuery();

			if(res.next())
				return new LigneCommande(res.getInt(1),res.getInt(2),res.getInt(3),res.getInt(4));
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}
}

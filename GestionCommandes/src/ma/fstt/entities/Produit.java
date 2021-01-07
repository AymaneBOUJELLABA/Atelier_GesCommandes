package ma.fstt.entities;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Produit 
{
	private int id;
	private String label;
	private double price;

	public Produit()
	{
		super();
	}
	
	public Produit(int id, String label, double price)
	{
		super();
		this.id = id;
		this.label = label;
		this.price = price;
	}
	
	
	@Override
	public String toString()
	{
		return "Produit [id=" + id + ", label=" + label + ", price=" + price + "]";
	}

	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getLabel()
	{
		return label;
	}
	public void setLabel(String label)
	{
		this.label = label;
	}
	public double getPrice()
	{
		return price;
	}
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	

}

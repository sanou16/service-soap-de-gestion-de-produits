package com.javaws.services;

import java.util.List;

import com.javaws.DaoImpl.ProduitDaoImpl;
import com.javaws.IDAO.IDAO;
import com.javaws.entities.Produit;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;


@WebService(name="ProduitWS")
public class WSProduit {
	
	
	IDAO idao;
	public WSProduit()
	{
		idao = new ProduitDaoImpl();
	}
	
	@WebMethod
	public boolean createProduit(@WebParam(name="reference") String reference,@WebParam(name="nom") String nom,@WebParam(name="prix") double prix)
	{
		Produit p = new Produit(reference,nom,prix);
		return idao.createProduit(p);
	}
	
	@WebMethod
	public boolean updateProduit(@WebParam(name="id") int id,@WebParam(name="reference") String reference,@WebParam(name="nom") String nom,@WebParam(name="prix") double prix)
	{
		Produit p = new Produit(id,reference,nom,prix);
		return idao.updateProduit(p);
	}
	
	@WebMethod
	public List<Produit> listProduit()
	{
		return idao.listeProduits();
	}
	
	@WebMethod
	public boolean deleteProduit(@WebParam(name="id") int id)
	{
		return idao.deleteProduit(id);
	}
	
	@WebMethod
	public Produit getProduit(@WebParam(name="id") int id)
	{
		return idao.getProduit(id);
	}
	
	
	

}

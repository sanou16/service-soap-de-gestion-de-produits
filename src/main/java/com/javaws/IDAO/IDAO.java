package com.javaws.IDAO;

import java.util.List;

import com.javaws.entities.*;
public interface IDAO {
	
	boolean createProduit(Produit p);
	boolean updateProduit(Produit p);
	List<Produit> listeProduits();
	boolean deleteProduit(int id);
	
	Produit getProduit(int id);
	

}

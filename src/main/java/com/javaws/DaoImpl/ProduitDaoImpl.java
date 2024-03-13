package com.javaws.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.javaws.DBManager.DManager;
import com.javaws.IDAO.IDAO;
import com.javaws.entities.Produit;

public class ProduitDaoImpl implements IDAO{
	
	private DManager dManager;
	
	List<Produit> listeProduits = new ArrayList<>();
	public ProduitDaoImpl()
	{
		dManager = new DManager();
	}

	@Override
	public boolean createProduit(Produit p) {
		//reference, nom, prix
	    String query = "INSERT INTO produit (reference, nom, prix) VALUES (?, ?, ?)";

	    try (Connection connection = dManager.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {

	        ps.setString(1, p.getReference());
	        ps.setString(2, p.getNom());
	        ps.setDouble(3, p.getPrix());
	        
	        int rowCount = ps.executeUpdate();

	        return rowCount > 0;

	    } catch (SQLException e) {
	        // Log or handle the SQL exception
	        
	    } catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
		
		
	}

	@Override
	public boolean updateProduit(Produit p) {
		 String query = "UPDATE produit SET reference = ?, nom = ?, prix = ? WHERE id = ?";

	        try (Connection connection = dManager.getConnection();
	             PreparedStatement ps = connection.prepareStatement(query)) {

	            ps.setString(1, p.getReference());
	            ps.setString(2, p.getNom());
	            ps.setDouble(3, p.getPrix());
	            ps.setInt(4, p.getId());
	            
	            int rowCount = ps.executeUpdate();

	            return rowCount > 0;

	        } catch (SQLException e) {
	            // Gérer l'exception SQL
	            e.printStackTrace();
	            return false;
	        } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
	}

	@Override
	public List<Produit> listeProduits() {
		String requete = "SELECT * FROM produit";
		try {
			Connection connexion = dManager.getConnection();
			 PreparedStatement preparedStatement = connexion.prepareStatement(requete);
			ResultSet resultSet =  preparedStatement.executeQuery();
			 while (resultSet.next()) {
	                String reference = resultSet.getString("reference");
	                String nom = resultSet.getString("nom");
	                double prix = resultSet.getDouble("prix");
	                int id = resultSet.getInt("id");
	                Produit produit = new Produit(id,reference,nom,prix);
	                listeProduits.add(produit);
	            }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeProduits;
	}

	

	@Override
	public boolean deleteProduit(int id) {
		 String query = "DELETE FROM produit WHERE id = ?";
		    
		    try (Connection connection = dManager.getConnection();
		         PreparedStatement ps = connection.prepareStatement(query)) {
		        
		        ps.setInt(1, id);
		        int rowCount = ps.executeUpdate();  // Utilisez executeUpdate au lieu de execute pour les opérations DML
		        
		        return rowCount > 0;  // Vérifiez si des lignes ont été affectées

		    } catch (SQLException e) {
		        // Log or handle the SQL exception
		        
		    } catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return false;
	}

	@Override
	public Produit getProduit(int id) {
     
		String query = "SELECT * FROM produit WHERE id = ?";

	    try (Connection connection = dManager.getConnection();
	         PreparedStatement ps = connection.prepareStatement(query)) {
	        ps.setInt(1, id);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                int productId = rs.getInt("id");
	                String reference = rs.getString("reference");
	                String nom = rs.getString("nom");
	                double prix = rs.getDouble("prix");
	                return new Produit(productId, reference, nom, prix);
	            }
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // Gérer l'exception SQL
	    } catch (Exception e) {
	        e.printStackTrace(); // Gérer d'autres exceptions
	    }

	    return null;

	}

}

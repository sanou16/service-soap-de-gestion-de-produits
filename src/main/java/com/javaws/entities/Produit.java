package com.javaws.entities;

import java.io.Serializable;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="produit")
public class Produit implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	public Produit(int id, String reference, String nom, double prix) {
		super();
		this.id = id;
		this.reference = reference;
		this.nom = nom;
		this.prix = prix;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String reference;
	private String nom;
	private double prix;
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public Produit(String reference, String nom, double prix) {
		super();
		this.reference = reference;
		this.nom = nom;
		this.prix = prix;
	}
	public Produit() {
		super();
	}
	
	
	
}

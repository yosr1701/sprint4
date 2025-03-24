package com.yosr.vetements.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Vetement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVet;
	private String nomVet;
	private Double prix;
	private Date dateCreation;
	
	@ManyToOne
	private Genre genre ;
	
	public Vetement() {
		super();
	}
	
	public Vetement(String nomVet, Double prix, Date dateCreation) {
		super();
		this.nomVet = nomVet;
		this.prix = prix;
		this.dateCreation = dateCreation;
	}



	public long getIdVet() {
		return idVet;
	}
	public void setIdVet(long idVet) {
		this.idVet = idVet;
	}
	public String getNomVet() {
		return nomVet;
	}
	public void setNomVet(String nomVet) {
		this.nomVet = nomVet;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Override
	public String toString() {
		return "Vetement [idVet=" + idVet + ", nomVet=" + nomVet + ", prix=" + prix + ", dateCreation=" + dateCreation
				+ "]";
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	} 
	
	

}

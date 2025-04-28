package com.yosr.vetements.entities;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

@Entity
public class Vetement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVet;
	
	@NotNull
	@Size(min = 4,max =100)
	private String nomVet;
	
	@Min(value= 5)
	@Max(value= 100000)
	private Double prix;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@PastOrPresent
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



	public Long getIdVet() {
		return idVet;
	}
	public void setIdVet(Long idVet) {
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

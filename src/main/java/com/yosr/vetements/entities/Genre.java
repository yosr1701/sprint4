package com.yosr.vetements.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Genre {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private long idGen ; 
	 
	private String nomGen;
	private String descGen;
	
	
	@OneToMany(mappedBy = "genre") 
	@JsonIgnore
	private List<Vetement>  vetements; 
	
	public long getIdGen() {
		return idGen;
	}
	public void setIdGen(long idGen) {
		this.idGen = idGen;
	}
	public String getNomGen() {
		return nomGen;
	}
	public void setNomGen(String nomGen) {
		this.nomGen = nomGen;
	}
	public String getDescGen() {
		return descGen;
	}
	public void setDescGen(String descGen) {
		this.descGen = descGen;
	}
	@Override
	public String toString() {
		return "Genre [idGen=" + idGen + ", nomGen=" + nomGen + ", descGen=" + descGen + "]";
	}

	public List<Vetement> getVetements() {
		return vetements;
	}

	public void setVetements(List<Vetement> vetements) {
		this.vetements = vetements;
	}
	
	
}

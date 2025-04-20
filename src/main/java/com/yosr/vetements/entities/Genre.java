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
//pour generer les getters et les setters de lambok

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
	
	
}

package com.yosr.vetements.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import com.yosr.vetements.entities.Genre;
import com.yosr.vetements.entities.Vetement;

public interface VetementService {
	
	Vetement saveProduit(Vetement v);
	Vetement updateProduit(Vetement v);
	void deleteProduit(Vetement v);
	void deleteVetementById(Long id);
	Vetement getVetement(Long id);
	List<Vetement> getAllVetement();
	List<Vetement> findByNomVet(String nom);
	List<Vetement> findByNomVetContains(String nom);
	List<Vetement> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
	List<Vetement> findByGenre(Genre genre);
	List<Vetement> findByGenreIdGen(Long id);
	List<Vetement>findByOrderByNomVetAsc();
	List<Vetement>trierVetementsNomVetPrix();
	
	Page<Vetement> getAllVetementParPage(int page, int size);

}

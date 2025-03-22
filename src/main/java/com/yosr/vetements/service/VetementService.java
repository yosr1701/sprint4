package com.yosr.vetements.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yosr.vetements.entities.Vetement;

public interface VetementService {
	
	Vetement saveProduit(Vetement v);
	Vetement updateProduit(Vetement v);
	void deleteProduit(Vetement v);
	 void deleteVetementById(Long id);
	 Vetement getVetement(Long id);
	List<Vetement> getAllVetement();
	
	Page<Vetement> getAllVetementParPage(int page, int size);

}

package com.yosr.vetements.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.repos.VetementRepository;


@Service
public class VetementServiceImpl implements VetementService{
	
	@Autowired
	VetementRepository vetementRepository;

	@Override
	public Vetement saveProduit(Vetement v) {
		return vetementRepository.save(v);
	}

	@Override
	public Vetement updateProduit(Vetement v) {
		return vetementRepository.save(v);
	}

	@Override
	public void deleteProduit(Vetement v) {
		 vetementRepository.delete(v);
		
	}

	@Override
	public void deleteVetementById(Long id) {
		vetementRepository.deleteById(id);
	}

	@Override
	public Vetement getVetement(Long id) {
		return vetementRepository.findById(id).get();
	}

	@Override
	public List<Vetement> getAllVetement() {
		return vetementRepository.findAll();
	}

	@Override
	public Page<Vetement> getAllVetementParPage(int page, int size) {
		
		return vetementRepository.findAll(PageRequest.of(page,size));
	}

}

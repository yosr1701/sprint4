package com.yosr.vetements.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.yosr.vetements.dto.VetementDTO;
import com.yosr.vetements.entities.Genre;
import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.repos.GenreRepository;
import com.yosr.vetements.repos.VetementRepository;


@Service
public class VetementServiceImpl implements VetementService{
	
	@Autowired
	VetementRepository vetementRepository;
	
	@Autowired
	ModelMapper modelmapper;
	
	@Autowired
	GenreRepository genreRepository;

	@Override
	public VetementDTO saveProduit(VetementDTO v) {
		return convertEntityToDto (vetementRepository.save(convertDtoToEntity (v)));
	}

	@Override
	public VetementDTO updateProduit(VetementDTO v) {
		return convertEntityToDto (vetementRepository.save(convertDtoToEntity (v)));
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
	public VetementDTO getVetement(Long id) {
		return convertEntityToDto(vetementRepository.findById(id).get());
	}

	@Override
	public List<VetementDTO> getAllVetement() {
		return vetementRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
		
				/*List<Vetement> vets = vetementRepository.findAll();
		List<VetementDTO> listvetDto = new ArrayList<>(vets.size());
		for (Vetement v : vets)
		listvetDto.add(convertEntityToDto(v));
		return listvetDto;*/
	}

	@Override
	public Page<Vetement> getAllVetementParPage(int page, int size) {
		
		return vetementRepository.findAll(PageRequest.of(page,size));
	}

	@Override
	public List<Vetement> findByNomVet(String nom) {
	
		return vetementRepository.findByNomVet(nom);
	}

	@Override
	public List<Vetement> findByNomVetContains(String nom) {
		
		return vetementRepository.findByNomVetContains( nom);
	}

	@Override
	public List<Vetement> findByNomPrix(String nom, Double prix) {
		return vetementRepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Vetement> findByGenre(Genre genre) {
		return vetementRepository.findByGenre(genre);
	}

	@Override
	public List<Vetement> findByGenreIdGen(Long id) {
		
		return vetementRepository.findByGenreIdGen(id); 
	}

	@Override
	public List<Vetement> findByOrderByNomVetAsc() {
		
		return vetementRepository.findByOrderByNomVetAsc();
	}

	@Override
	public List<Vetement> trierVetementsNomVetPrix() {
		
		return vetementRepository.trierVetementsNomVetPrix();
	}

	@Override
	public List<Genre> getAllGenres() {
		
		return genreRepository.findAll();
	}

	@Override
	public VetementDTO convertEntityToDto(Vetement vet) {
		
		modelmapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		VetementDTO vetementDTO= modelmapper.map(vet, VetementDTO.class);
		return vetementDTO;
		/*VetementDTO vetementDTO = new VetementDTO();
		
		vetementDTO.setIdVet(v.getIdVet());
		vetementDTO.setNomVet(v.getNomVet());
		vetementDTO.setPrix(v.getPrix());
		vetementDTO.setGenre(v.getGenre());
		
		return vetementDTO;*/
		
		/*return  VetementDTO.builder()
				.idVet(v.getIdVet())
				.nomVet(v.getNomVet())
				//.prix(v.getPrix())
				.dateCreation(v.getDateCreation())
				.genre(v.getGenre())
				//.nomGen(v.getGenre().getNomGen())
				.build();*/
		
	}

	@Override
	public Vetement convertDtoToEntity(VetementDTO vetementDto) {
		
		Vetement vet= new Vetement();
		vet=modelmapper.map(vetementDto, Vetement.class);
		return vet;
		/*Vetement vet= new Vetement();
		
		vet.setIdVet(vetementDto.getIdVet());
		vet.setNomVet(vetementDto.getNomVet());
		vet.setPrix(vetementDto.getPrix());
		vet.setDateCreation(vetementDto.getDateCreation());
		vet.setGenre(vetementDto.getGenre());
		
		return vet;*/
	}

}

package com.yosr.vetements;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.repos.VetementRepository;
import com.yosr.vetements.service.VetementService;

@SpringBootTest
class VetementsApplicationTests {

	@Autowired
	private VetementRepository VetementRepository;
	@Autowired
	private VetementService VetementService;
	
	@Test
	public void testCreateVetement() {
	Vetement vet = new Vetement("Robe",500.0,new Date());
	
	VetementRepository.save(vet);
	}

	@Test
	public void testFindVetement() {
		Vetement v = VetementRepository.findById(1L).get();
		System.out.println(v);
	}

	@Test
	public void testUpdateVetement() {
		Vetement v = VetementRepository.findById(1L).get();
		v.setPrix(150.0);
		VetementRepository.save(v);
	}
	@Test
	public void testDeleteVetement() {
		VetementRepository.deleteById(1L);
		;
	}

	@Test
	public void testListerTousVetemnets()
	{
	List<Vetement> Vet = VetementRepository.findAll();
	for (Vetement v : Vet)
		{
			System.out.println(v);
		}
	}
	 @Test
	 public void testFindByNomProduitContains()
	 {
	 Page<Vetement> Vet = VetementService.getAllVetementParPage(0,2);
	 System.out.println(Vet.getSize());
	 System.out.println(Vet.getTotalElements());
	 System.out.println(Vet.getTotalPages());
	 Vet.getContent().forEach(v -> {System.out.println(v.toString());
	  });
	 /*ou bien
	 for (Produit p : prods)
	 {
	 System.out.println(p);
	 } */
	 }
}

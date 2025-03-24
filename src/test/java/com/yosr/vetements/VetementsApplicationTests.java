package com.yosr.vetements;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.yosr.vetements.entities.Genre;
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
	 
	 
	 @Test
	    public void testFindVetementByNom() {
	        List<Vetement> v = VetementRepository.findByNomVet("veste"); 
	        for (Vetement vet : v) {
	            System.out.println(vet); 
	        }
	    }

	    @Test
	    public void testFindByNomVetContains() {
	        List<Vetement> v = VetementRepository.findByNomVetContains("t");
	        for (Vetement vet : v) {
	            System.out.println(vet);
	        }
	    }
	    
	    @Test
	    public void testFindByNomPrix() {
	        List<Vetement> vetements = VetementRepository.findByNomPrix("veste", 150.0);
	        for (Vetement v : vetements) {
	            System.out.println(v);
	        }
	    }
	    
	    
	    @Test
	    public void testFindByCategorie() {
	        // Créer une catégorie avec un ID valide
	        Genre gen = new Genre();
	        gen.setIdGen(1L);  // Assure-toi que l'ID de la catégorie est valide
	        // Trouver les produits par catégorie
	        List<Vetement> vetements = VetementRepository.findByGenre(gen);
	        // Afficher les produits trouvés
	        for (Vetement v : vetements) {
	            System.out.println(v);
	        }
	    }

	    
	    @Test
	    public void testFindByGenreIdGen() {
	    	List<Vetement> vetements = VetementRepository.findByGenreIdGen(1L);
	    	for (Vetement v : vetements) {
	            System.out.println(v);
	        }
	    }


	    @Test
	    public void findByOrderByNomVetAsc() {
	    	List<Vetement> vetements = VetementRepository.findByOrderByNomVetAsc();
	    	for (Vetement v : vetements) {
	            System.out.println(v);
	        }
	    }
	    
	    @Test
	    public void trierVetementsNomVetPrix() {
	    	List<Vetement> vetements = VetementRepository.trierVetementsNomVetPrix();
	    	for (Vetement v : vetements) {
	            System.out.println(v);
	        }
	    }
}

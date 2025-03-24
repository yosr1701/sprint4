package com.yosr.vetements.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.yosr.vetements.entities.Genre;
import com.yosr.vetements.entities.Vetement;

@RepositoryRestResource(path = "rest")
public interface VetementRepository extends JpaRepository<Vetement, Long> {  
	
	List<Vetement> findByNomVet(String nom);
	List<Vetement> findByNomVetContains(String nom);
	
	
	//@Query("SELECT v FROM Vetement v WHERE v.nomVet LIKE %?1% AND v.prix > ?2")
	//List<Vetement> findByNomPrix(String nom, Double prix);
	@Query("SELECT v FROM Vetement v WHERE v.nomVet LIKE %:nom% AND v.prix > :prix")
	List<Vetement> findByNomPrix(@Param("nom") String nom, @Param("prix") Double prix);
	
	@Query("SELECT v FROM Vetement v WHERE v.genre = ?1 ")
	List<Vetement> findByGenre(Genre genre);
	
	List<Vetement> findByGenreIdGen(Long id);
	
	List<Vetement>findByOrderByNomVetAsc();
	
	
	@Query("SELECT v FROM Vetement v order by v.nomVet ASC ,v.prix DESC ")
	List<Vetement>trierVetementsNomVetPrix();
}

package com.yosr.vetements.restControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.service.VetementService;



@RestController
@RequestMapping("/api")
@CrossOrigin
public class VetementRESTController {
	
	@Autowired
	VetementService vetementService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Vetement> getAllVetement()
	{
		return vetementService.getAllVetement();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Vetement getVetementById(@PathVariable("id") Long id)
	{
		return vetementService.getVetement(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Vetement createVetement(@RequestBody Vetement vetement) 
	{
		return vetementService.saveProduit(vetement);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Vetement updateProduit(@RequestBody Vetement vetement)
	{
		return vetementService.updateProduit(vetement);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteProduit(@PathVariable("id") Long id)
	{
		vetementService.deleteVetementById(id);
	}
	
	@RequestMapping(value="/vetGen/{idGen}", method = RequestMethod.GET)
	public List<Vetement> getVetementsByGenId(@PathVariable("idGen") Long idGen) {
	    return vetementService.findByGenreIdGen(idGen);
	}

}

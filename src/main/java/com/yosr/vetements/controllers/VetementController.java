package com.yosr.vetements.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yosr.vetements.entities.Genre;
import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.service.VetementService;

import jakarta.validation.Valid;

@Controller
public class VetementController {
	@Autowired
	VetementService vetementService;
	
	@GetMapping("/accessDenied")
	public String error()
	{
		return "accessDenied";
	}

	@RequestMapping("/listeVetements")
	public String listeProduits(ModelMap modelMap,
			@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "4") int size) {
		Page<Vetement> vet = vetementService.getAllVetementParPage(page, size);
		//ajouter model(page)
		modelMap.addAttribute("vetements", vet);
		modelMap.addAttribute("pages", new int[vet.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		//view
		return "listeVetements";
	}

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
	    modelMap.addAttribute("vetement", new Vetement());
	    List<Genre> gens = vetementService.getAllGenres();
	    modelMap.addAttribute("mode", "new");
	    modelMap.addAttribute("genres", gens);
	    return "formVetement";
	}

	@RequestMapping("/saveVetement")
	public String saveProduit(@Valid Vetement vetement ,BindingResult bindingResult,
			 @RequestParam(name = "page", defaultValue = "0") int page,
	         @RequestParam(name = "size", defaultValue = "2") int size)
	{
		int currentPage ;
		boolean isNew = false;
		if (bindingResult.hasErrors()) return "formVetement";
		
		if(vetement.getIdVet()==null)
			isNew=true;
		
		vetementService.saveProduit(vetement);
		if (isNew)
		{
			Page<Vetement> vets = vetementService.getAllVetementParPage(page, size);
			currentPage = vets.getTotalPages()-1;
		}
		else 
			currentPage=page;
		//return "formVetement";
		return ("redirect:/listeVetements?page="+currentPage+"&size="+size);
	}

    @RequestMapping("/deleteVetement")
    public String supprimerProduit(@RequestParam("id") Long id, ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) 
    {	
        vetementService.deleteVetementById(id);

        Page<Vetement> vet = vetementService.getAllVetementParPage(page, size);
        modelMap.addAttribute("vetements", vet);
        modelMap.addAttribute("pages", new int[vet.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);

        return "listeVetements";
    }

    @RequestMapping("/modifierVetement")
    public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap,
    		@RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Vetement v = vetementService.getVetement(id);
        List<Genre> gens = vetementService.getAllGenres();
        modelMap.addAttribute("vetement", v);
        modelMap.addAttribute("mode", "edit");
        modelMap.addAttribute("genres", gens);
        modelMap.addAttribute("page", page);
        modelMap.addAttribute("size", size);
        return "formVetement";
    }

	@RequestMapping("/updateVetement")
	public String updateVetement(@ModelAttribute("Vetement") Vetement vetement, @RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
			//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		vetement.setDateCreation(dateCreation);

		vetementService.updateProduit(vetement);
		List<Vetement> vet = vetementService.getAllVetement();
		modelMap.addAttribute("Vetements", vet);
		return "listeVetements";
	}
}

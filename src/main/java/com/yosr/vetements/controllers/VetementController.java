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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.service.VetementService;

@Controller
public class VetementController {
	@Autowired
	VetementService vetementService;

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
	public String showCreate() {
		return "createVetement";
	}

	@RequestMapping("/saveVetement")
	public String saveProduit(@ModelAttribute("vetement") Vetement vetement, @RequestParam("date") String date,ModelMap modelMap) throws ParseException
	{
		//conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreation = dateformat.parse(String.valueOf(date));
		vetement.setDateCreation(dateCreation);

		Vetement saveVetement = vetementService.saveProduit(vetement);
		String msg = "Vetement enregistré avec Id " + saveVetement.getIdVet();
		modelMap.addAttribute("msg", msg);
		return "createVetement";
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
	public String editerProduit(@RequestParam("id") Long id, ModelMap modelMap) {
		Vetement v = vetementService.getVetement(id);
		modelMap.addAttribute("Vetement", v);
		return "editerVetement";
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

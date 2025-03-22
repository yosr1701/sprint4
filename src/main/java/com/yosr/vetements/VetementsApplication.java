package com.yosr.vetements;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.service.VetementService;

@SpringBootApplication
public class VetementsApplication implements CommandLineRunner {
	
	@Autowired
	VetementService vetementService;
	
	public static void main(String[] args) {
		SpringApplication.run(VetementsApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		//vetementService.saveProduit(new Vetement("manteau", 200.0, new Date()));
		//vetementService.saveProduit(new Vetement("jogging", 70.0, new Date()));
		//vetementService.saveProduit(new Vetement("veste en cuir", 150.0, new Date()));
		//vetementService.saveProduit(new Vetement("pull en laine", 90.0, new Date()));
		//vetementService.saveProduit(new Vetement("sweat-shirt", 55.0, new Date()));
		//vetementService.saveProduit(new Vetement("chemise", 45.0, new Date()));
		//vetementService.saveProduit(new Vetement("t-shirt", 25.0, new Date()));
		//vetementService.saveProduit(new Vetement("jeans", 60.0, new Date()));
		
	}

}

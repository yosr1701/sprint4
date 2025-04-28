 package com.yosr.vetements;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yosr.vetements.entities.Role;
import com.yosr.vetements.entities.User;
import com.yosr.vetements.entities.Vetement;
import com.yosr.vetements.service.UserService;
import com.yosr.vetements.service.VetementService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class VetementsApplication implements CommandLineRunner {
	

	VetementService vetementService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	UserService userService ;
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	public static void main(String[] args) {
		SpringApplication.run(VetementsApplication.class, args);

	}
	
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"yosr","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	
	userService.addRoleToUser("yosr", "USER");
	userService.addRoleToUser("yosr", "AGENT");
	
	userService.addRoleToUser("user1", "USER");
	}*/
	
	

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));

		//vetementService.saveProduit(new Vetement("manteau", 200.0, new Date()));
		//vetementService.saveProduit(new Vetement("jogging", 70.0, new Date()));
		//vetementService.saveProduit(new Vetement("veste en cuir", 150.0, new Date()));
		//vetementService.saveProduit(new Vetement("pull en laine", 90.0, new Date()));
		//vetementService.saveProduit(new Vetement("sweat-shirt", 55.0, new Date()));
		//vetementService.saveProduit(new Vetement("chemise", 45.0, new Date()));
		//vetementService.saveProduit(new Vetement("t-shirt", 25.0, new Date()));
		//vetementService.saveProduit(new Vetement("jeans", 60.0, new Date()));
		repositoryRestConfiguration.exposeIdsFor(Vetement.class);
		
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
	return new ModelMapper();
	}

}

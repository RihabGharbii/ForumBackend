package org.sid;

import org.sid.entities.Role;
import org.sid.entities.Users;
import org.sid.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;





@SpringBootApplication

public class ForumBackendApplication implements CommandLineRunner {

    @Bean
    public BCryptPasswordEncoder getBCPE() {
	   return new BCryptPasswordEncoder();
   }

	@Autowired
	private AcountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(ForumBackendApplication.class, args);
	}
   
	
	@Override
	public void run(String... args) throws Exception {
	    accountService.saveUser(new Users("rihab", "123", null, null, null));
		accountService.saveUser(new Users("user", "123", null, null, null));
	    accountService.saveRole(new Role("ADMIN"));
		accountService.saveRole(new Role("USER"));
		accountService.addRoleToUser("rihab","ADMIN");
		accountService.addRoleToUser("user","USER");
		System.out.println("+++++++++++++++++++++++++++++++");
		
	}
		
	
	
}
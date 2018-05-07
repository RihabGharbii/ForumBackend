package org.sid;

import org.sid.entities.Role;
import org.sid.entities.Users;
import org.sid.service.AcountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@Configuration
@EnableTransactionManagement
@ComponentScan


@SpringBootApplication

public class ForumBackendApplication implements CommandLineRunner {


	@Autowired
	private AcountService accountService;
	
	public static void main(String[] args) {
		SpringApplication.run(ForumBackendApplication.class, args);
	}
   
	@Bean
    public BCryptPasswordEncoder getBCPE() {
	   return new BCryptPasswordEncoder();
   }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		accountService.saveUser(new Users("rihab", "123", null, null, null));
		accountService.saveUser(new Users("user", "123", null, null, null));
	    accountService.saveRole(new Role("ADMIN"));
		accountService.saveRole(new Role("USER"));
		accountService.addRoleToUser("rihab","ADMIN");
	    accountService.addRoleToUser("rihab","USER");
		accountService.addRoleToUser("user","USER");
		System.out.println("+++++++++++++++++++++++++++++++");
		
	}
		
	
	
}
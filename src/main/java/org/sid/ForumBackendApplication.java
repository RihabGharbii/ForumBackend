package org.sid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ForumBackendApplication {


	public static void main(String[] args) {
		SpringApplication.run(ForumBackendApplication.class, args);
	}
    @Bean
 public BCryptPasswordEncoder getBCPE() {
	return new BCryptPasswordEncoder();
}
	

	
}
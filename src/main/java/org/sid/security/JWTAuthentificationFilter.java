package org.sid.security;

import java.io.IOException;
import java.util.Date;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.sid.entities.Users;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.sid.security.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthentificationFilter extends UsernamePasswordAuthenticationFilter {

	 private AuthenticationManager authentificationManager;
	
	 public JWTAuthentificationFilter(AuthenticationManager authentificationManager) {
		super();
		this.authentificationManager = authentificationManager;
	}
	
	 @Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		Users users=null;
		// on va prendre des données json et les mettre dans un objet java
		
	
		try {
			users= new ObjectMapper().readValue(request.getInputStream(), Users.class);
		} 
		 catch (Exception e) {
			
			 throw new RuntimeException(e);
		}
		System.out.println("*************************");
		System.out.println("username: "+users.getUsername());
		System.out.println("password: "+users.getPassword());
		
		return authentificationManager.authenticate(
				new UsernamePasswordAuthenticationToken(users.getUsername(), users.getPassword()));
		
	}
	  @Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		  System.out.println("success");
			User springUser =(User) authResult.getPrincipal();
			String jwt= Jwts.builder()
					.setSubject(springUser.getUsername())
					.setExpiration(new Date (System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME))
					.signWith(SignatureAlgorithm.HS256,SecurityConstants.SECRET)
					.claim("roles",springUser.getAuthorities())
					.compact();
			response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwt);
			
	}
}

package org.sid.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Users implements Serializable{
	
	@OneToMany(mappedBy="users")
    private Collection<Element> element ;
	
	@Id
	@GeneratedValue
	private Long U_id;
	private String username;
	private String password;
	private String email;
	private String picture;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<Role>  roles=new ArrayList<>();
	@Autowired
	private Users users; //
	public Long getU_id() {
		return U_id;
	}
	public void setU_id(Long u_id) {
		U_id = u_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	
	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Collection<Role> getRoles() {
		return roles;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public Users(String username, String password, String email, String picture,  Collection<Role>  roles) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.picture = picture;
		this.roles = roles;
	}
	

}

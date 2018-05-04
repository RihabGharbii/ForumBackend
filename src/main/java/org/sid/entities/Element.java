package org.sid.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="Element")
public class Element implements Serializable {

	@Id
	@GeneratedValue
	private Long e_id;
	private String e_contenent;
	@Temporal(TemporalType.DATE)
	private Date e_date;
	
	@ManyToOne
    private Users users ;
	
	public Element() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getE_id() {
		return e_id;
	}

	public void setE_id(Long e_id) {
		this.e_id = e_id;
	}

	public String getE_contenent() {
		return e_contenent;
	}

	public void setE_contenent(String e_contenent) {
		this.e_contenent = e_contenent;
	}

	public Date getE_date() {
		return e_date;
	}

	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Element(String e_contenent, Date e_date, Users users) {
		super();
		this.e_contenent = e_contenent;
		this.e_date = e_date;
		this.users = users;
	}

	public Element(Long e_id, String e_contenent, Date e_date) {
		super();
		this.e_id = e_id;
		this.e_contenent = e_contenent;
		this.e_date = e_date;
	}
	
	
}
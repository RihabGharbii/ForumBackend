package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category implements Serializable{
	@Id
	@GeneratedValue
	private Long Cat_id;
	private String Cat_title;
	private String Cat_description;
	public Long getCat_id() {
		return Cat_id;
	}
	public void setCat_id(Long cat_id) {
		Cat_id = cat_id;
	}
	public String getCat_title() {
		return Cat_title;
	}
	public void setCat_title(String cat_title) {
		Cat_title = cat_title;
	}
	public String getCat_description() {
		return Cat_description;
	}
	public void setCat_description(String cat_description) {
		Cat_description = cat_description;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Category(String cat_title, String cat_description) {
		super();
		Cat_title = cat_title;
		Cat_description = cat_description;
	}
	

}

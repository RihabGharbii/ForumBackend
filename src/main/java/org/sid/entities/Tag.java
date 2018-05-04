package org.sid.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Tag implements Serializable{
	@Id
	@GeneratedValue
	private Long T_id;
	private String T_description;
	private String T_title;
	@Temporal(TemporalType.DATE)
	private Date Q_date;
	
	public Long getT_id() {
		return T_id;
	}
	public void setT_id(Long t_id) {
		T_id = t_id;
	}
	public String getT_description() {
		return T_description;
	}
	public void setT_description(String t_description) {
		T_description = t_description;
	}
	public String getT_title() {
		return T_title;
	}
	public void setT_title(String t_title) {
		T_title = t_title;
	}
	public Date getQ_date() {
		return Q_date;
	}
	public void setQ_date(Date q_date) {
		Q_date = q_date;
	}
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tag(String t_description, String t_title, Date q_date) {
		super();
		T_description = t_description;
		T_title = t_title;
		Q_date = q_date;
	}

}

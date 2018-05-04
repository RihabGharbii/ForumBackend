package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Data implements Serializable {
	@Id
	@GeneratedValue
	private Long D_id;
	private String D_contenent;
	@Temporal(TemporalType.DATE)
	private Date D_date;
	public Long getD_id() {
		return D_id;
	}
	public void setD_id(Long d_id) {
		D_id = d_id;
	}
	public String getD_contenent() {
		return D_contenent;
	}
	public void setD_contenent(String d_contenent) {
		D_contenent = d_contenent;
	}
	public Date getD_date() {
		return D_date;
	}
	public void setD_date(Date d_date) {
		D_date = d_date;
	}
	public Data() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Data(String d_contenent, Date d_date) {
		super();
		D_contenent = d_contenent;
		D_date = d_date;
	}

}

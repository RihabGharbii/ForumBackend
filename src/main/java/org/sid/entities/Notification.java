package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Notification implements Serializable {
	@Id
	@GeneratedValue
	private Long N_id;
	private String N_link;
	private String N_title;
	@Temporal(TemporalType.DATE)
	private Date Q_date;
	
	
	@OneToOne(mappedBy="notification")  // référence la relation dans la classe Commune
     private Comment comment ;
	 
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	@OneToOne(mappedBy="notification")  // référence la relation dans la classe Commune
    private Response response ;
	 
	public Response getResponse() {
		return response;
	}
	public Long getN_id() {
		return N_id;
	}
	public void setN_id(Long n_id) {
		N_id = n_id;
	}
	public String getN_link() {
		return N_link;
	}
	public void setN_link(String n_link) {
		N_link = n_link;
	}
	public String getN_title() {
		return N_title;
	}
	public void setN_title(String n_title) {
		N_title = n_title;
	}
	public Date getQ_date() {
		return Q_date;
	}
	public void setQ_date(Date q_date) {
		Q_date = q_date;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notification(String n_link, String n_title, Date q_date) {
		super();
		N_link = n_link;
		N_title = n_title;
		Q_date = q_date;
	}
	

}

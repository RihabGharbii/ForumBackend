package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity

public class Response extends Element implements Serializable{
	private Boolean R_isvalidate;
	private Rate R_rate;
	
	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Response(Long e_id, String e_contenent, Date e_date, Boolean r_isvalidate, Rate r_rate) {
		super(e_id, e_contenent,  e_date);
		R_isvalidate = r_isvalidate;
		R_rate = r_rate;
	}
	  
	@ManyToOne
    private Question question ;
	 @OneToMany(mappedBy="response")
     private Collection<Comment> comment ;

	@OneToOne
    private Notification notification ;
	
	
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public Boolean getR_isvalidate() {
		return R_isvalidate;
	}
	public void setR_isvalidate(Boolean r_isvalidate) {
		R_isvalidate = r_isvalidate;
	}
	public Rate getR_rate() {
		return R_rate;
	}
	public void setR_rate(Rate r_rate) {
		R_rate = r_rate;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
		if(!question.getResponse().contains(this)) {
			question.getResponse().add(this);
		}
}
	
/*	public void addComment(Comment comment) {
		this.comment.add(comment);
		comment.setResponse(this);
		
	}
	
	public Collection<Comment> getComment() {
	return this.comment;
	}*/

	public Collection<Comment> getComment() {
		return comment;
	}

	public void setComment(Collection<Comment> comment) {
		this.comment = comment;
	}
}

	
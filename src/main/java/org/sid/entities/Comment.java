package org.sid.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity


public class Comment extends Element implements Serializable{
	
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comment(Long e_id, String e_contenent, String e_title, Date e_date) {
		super();
		// TODO Auto-generated constructor stub
	}

	
    @ManyToOne
	private Response response;

	@OneToOne
    private Notification notification ;
	public Notification getNotification() {
		return notification;
	}

	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	
	public void setResponse(Response response) {
		this.response = response;
		if(!response.getComment().contains(this))
				{
			
			response.getComment().add(this);
		}
}
	

}

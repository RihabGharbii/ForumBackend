package org.sid.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity

public class Question extends Element implements Serializable {

	
	@ManyToMany
	private Collection<Tag> tag;
   
	@OneToMany(mappedBy="question")
    private Collection<Response> response ;

	public Collection<Response> getResponse() {
		return response;
	}

	public void setResponse(Collection<Response> response) {
		this.response = response;
	}

	private boolean faq;
	private Long nb_comment;
	private boolean favorite;
	private String title;

	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Collection<Tag> getTag() {
		return tag;
	}

	public void setTag(Collection<Tag> tag) {
		this.tag = tag;
	}

	public boolean isFaq() {
		return faq;
	}

	public void setFaq(boolean faq) {
		this.faq = faq;
	}

	public Long getNb_comment() {
		return nb_comment;
	}

	public void setNb_comment(Long nb_comment) {
		this.nb_comment = nb_comment;
	}

	public boolean isFavorite() {
		return favorite;
	}

	public void setFavorite(boolean favorite) {
		this.favorite = favorite;
	}

	public Question(Collection<Tag> tag, Collection<Response> response, boolean faq, Long nb_comment,
			boolean favorite) {
		super();
		this.tag = tag;
		this.response = response;
		this.faq = faq;
		this.nb_comment = nb_comment;
		this.favorite = favorite;
	}

	

}

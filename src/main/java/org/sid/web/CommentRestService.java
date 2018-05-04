package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.Commentrepository;
import org.sid.entities.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class CommentRestService {
	@Autowired //pour l'injection des dépendances
	private Commentrepository commentrepository;
	
	@RequestMapping(value="/Comment",method=RequestMethod.GET)
	public List<Comment> getcomment(){
		return commentrepository.findAll();
	}
	
    @RequestMapping(value="/Comment/{C_id}",method=RequestMethod.GET)
    public Optional<Comment> getcomment(@PathVariable Long C_id){
			return commentrepository.findById(C_id);
		}
	    
	@RequestMapping(value="/Comment",method=RequestMethod.POST)
	public Comment save(@RequestBody Comment c){
			return commentrepository.save(c);
		}
	    
	@RequestMapping(value="/Comment/{C_id}",method=RequestMethod.DELETE)
	public  boolean supprimer(@PathVariable Long C_id){
	    	commentrepository.deleteById(C_id);
		return true;
	}
}

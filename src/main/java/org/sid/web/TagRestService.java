package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.TagRepository;
import org.sid.entities.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class TagRestService {
	@Autowired
	private TagRepository tagRepository;
	
	@RequestMapping(value="/Tag",method=RequestMethod.GET)
	public List<Tag> gettag(){
		return tagRepository.findAll();
	}
	
	 @RequestMapping(value="/Tag/{T_id}",method=RequestMethod.GET)
	 public Optional<Tag> gettag(@PathVariable Long T_id){
			return tagRepository.findById(T_id);
		}
	    
	 @RequestMapping(value="/Tag",method=RequestMethod.POST)
     public Tag save(@RequestBody Tag t){
			return tagRepository.save(t);
		}
	    
	  @RequestMapping(value="/Tag/{T_id}",method=RequestMethod.DELETE)
	  public  boolean supprimer(@PathVariable Long T_id){
	    	tagRepository.deleteById(T_id);
		return true;
	}
}

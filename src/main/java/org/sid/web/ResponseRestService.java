package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.ResponseRepository;
import org.sid.entities.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
    @CrossOrigin(origins="*",maxAge=3600)
    @RestController
public class ResponseRestService {
	@Autowired
	private ResponseRepository responseRepository;
	
	@RequestMapping(value="/Response",method=RequestMethod.GET)
	public List<Response> getresponse(){
		return responseRepository.findAll();
	}
	
    @RequestMapping(value="/Response/{R_id}",method=RequestMethod.GET)
	public Optional<Response> getresponse(@PathVariable Long R_id){
		return responseRepository.findById(R_id);
	}
    
    @RequestMapping(value="/Response",method=RequestMethod.POST)
	public Response save(@RequestBody Response r){
		return responseRepository.save(r);
	}
    
   @RequestMapping(value="/Response/{R_id}",method=RequestMethod.DELETE)
    public  boolean supprimer(@PathVariable Long R_id){
    	responseRepository.deleteById(R_id);
	return true;
}
   @RequestMapping(value="/Response/{R_id}",method=RequestMethod.PUT)
   public  boolean editer(@RequestBody Response r){
   	responseRepository.save(r);
	return true;
  }
}

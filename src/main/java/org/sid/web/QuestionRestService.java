package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.QuestionRepository;
import org.sid.entities.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class QuestionRestService {
	@Autowired
	private QuestionRepository questionRepository;
	
	@RequestMapping(value="/Questions",method=RequestMethod.GET)
	public List<Question> getquestion(){
		return questionRepository.findAll();
	}
	
	@RequestMapping(value="/Questions/{Q_id}",method=RequestMethod.GET)
	
	public Optional<Question> getquestions(@PathVariable Long Q_id){
		return questionRepository.findById(Q_id);
	}
    @RequestMapping(value="/Questions",method=RequestMethod.POST)
	public Question save(@RequestBody Question q){
    	System.out.println(q.getE_contenent()+" "+q.getNb_comment());
		return questionRepository.save(q);
	}
    
   @RequestMapping(value="/Questions/{Q_id}",method=RequestMethod.DELETE)
    public  boolean supprimer(@PathVariable Long Q_id){
    	questionRepository.deleteById(Q_id);
	return true;
}
 
}

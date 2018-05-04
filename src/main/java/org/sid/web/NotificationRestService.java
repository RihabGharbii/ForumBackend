package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.NotificationRepository;
import org.sid.entities.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class NotificationRestService {
	@Autowired
	private NotificationRepository notificationRepository;
	
	@RequestMapping(value="/Notification",method=RequestMethod.GET)
	public List<Notification> getnotification(){
		return notificationRepository.findAll();
	}
	
	 @RequestMapping(value="/Notification/{N_id}",method=RequestMethod.GET)
		public Optional<Notification> getnotification(@PathVariable Long N_id){
			return notificationRepository.findById(N_id);
		}
	    
	    @RequestMapping(value="/Notification",method=RequestMethod.POST)
		public Notification save(@RequestBody Notification n){
			return notificationRepository.save(n);
		}
	    
	   @RequestMapping(value="/Notification/{N_id}",method=RequestMethod.DELETE)
	    public  boolean supprimer(@PathVariable Long N_id){
	    	notificationRepository.deleteById(N_id);
		return true;
	}
}

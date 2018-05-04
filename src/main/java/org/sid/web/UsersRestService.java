package org.sid.web;

import java.util.List;
import java.util.Optional;

import org.sid.dao.UsersRepository;
import org.sid.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*",maxAge=3600)
@RestController
public class UsersRestService {
	@Autowired
	private UsersRepository usersRepository;
	
	@RequestMapping(value = "/users/find", method = RequestMethod.GET)
	@ResponseBody
	public Users getusers(@RequestParam("username") String username) {
	    return usersRepository.findByUsername(username);
	}
	

	@RequestMapping(value="/Users",method=RequestMethod.GET)
	public List<Users> getusers(){
		return usersRepository.findAll();
	}
	
	@RequestMapping(value="/Users/{U_id}",method=RequestMethod.GET)
	
	public Optional<Users> getusers(@PathVariable Long U_id){
		return usersRepository.findById(U_id);
	}
}

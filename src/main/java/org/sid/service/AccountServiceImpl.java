package org.sid.service;

import org.sid.dao.RoleRepository;
import org.sid.dao.UsersRepository;
import org.sid.entities.Role;
import org.sid.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class AccountServiceImpl implements AcountService{
    
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    private UsersRepository userRepository;
    
    @Autowired
	private RoleRepository roleRepository;
    
   
	
    @Override
	public Users saveUser(Users user) {
		// on va crypter le mot de pass envoyer par l'utilisateur avant de l'enregistrer ds la BD
		String hash = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(hash);
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
	
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser (String username, String roleName) {
		Role role = roleRepository.findByRolename(roleName);
		Users user = userRepository.findByUsername(username);
		user.getRoles().add(role);
		
	}

	
	@Override
	public Users findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Users findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

}

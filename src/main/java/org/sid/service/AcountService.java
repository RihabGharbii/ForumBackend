package org.sid.service;

import org.sid.entities.Role;
import org.sid.entities.Users;

public interface AcountService {
	public Users saveUser(Users user);
    public Role saveRole(Role role);
    public void addRoleToUser(String username, String roleName);
    public Users findUserByUsername(String username);
	public Users findByUsername(String username);
}

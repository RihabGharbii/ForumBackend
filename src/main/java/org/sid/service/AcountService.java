package org.sid.service;

import org.sid.entities.Role;
import org.sid.entities.Users;

public interface AcountService {
	public Users saveUser(Users user);
    public Role saveRole(Role role);
}

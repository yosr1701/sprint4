package com.yosr.vetements.service;

import com.yosr.vetements.entities.Role;
import com.yosr.vetements.entities.User;

public interface UserService {
	void deleteAllusers();
	void deleteAllRoles();
	User saveUser(User user);
	User findUserByUsername (String username);
	Role addRole(Role role);
	User addRoleToUser(String username, String rolename);
}


package com.springapp.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.springapp.security.User;
import com.springapp.security.model.Role;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("UserDaoImpl.loadUserByUsername()");
		if(username.equalsIgnoreCase("ram")) {
			User user = new User();
			user.setFirstName("Ramkumar");
			user.setLastName("S");
			user.setUsername("ram");
			user.setPassword("ram");
			Role r = new Role();
	        r.setName("ROLE_USER");
	        List<Role> roles = new ArrayList<Role>();
	        roles.add(r);
	        user.setAuthorities(roles);
			return user;
		} 
		
		throw new UsernameNotFoundException("Invalid user credentials");
	}

}

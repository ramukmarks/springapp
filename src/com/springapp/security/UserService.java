package com.springapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springapp.dao.UserDao;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	UserDao userDao;

	@Override
	public User loadUserByUsername(String username)
			throws UsernameNotFoundException {
		System.out.println("UserService.loadUserByUsername()");
		return userDao.loadUserByUsername(username);
	}

}

package com.springapp.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springapp.security.User;

public interface UserDao {
	User loadUserByUsername(final String username) throws UsernameNotFoundException;

}

package com.wave.uis.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.wave.uis.model.entity.UserEntity;

@Service
public class AuthService implements UserDetailsService {

	@Autowired
	private UserService userService;

//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//		return new User("foo", "foo", new ArrayList<>());
//	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity usr = userService.getUserByEmail(username);
		return new User(usr.getEmail(), usr.getPassword(), new ArrayList<>());
	}

}

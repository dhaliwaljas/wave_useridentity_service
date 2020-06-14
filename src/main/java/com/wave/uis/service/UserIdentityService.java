package com.wave.uis.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wave.uis.model.converter.UserIdentityConverter;
import com.wave.uis.model.entity.UserIdentity;
import com.wave.uis.model.request.NewUserIdentity;
import com.wave.uis.repository.UserIdentityRepository;

@Service
public class UserIdentityService {

	@Autowired
	private UserIdentityRepository userIdRepo;

	public UserIdentity createUserIdentity(NewUserIdentity newUserIdentity) {
		UserIdentity userIdentity = UserIdentityConverter.newUserIdentityToUserIdentity(newUserIdentity);

		userIdentity.setId(UUID.randomUUID().toString());
		userIdentity.setEmail(newUserIdentity.getEmail());
		userIdentity.setPassword(newUserIdentity.getPassword());

		return userIdRepo.save(userIdentity);
	}

	public List<UserIdentity> getAll() {
		return userIdRepo.findAll();
	}

	public Optional<UserIdentity> getUserIdentity(String id) {
		return userIdRepo.findById(id);
	}

	public UserIdentity deleteUserIdentity(String id) {
		return userIdRepo.deleteUserIdentityById(id);
	}
}

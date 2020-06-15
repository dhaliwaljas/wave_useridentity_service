package com.wave.uis.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wave.uis.model.converter.UserIdentityConverter;
import com.wave.uis.model.entity.UserEntity;
import com.wave.uis.model.request.NewUserIdentity;
import com.wave.uis.repository.UserIdentityRepository;

@Service
public class UserService {

	@Autowired
	private UserIdentityRepository userRepo;

	public UserEntity createUserIdentity(NewUserIdentity newUserIdentity) {
		UserEntity userEntity = UserIdentityConverter.newUserIdentityToUserIdentity(newUserIdentity);

		userEntity.setId(UUID.randomUUID().toString());
		userEntity.setEmail(newUserIdentity.getEmail());
		userEntity.setPassword(newUserIdentity.getPassword());

		return userRepo.save(userEntity);
	}

	public List<UserEntity> getAll() {
		return userRepo.findAll();
	}

	public Optional<UserEntity> getUserByID(String id) {
		return userRepo.findById(id);
	}

	public UserEntity getUserByEmail(String email) {
		return userRepo.findOneByEmail(email);
	}

	public UserEntity deleteUserByID(String id) {
		return userRepo.deleteUserIdentityById(id);
	}
}

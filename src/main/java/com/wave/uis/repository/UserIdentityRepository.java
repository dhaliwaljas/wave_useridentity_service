package com.wave.uis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wave.uis.model.entity.UserEntity;

public interface UserIdentityRepository extends MongoRepository<UserEntity, String> {

	public UserEntity deleteUserIdentityById(String id);
	
	public UserEntity findOneByEmail(String email);

}

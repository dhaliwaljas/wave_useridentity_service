package com.wave.uis.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.wave.uis.model.entity.UserIdentity;

public interface UserIdentityRepository extends MongoRepository<UserIdentity, String> {

	public UserIdentity deleteUserIdentityById(String id);

}

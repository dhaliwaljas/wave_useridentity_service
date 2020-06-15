package com.wave.uis.model.converter;

import com.wave.uis.model.entity.UserEntity;
import com.wave.uis.model.request.NewUserIdentity;
import com.wave.uis.model.response.UserIdentityResponse;

public class UserIdentityConverter {

	public static UserEntity newUserIdentityToUserIdentity(NewUserIdentity newUserIdentity) {
		UserEntity userEntity = new UserEntity();

		userEntity.setEmail(newUserIdentity.getEmail());
		userEntity.setPassword(newUserIdentity.getPassword());

		return userEntity;
	}

	public static UserIdentityResponse userProfileToUserProfileResponse(UserEntity userEntity) {
		UserIdentityResponse usrIdentity = new UserIdentityResponse();

		usrIdentity.setEmail(userEntity.getEmail());
		usrIdentity.setPassword(userEntity.getPassword());
		usrIdentity.setId(userEntity.getId());

		return usrIdentity;
	}

}

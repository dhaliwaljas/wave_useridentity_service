package com.wave.uis.model.converter;

import com.wave.uis.model.entity.UserIdentity;
import com.wave.uis.model.request.NewUserIdentity;
import com.wave.uis.model.response.UserIdentityResponse;

public class UserIdentityConverter {

	public static UserIdentity newUserIdentityToUserIdentity(NewUserIdentity newUserIdentity) {
		UserIdentity userIdentity = new UserIdentity();

		userIdentity.setEmail(newUserIdentity.getEmail());
		userIdentity.setPassword(newUserIdentity.getPassword());

		return userIdentity;
	}

	public static UserIdentityResponse userProfileToUserProfileResponse(UserIdentity userIdentity) {
		UserIdentityResponse usrIdentity = new UserIdentityResponse();

		usrIdentity.setEmail(userIdentity.getEmail());
		usrIdentity.setPassword(userIdentity.getPassword());
		usrIdentity.setId(userIdentity.getId());

		return usrIdentity;
	}

}

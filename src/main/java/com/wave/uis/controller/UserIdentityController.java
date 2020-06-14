package com.wave.uis.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.uis.model.converter.UserIdentityConverter;
import com.wave.uis.model.entity.UserIdentity;
import com.wave.uis.model.request.NewUserIdentity;
import com.wave.uis.model.response.DeleteUserIdentityResponse;
import com.wave.uis.model.response.ErrorResponse;
import com.wave.uis.model.response.ModelDataResponse;
import com.wave.uis.model.response.ResponseModel;
import com.wave.uis.model.response.ResponseWrapper;
import com.wave.uis.model.response.UserIdentityResponse;
import com.wave.uis.service.UserIdentityService;

@RestController
@RequestMapping(path = "/users", consumes = "application/json", produces = "application/json")
public class UserIdentityController {

	@Autowired
	private UserIdentityService userIdentityService;

	@GetMapping
	public ResponseWrapper getAll() {
		System.out.println("==>");

		List<UserIdentity> usrList = userIdentityService.getAll();

		List<ResponseModel> usrIdentityResp = usrList.stream()
				.map(UserIdentityConverter::userProfileToUserProfileResponse).collect(Collectors.toList());

		return new ModelDataResponse(usrIdentityResp);

	}

	@GetMapping("/{id}")
	public ResponseWrapper getUserIdentity(@PathVariable("id") String id) {

		Optional<UserIdentity> usrOpt = userIdentityService.getUserIdentity(id);

		List<UserIdentityResponse> usrIdentityList = usrOpt.stream()
				.map(UserIdentityConverter::userProfileToUserProfileResponse).collect(Collectors.toList());

		if (usrIdentityList.size() > 0) {
			return new ModelDataResponse(usrIdentityList.get(0));
		}

		return new ErrorResponse("404", "User not found");

	}

	@PostMapping
	public ResponseWrapper createUserIdentity(@RequestBody NewUserIdentity newUserIdentity) {
		UserIdentity userIdentity = userIdentityService.createUserIdentity(newUserIdentity);
		UserIdentityResponse uir = UserIdentityConverter.userProfileToUserProfileResponse(userIdentity);

		return new ModelDataResponse(uir);
	}

	@DeleteMapping("/{id}")
	public ResponseWrapper deleteUserIdentity(@PathVariable String id) {
		UserIdentity usr = userIdentityService.deleteUserIdentity(id);

		if (usr == null) {
			return new ErrorResponse("404", "User not found");
		}

		return new ModelDataResponse(new DeleteUserIdentityResponse(id));
	}
}

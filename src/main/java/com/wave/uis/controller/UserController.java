package com.wave.uis.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.uis.model.converter.UserIdentityConverter;
import com.wave.uis.model.entity.UserEntity;
import com.wave.uis.model.response.DeleteUserIdentityResponse;
import com.wave.uis.model.response.ErrorResponse;
import com.wave.uis.model.response.ModelDataResponse;
import com.wave.uis.model.response.ResponseModel;
import com.wave.uis.model.response.ResponseWrapper;
import com.wave.uis.model.response.UserIdentityResponse;
import com.wave.uis.service.UserService;

@RestController
@RequestMapping(path = "/users", consumes = "application/json", produces = "application/json")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseWrapper getAll() {
		List<UserEntity> usrList = userService.getAll();

		List<ResponseModel> usrIdentityResp = usrList.stream()
				.map(UserIdentityConverter::userProfileToUserProfileResponse).collect(Collectors.toList());

		return new ModelDataResponse(usrIdentityResp);

	}

	@GetMapping("/{id}")
	public ResponseWrapper getUserByID(@PathVariable("id") String id) {

		Optional<UserEntity> usrOpt = userService.getUserByID(id);

		List<UserIdentityResponse> usrIdentityList = usrOpt.stream()
				.map(UserIdentityConverter::userProfileToUserProfileResponse).collect(Collectors.toList());

		if (usrIdentityList.size() > 0) {
			return new ModelDataResponse(usrIdentityList.get(0));
		}

		return new ErrorResponse("404", "UserEntity not found");

	}

	@DeleteMapping("/{id}")
	public ResponseWrapper deleteUserByID(@PathVariable String id) {
		UserEntity usr = userService.deleteUserByID(id);

		if (usr == null) {
			return new ErrorResponse("404", "UserEntity not found");
		}

		return new ModelDataResponse(new DeleteUserIdentityResponse(id));
	}

}

package com.wave.uis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wave.uis.model.converter.UserIdentityConverter;
import com.wave.uis.model.entity.UserEntity;
import com.wave.uis.model.request.AuthRequest;
import com.wave.uis.model.request.NewUserIdentity;
import com.wave.uis.model.response.AuthResponse;
import com.wave.uis.model.response.ModelDataResponse;
import com.wave.uis.model.response.ResponseWrapper;
import com.wave.uis.model.response.UserIdentityResponse;
import com.wave.uis.service.AuthService;
import com.wave.uis.service.UserService;
import com.wave.uis.utilitiy.JwtUtil;

@RestController
@RequestMapping(consumes = "application/json", produces = "application/json")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AuthService userDetailsService;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping("/login")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthRequest authRequest)
			throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getEmail(),
					authRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("incorrect username or password" + e);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getEmail());
		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return ResponseEntity.ok(new AuthResponse(jwt));

	}

	@PostMapping("/register")
	public ResponseWrapper createUserIdentity(@RequestBody NewUserIdentity newUserIdentity) {
		UserEntity userEntity = userService.createUserIdentity(newUserIdentity);
		UserIdentityResponse uir = UserIdentityConverter.userProfileToUserProfileResponse(userEntity);

		return new ModelDataResponse(uir);
	}

}

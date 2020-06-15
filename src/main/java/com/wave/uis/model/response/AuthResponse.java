package com.wave.uis.model.response;

public class AuthResponse {

	private final String jwt;

	public AuthResponse(String jwt) {
		super();
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

}

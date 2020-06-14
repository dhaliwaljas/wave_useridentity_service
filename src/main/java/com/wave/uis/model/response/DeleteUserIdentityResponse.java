package com.wave.uis.model.response;

public class DeleteUserIdentityResponse implements ResponseModel {
	public String id;

	public DeleteUserIdentityResponse() {
		super();
	}

	public DeleteUserIdentityResponse(String id) {
		super();
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}

package com.wave.uis.model.response;

public class ErrorResponse implements ResponseWrapper {

	private String statusCode;
	private String errorMessage;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(String statusCode, String errorMessage) {
		super();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	// TODO private String errorCode;

}

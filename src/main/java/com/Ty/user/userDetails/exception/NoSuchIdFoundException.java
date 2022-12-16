package com.Ty.user.userDetails.exception;

public class NoSuchIdFoundException extends RuntimeException {
String message="NoSuchIdFoundException";
	@Override
	public String getMessage() {
		return getMessage();
	}

	public NoSuchIdFoundException(String message) {
		super();
		this.message=message;
	}

	public NoSuchIdFoundException() {
		super();
	}
}

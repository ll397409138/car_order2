package com.car.app.common.exception;

public class FileTooLargeException extends RuntimeException {
	
	public FileTooLargeException() {
	}

	public FileTooLargeException(String message) {
		super(message);
	}

	public FileTooLargeException(Throwable cause) {
		super(cause);
	}

	public FileTooLargeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileTooLargeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super();
	}

}

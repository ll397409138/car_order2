package com.car.app.common.exception;

public class SettlementAmountException  extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SettlementAmountException() {
	}

	public SettlementAmountException(String message) {
		super(message);
	}

	public SettlementAmountException(Throwable cause) {
		super(cause);
	}

	public SettlementAmountException(String message, Throwable cause) {
		super(message, cause);
	}

	public SettlementAmountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super();
	}
}

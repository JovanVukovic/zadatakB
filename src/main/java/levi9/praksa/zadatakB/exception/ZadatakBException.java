package levi9.praksa.zadatakB.exception;

import levi9.praksa.zadatakB.ErrorCodes;

public class ZadatakBException extends RuntimeException {

	private int code;
	private String description;

	public ZadatakBException(ErrorCodes code, String description) {
		super();
		this.code = code.getCode();
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

}

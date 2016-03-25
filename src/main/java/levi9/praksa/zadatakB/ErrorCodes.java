package levi9.praksa.zadatakB;

public enum ErrorCodes {

	BAD_JSON_FILE(0),
	NON_REACHABLE_PROFIT(1),
	BAD_JSON_ONLY_ONE_BOOKIE(2),
	NO_MATCH(3),
	BAD_JSON_MISSING_CODE(6);	
	
	private int code;
	
	ErrorCodes(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}	
}

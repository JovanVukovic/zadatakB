package levi9.praksa.zadatakB.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "errorCode", "errorDescription"})
public class ErrorJSON {

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("errorCode")
	private Integer errorCode;
	
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("errorDescription")
	private String errorDescription;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}	
}

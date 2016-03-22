package levi9.praksa.zadatakB.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "error_code", "error_description"})
public class ErrorJSON {

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("error_code")
	private Integer error_code;
	
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("error_description")
	private String error_description;

	public Integer getError_code() {
		return error_code;
	}

	public void setError_code(Integer error_code) {
		this.error_code = error_code;
	}

	public String getError_description() {
		return error_description;
	}

	public void setError_description(String error_description) {
		this.error_description = error_description;
	}
	
	
}

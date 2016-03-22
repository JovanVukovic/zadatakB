package levi9.praksa.zadatakB.model;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
// @Generated("org.jsonschema2pojo")
public class PlacedBet {

	@JsonProperty("bookieId")
	private String bookieId;
	
	@JsonProperty("betHome")
	private Double betHome;
	
	@JsonProperty("betAway")
	private Double betAway;
	
	//@JsonIgnore
	//private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public PlacedBet() {
		super();
	}

	/**
	*
	* @param additionalProperties
	* 
	*/
	public PlacedBet(String bookieId, Double betHome, Double betAway) {
		this.bookieId=bookieId;
		this.betHome=betHome;
		this.betAway=betAway;
		//this.additionalProperties = additionalProperties;
	}

	public String getBookieId() {
		return bookieId;
	}

	public void setBookieId(String bookieId) {
		this.bookieId = bookieId;
	}

	public Double getBetHome() {
		return betHome;
	}

	public void setBetHome(Double betHome) {
		this.betHome = betHome;
	}

	public Double getBetAway() {
		return betAway;
	}

	public void setBetAway(Double betAway) {
		this.betAway = betAway;
	}
	
	
	
	
	
	
	
	
	//public PlacedBet(Map<String, Object> additionalProperties) {
	//	super();
		//this.additionalProperties = additionalProperties;
	//}

	/*@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "PlacedBet [additionalProperties=" + additionalProperties + "]";
	}*/

}

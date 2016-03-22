package levi9.praksa.zadatakB.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
// @Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "name", "oddsHome", "oddsAway", "maxBet" })
public class BetOffer {

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("id")
	private String id;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("name")
	private String name;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("oddsHome")
	private Double oddsHome;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("oddsAway")
	private Double oddsAway;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("maxBet")
	private Double maxBet;
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public BetOffer() {
	}

	/**
	*
	* @param oddsAway
	* @param id
	* @param name
	* @param maxBet
	* @param oddsHome
	*/
	public BetOffer(String id, String name, Double oddsHome, Double oddsAway, Double maxBet) {
	this.id = id;
	this.name = name;
	this.oddsHome = oddsHome;
	this.oddsAway = oddsAway;
	this.maxBet = maxBet;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The id
	 */
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param id
	 *            The id
	 */
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The name
	 */
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param name
	 *            The name
	 */
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The oddsHome
	 */
	@JsonProperty("oddsHome")
	public Double getOddsHome() {
		return oddsHome;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param oddsHome
	 *            The oddsHome
	 */
	@JsonProperty("oddsHome")
	public void setOddsHome(Double oddsHome) {
		this.oddsHome = oddsHome;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The oddsAway
	 */
	@JsonProperty("oddsAway")
	public Double getOddsAway() {
		return oddsAway;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param oddsAway
	 *            The oddsAway
	 */
	@JsonProperty("oddsAway")
	public void setOddsAway(Double oddsAway) {
		this.oddsAway = oddsAway;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The maxBet
	 */
	@JsonProperty("maxBet")
	public Double getMaxBet() {
		return maxBet;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param maxBet
	 *            The maxBet
	 */
	@JsonProperty("maxBet")
	public void setMaxBet(Double maxBet) {
		this.maxBet = maxBet;
	}

	@Override
	public String toString() {
		return "BetOffer [id=" + id + ", name=" + name + ", oddsHome=" + oddsHome + ", oddsAway=" + oddsAway
				+ ", maxBet=" + maxBet + "]";
	}
	
	

}

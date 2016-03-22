package levi9.praksa.zadatakB.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
// @Generated("org.jsonschema2pojo")
@JsonPropertyOrder({ "id", "name", "betOffers" })
public class Booky {

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
	@JsonProperty("betOffers")
	private List<BetOffer> betOffers = new ArrayList<BetOffer>();
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public Booky() {
	}

	/**
	*
	* @param id
	* @param betOffers
	* @param name
	*/
	public Booky(String id, String name, List<BetOffer> betOffers) {
	this.id = id;
	this.name = name;
	this.betOffers = betOffers;
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
	 * @return The betOffers
	 */
	@JsonProperty("betOffers")
	public List<BetOffer> getBetOffers() {
		return betOffers;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param betOffers
	 *            The betOffers
	 */
	@JsonProperty("betOffers")
	public void setBetOffers(List<BetOffer> betOffers) {
		this.betOffers = betOffers;
	}

}

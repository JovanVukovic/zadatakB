package levi9.praksa.zadatakB.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "oddsHome", "oddsAway", "maxBet" })
@Entity
@Table(name="bet_offer")
public class BetOffer {
	
	@Column
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id_bet_offer;

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("id")
	@Column
	private String id;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("name")
	@Column
	private String name;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("oddsHome")
	@Column
	private Double oddsHome;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("oddsAway")
	@Column
	private Double oddsAway;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("maxBet")
	@Column
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BetOffer other = (BetOffer) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (maxBet == null) {
			if (other.maxBet != null)
				return false;
		} else if (!maxBet.equals(other.maxBet))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (oddsAway == null) {
			if (other.oddsAway != null)
				return false;
		} else if (!oddsAway.equals(other.oddsAway))
			return false;
		if (oddsHome == null) {
			if (other.oddsHome != null)
				return false;
		} else if (!oddsHome.equals(other.oddsHome))
			return false;
		return true;
	}
}

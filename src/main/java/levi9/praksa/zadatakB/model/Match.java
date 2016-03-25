package levi9.praksa.zadatakB.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "placedBets" })
@Entity
@Table(name = "`match`")
public class Match {

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("id")
	@Column
	@Id
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
	@JsonProperty("placedBets")
	@ElementCollection
	@CollectionTable(name = "placed_bets", joinColumns = @JoinColumn(name = "id"))
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "match_id")
	private List<PlacedBet> placedBets = new ArrayList<PlacedBet>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public Match() {
	}

	/**
	 *
	 * @param id
	 * @param placedBets
	 * @param name
	 */
	public Match(String id, String name, List<PlacedBet> placedBets) {
		this.id = id;
		this.name = name;
		this.placedBets = placedBets;
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
	 * @return The placedBets
	 */
	@JsonProperty("placedBets")
	public List<PlacedBet> getPlacedBets() {
		return placedBets;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param placedBets
	 *            The placedBets
	 */
	@JsonProperty("placedBets")
	public void setPlacedBets(List<PlacedBet> placedBets) {
		this.placedBets = placedBets;
	}

}
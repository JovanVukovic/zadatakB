package levi9.praksa.zadatakB.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "id", "name", "betOffers" })
@Entity
@Table(name="booky")
public class Booky {

	@Column
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id_booky;
	
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
	@JsonProperty("betOffers")
	@ElementCollection
	@CollectionTable(name="bet_offers", joinColumns=@JoinColumn(name="id"))
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="booky_id")
	private List<BetOffer> betOffers;
	
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Booky other = (Booky) obj;
		if (betOffers == null) {
			if (other.betOffers != null)
				return false;
		} else if (!betOffers.equals(other.betOffers))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Booky id_booky= " + id_booky + ", id=" + id + ", name=" + name + ", betOffers=" + betOffers + "]";
	}
}

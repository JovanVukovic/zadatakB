package levi9.praksa.zadatakB.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name="placed_bet")
public class PlacedBet {

	@Id
	@Column
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	@JsonProperty("bookieId")
	@Column
	private String bookieId;
	
	@JsonProperty("betHome")
	@Column
	private Double betHome;
	
	@JsonProperty("betAway")
	@Column
	private Double betAway;
		
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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlacedBet other = (PlacedBet) obj;
		if (betAway == null) {
			if (other.betAway != null)
				return false;
		} else if (!betAway.equals(other.betAway))
			return false;
		if (betHome == null) {
			if (other.betHome != null)
				return false;
		} else if (!betHome.equals(other.betHome))
			return false;
		if (bookieId == null) {
			if (other.bookieId != null)
				return false;
		} else if (!bookieId.equals(other.bookieId))
			return false;		
		return true;
	}
}

package levi9.praksa.zadatakB.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@JsonPropertyOrder({ "calculatedProfit", "matches" })
@Entity
@Table(name="example_out")
public class ExampleOut {

	@Column
	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;
	
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("calculatedProfit")
	@Column
	private Double calculatedProfit;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("matches")
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="example_out_id")
	private List<Match> matches = new ArrayList<Match>();
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public ExampleOut() {
	}

	/**
	*
	* @param matches
	* @param calculatedProfit
	*/
	public ExampleOut(Double calculatedProfit, List<Match> matches) {
	this.calculatedProfit = calculatedProfit;
	this.matches = matches;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The calculatedProfit
	 */
	@JsonProperty("calculatedProfit")
	public Double getCalculatedProfit() {
		return calculatedProfit;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param calculatedProfit
	 *            The calculatedProfit
	 */
	@JsonProperty("calculatedProfit")
	public void setCalculatedProfit(Double calculatedProfit) {
		this.calculatedProfit = calculatedProfit;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The matches
	 */
	@JsonProperty("matches")
	public List<Match> getMatches() {
		return matches;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param matches
	 *            The matches
	 */
	@JsonProperty("matches")
	public void setMatches(List<Match> matches) {
		this.matches = matches;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	

}

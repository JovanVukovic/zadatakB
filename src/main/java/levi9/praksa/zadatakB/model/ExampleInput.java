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
@JsonPropertyOrder({ "budget", "desiredProfit", "bookies" })
@Entity
@Table(name="example_input")
public class ExampleInput {
	
	
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
	@JsonProperty("budget")
	@Column
	private Double budget;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("desiredProfit")
	@Column
	private Double desiredProfit;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("bookies")
	@OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="example_input_id")
	private List<Booky> bookies = new ArrayList<Booky>();
	
	
	/**
	* No args constructor for use in serialization
	*
	*/
	public ExampleInput() {
	}

	/**
	*
	* @param budget
	* @param bookies
	* @param desiredProfit
	*/
	public ExampleInput(Double budget, Double desiredProfit, List<Booky> bookies) {
	this.budget = budget;
	this.desiredProfit = desiredProfit;
	this.bookies = bookies;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The budget
	 */
	@JsonProperty("budget")
	public Double getBudget() {
		return budget;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param budget
	 *            The budget
	 */
	@JsonProperty("budget")
	public void setBudget(Double budget) {
		this.budget = budget;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The desiredProfit
	 */
	@JsonProperty("desiredProfit")
	public Double getDesiredProfit() {
		return desiredProfit;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param desiredProfit
	 *            The desiredProfit
	 */
	@JsonProperty("desiredProfit")
	public void setDesiredProfit(Double desiredProfit) {
		this.desiredProfit = desiredProfit;
	}

	/**
	 *
	 * (Required)
	 *
	 * @return The bookies
	 */
	@JsonProperty("bookies")
	public List<Booky> getBookies() {
		return bookies;
	}

	/**
	 *
	 * (Required)
	 *
	 * @param bookies
	 *            The bookies
	 */
	@JsonProperty("bookies")
	public void setBookies(List<Booky> bookies) {
		this.bookies = bookies;
	}
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ExampleInput [budget=" + budget + ", desiredProfit=" + desiredProfit + ", bookies=" + bookies + "]";
	}

}

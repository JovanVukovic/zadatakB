package levi9.praksa.zadatakB.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "budget", "desiredProfit", "bookies" })
public class ExampleInput {

	@Override
	public String toString() {
		return "ExampleInput [budget=" + budget + ", desiredProfit=" + desiredProfit + ", bookies=" + bookies + "]";
	}

	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("budget")
	private Double budget;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("desiredProfit")
	private Double desiredProfit;
	/**
	 *
	 * (Required)
	 *
	 */
	@JsonProperty("bookies")
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

}

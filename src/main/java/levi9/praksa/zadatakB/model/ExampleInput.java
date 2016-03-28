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
@Table(name = "example_input")
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
	@JoinColumn(name = "example_input_id")
	private List<Booky> bookies = new ArrayList<Booky>();

	/**
	 * No args constructor for use in serialization
	 *
	 */
	public ExampleInput() {
	}

	public ExampleInput(Long id, Double budget, Double desiredProfit, List<Booky> bookies) {
		super();
		this.id = id;
		this.budget = budget;
		this.desiredProfit = desiredProfit;
		this.bookies = bookies;
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
		return "ExampleInput budget= " + budget + ", desiredProfit= " + desiredProfit + ", bookies= " + bookies + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExampleInput other = (ExampleInput) obj;
		if (bookies == null) {
			if (other.bookies != null)
				return false;
		} else if (!bookies.equals(other.bookies))
			return false;
		if (budget == null) {
			if (other.budget != null)
				return false;
		} else if (!budget.equals(other.budget))
			return false;
		if (desiredProfit == null) {
			if (other.desiredProfit != null)
				return false;
		} else if (!desiredProfit.equals(other.desiredProfit))
			return false;
		
		return true;
	}
}

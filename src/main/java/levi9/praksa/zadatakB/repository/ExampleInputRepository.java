package levi9.praksa.zadatakB.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import levi9.praksa.zadatakB.model.ExampleInput;

public interface ExampleInputRepository extends JpaRepository<ExampleInput, Long> {

	/**
	 * Returns list of ExampleInput that have same Budget and DesiredProfit from database
	 * @param budget
	 * @param desiredProfit
	 * @return Returns list of ExampleInput.
	 */
	List<ExampleInput> findByBudgetAndDesiredProfit(Double budget, Double desiredProfit);
}

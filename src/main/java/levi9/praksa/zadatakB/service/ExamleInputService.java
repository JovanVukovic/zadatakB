package levi9.praksa.zadatakB.service;

import java.util.List;

import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.model.Match;

public interface ExamleInputService {

	/**
	 * Returns ExampleOut object.
	 * @param exampleInput
	 * @return ExampleOut, if exampleInput is valid.
	 */
	ExampleOut processInput(ExampleInput exampleInput);
}

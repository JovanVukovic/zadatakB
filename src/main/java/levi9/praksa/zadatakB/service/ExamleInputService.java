package levi9.praksa.zadatakB.service;

import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;

public interface ExamleInputService {

	/**
	 * Returns ExampleOut object.
	 * @param exampleInput
	 * @return ExampleOut, if exampleInput is valid.
	 */
	ExampleOut processInput(ExampleInput exampleInput);
	
	
}

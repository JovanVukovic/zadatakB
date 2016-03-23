package levi9.praksa.zadatakB.controller;

import levi9.praksa.zadatakB.impl.InMemoryExampleInput;
import levi9.praksa.zadatakB.impl.InMemoryExampleOut;
import levi9.praksa.zadatakB.model.ErrorJSON;
import levi9.praksa.zadatakB.model.ExampleOut;

public class ApiController {

	private InMemoryExampleInput inMemoryInput = new InMemoryExampleInput();
	private InMemoryExampleOut inMemoryOut = new InMemoryExampleOut();

	// private ExamleInputService exampleInputService;
	// private ExampleOutService exampleOutService;
	// private ExampleInput exampleInput = inMemoryInput.findAll("");
	private ExampleOut exampleOut = null;

	public ExampleOut getExampleOut(String path, String outPath) {

		exampleOut = inMemoryInput.findExampleOut(path);
		if (exampleOut == null) {
			ErrorJSON error = new ErrorJSON();
			error.setError_code(1);
			error.setError_description("Bad JSON file. There is only one Booky!");
			boolean written = inMemoryOut.writeError(error, outPath);
			return null;
		} else if (exampleOut.getMatches() == null) {
			ErrorJSON error = new ErrorJSON();
			error.setError_code(2);
			error.setError_description("No matches!");
			boolean written = inMemoryOut.writeError(error, outPath);
			return null;
		} else {
			boolean written = inMemoryOut.writeAll(exampleOut, outPath);
			if (written) {
				return exampleOut;
			} else {
				return null;
			}
		}
	}
}

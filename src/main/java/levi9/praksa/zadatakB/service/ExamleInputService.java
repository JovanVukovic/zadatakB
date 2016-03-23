package levi9.praksa.zadatakB.service;

import java.util.List;

import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.model.Match;

public interface ExamleInputService {

	ExampleInput findAll(String filePath);

	List<Match> findMatches(ExampleInput exampleInput);

	ExampleOut findExampleOut(String path);
}

package levi9.praksa.zadatakB;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import levi9.praksa.zadatakB.controller.Controller;
import levi9.praksa.zadatakB.impl.InMemoryExampleInput;
import levi9.praksa.zadatakB.impl.InMemoryExampleOut;
import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.service.ExamleInputService;

public class Main {

	public static void main(String[] args) {
		System.out.println("Radi...");
		
		InMemoryExampleInput inMemoryInput = new InMemoryExampleInput();
		ExampleInput inputObject=inMemoryInput.findAll();
		//System.out.println("Main "+inputObject.getBookies().get(0).getBetOffers());
		
		Controller c = new Controller();
		ExampleOut out = c.findOdds(inputObject);
		
		InMemoryExampleOut inMemoryOut = new InMemoryExampleOut();
		inMemoryOut.writeAll(out, null);
	}

}

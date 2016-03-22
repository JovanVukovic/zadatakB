package levi9.praksa.zadatakB.impl;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import levi9.praksa.zadatakB.model.BetOffer;
import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.service.ExamleInputService;

public class InMemoryExampleInput implements ExamleInputService {

	public ExampleInput findAll() {

		ObjectMapper mapper = new ObjectMapper();
		ExampleInput inputObject = null;

		try {

			// Convert JSON string from file to Object
			inputObject = mapper.readValue(new File("D:\\JovanVukovic\\praksa\\zadatak-b\\test1-happy-flow.json"), ExampleInput.class);
			//System.out.println(inputObject.getBookies().get(0).getName());
			//System.out.println(inputObject.getBookies().get(1).getName());
			for (int i = 0; i < inputObject.getBookies().get(0).getBetOffers().size(); i++) {
				//System.out.println(inputObject.getBookies().get(0).getBetOffers().get(i).getName());

			}

			// Convert JSON string to Object
			//String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			//ExampleInput staff1 = mapper.readValue(jsonInString, ExampleInput.class);
			//System.out.println(staff1);

			//Pretty print
			//String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
			//System.out.println(prettyStaff1);
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return inputObject;
	}

}

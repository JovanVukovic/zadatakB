/* 
 * Levi9 internship 21-25 March 2016.
 * Jovan Vukovic
 * Application for finding arbitrage bets, and calculates amount of money to place on bets,
 * based on desired profit, budget and maximum bet on single match. 
 * 
 * */
package levi9.praksa.zadatakB;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.ObjectMapper;

import levi9.praksa.zadatakB.exception.ZadatakBException;
import levi9.praksa.zadatakB.impl.ExampleInputServiceImpl;
import levi9.praksa.zadatakB.model.ErrorJSON;
import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.service.ExamleInputService;

@SpringBootApplication
public class Main {

	public static final ObjectMapper MAPPER = new ObjectMapper();
	public static final Logger logger = LogManager.getLogger(Main.class);

	public static void commandLineApp(String[] args) {
		try {
			ExamleInputService inputService = new ExampleInputServiceImpl();
			if (args.length < 1) {

			} else if (args.length == 1) {
				ExampleInput exampleInput = MAPPER.readValue(new File(args[0]), ExampleInput.class);
				ExampleOut out = inputService.processInput(exampleInput);
				MAPPER.writeValue(new File("D:\\out.json"), out);
			} else {
				ExampleInput exampleInput = MAPPER.readValue(new File(args[0]), ExampleInput.class);
				ExampleOut out = inputService.processInput(exampleInput);
				MAPPER.writeValue(new File(args[1]), out);
			}

		} catch (IOException e) {
			ErrorJSON error = new ErrorJSON();
			error.setErrorCode(5);
			error.setErrorDescription("Input/Output error");
			write(args[1], error);
			e.printStackTrace();
		} catch (ZadatakBException e) {
			ErrorJSON error = new ErrorJSON();
			error.setErrorCode(e.getCode());
			error.setErrorDescription(e.getDescription());
			write(args[1], error);
		}
	}

	public static void write(String pathOut, ErrorJSON errorOut) {
		try {
			MAPPER.writeValue(new File(pathOut), errorOut);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		// commandLineApp(args);
		SpringApplication.run(Main.class, args);
		logger.info("Application has started running...");
	}

}

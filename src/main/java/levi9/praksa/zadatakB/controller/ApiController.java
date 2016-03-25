package levi9.praksa.zadatakB.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import levi9.praksa.zadatakB.ErrorCodes;
import levi9.praksa.zadatakB.exception.ZadatakBException;
import levi9.praksa.zadatakB.model.ErrorJSON;
import levi9.praksa.zadatakB.model.ExampleInput;
import levi9.praksa.zadatakB.model.ExampleOut;
import levi9.praksa.zadatakB.service.ExamleInputService;

@RestController
@RequestMapping(value = "/")
public class ApiController {

	private static final Logger logger = Logger.getLogger(ApiController.class);

	@Autowired
	private ExamleInputService inputService;
	
	
	@RequestMapping(value = "api/matches", method = RequestMethod.POST)
	public ExampleOut HandleRequest(@RequestBody ExampleInput exampleInput) {
		
		return inputService.processInput(exampleInput);
	}

	@ExceptionHandler(ZadatakBException.class)
	public ResponseEntity<ErrorJSON> handleErrorException(ZadatakBException exception) {
		ErrorJSON error = new ErrorJSON();
		error.setErrorCode(exception.getCode());
		error.setErrorDescription(exception.getDescription());
		return new ResponseEntity<ErrorJSON>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorJSON> handleError(HttpServletRequest req, Exception exception) {
	    logger.error("Request: " + req.getRequestURL() + " raised " + exception);
	    ErrorJSON error = new ErrorJSON();
		error.setErrorCode(ErrorCodes.BAD_JSON_FILE.getCode());
		error.setErrorDescription(exception.getMessage());		
	    return new ResponseEntity<ErrorJSON>(error, HttpStatus.BAD_REQUEST);
	  }

	
}

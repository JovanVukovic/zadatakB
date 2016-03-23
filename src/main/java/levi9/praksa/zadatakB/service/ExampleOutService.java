package levi9.praksa.zadatakB.service;

import levi9.praksa.zadatakB.model.ErrorJSON;
import levi9.praksa.zadatakB.model.ExampleOut;

public interface ExampleOutService {
	
	ExampleOut writeAll(ExampleOut staf,ErrorJSON error,String outFile);
	
	boolean writeError(ErrorJSON error, String outFile);

}

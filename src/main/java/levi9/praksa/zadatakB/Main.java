package levi9.praksa.zadatakB;

import levi9.praksa.zadatakB.controller.ApiController;
import levi9.praksa.zadatakB.model.ExampleOut;

public class Main {

	public static void main(String[] args) {
		System.out.println("Radi...");
				
		ApiController apiController = new ApiController();
		
		//String path ="D:\\JovanVukovic\\praksa\\zadatak-b\\test3-only-one-match.json";
		//ExampleOut out = apiController.getExampleOut(path, null);
		
		if (args.length<1) {
			System.out.println("You did not enerd input file path");
		}else if (args.length==1) {
			ExampleOut out = apiController.getExampleOut(args[0], null);
			System.out.println("Putanja ulzanog "+args[0]);
		}else{
			ExampleOut out = apiController.getExampleOut(args[0], args[1]);
			System.out.println("Putanja ulzanog "+args[0]);
			System.out.println("Putanja izlaznog "+args[1]);
		}
	}

}

package levi9.praksa.zadatakB.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {
	
	@RequestMapping("/")
	public String welcome(){
		return "/static/html/index.html";
	}


}

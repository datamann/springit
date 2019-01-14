package com.sbs.springit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	//@RequestMapping( path = "/", method = RequestMethod.GET, consumes = "application/json", produces = "application/html")
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Hello World!");
		return "index";
	}
}

package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {

	@RequestMapping("/")
	public String index(ModelMap model){
		model.addAttribute("msg", "world");
		return "index";
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String hello(){
		return "Hello World~!!!";
	}
	
	@RequestMapping(value = "/emp")
	public String emp(ModelMap model){
		return "emp";
	}
	
}

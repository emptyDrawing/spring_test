package com.bit.myapp02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test03")
public class Ex03Controller {

	
	@RequestMapping("/ver1")
	public String test() {
		return "index";
	}
	
	
}// Ex03Controller

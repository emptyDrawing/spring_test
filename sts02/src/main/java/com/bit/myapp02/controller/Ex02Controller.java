package com.bit.myapp02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest3")
public class Ex02Controller {

	@RequestMapping("/lec01")
	public String ex01() {
		return "ex01";
	}

	@RequestMapping("/lec03")
	public String ex03() {
		return "ex03";
	}
	
	
}

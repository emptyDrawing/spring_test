package com.bit.boot01.springboot011.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	@RequestMapping("/next")
	public String next(Model model) {
		model.addAttribute("msg", "동적페이지");
		return "two";
	}
	
}

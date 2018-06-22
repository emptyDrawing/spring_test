package com.bit.myapp02.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/guest3")
public class Ex02Controller {

	@RequestMapping("/lec01")
	public String ex10() {
		return "ex10";
	}
	
	@RequestMapping("/lec02")
	public String ex11(String id, String pw, HttpSession session) {
		if(id.equals("admin")&&pw.equals("1234")) {
			session.setAttribute("login", true);;
		}
		return "ex11";
	}
	
	@RequestMapping("/lec03/{msg}")
	public String ex04(@PathVariable String msg, Model model){
		model.addAttribute("msg",msg);
		return "ex12";
	}
//	@RequestMapping("/lec03")
//	public String ex04(@ModelAttribute("msg") String msg){
//		return "ex12";
//	}
	
	@RequestMapping("/{path}/{msg}")
	public String ex05(@PathVariable String msg, @PathVariable String path, Model model ) {
		model.addAttribute("pathName", path);
		return "ex12";
	}
	
	
}

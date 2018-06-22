package com.bit.myapp02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp02.model.entity.GuestVo;

@Controller
public class Ex01Controller {

	@RequestMapping("/ex01")
	public String execute() {
		return "ex01";
	}

	@RequestMapping(value="/guest/ex02", method=RequestMethod.GET )
	public String execute1() {
		return "ex01";
	}
	
	@RequestMapping(value="/guest/ex02", method=RequestMethod.POST )
//	public void execute2(@RequestParam("id") String a, @RequestParam("pw") int b) {
	public void execute2(String id, int pw) {
		System.out.println("id:"+id);
		System.out.println("pw:"+pw);
	}
	
	@RequestMapping("/ex03")
	public void ex03() {}
	
	@RequestMapping("/ex04")
	public void ex04(@ModelAttribute("bean") GuestVo command) {}

//	@RequestMapping("/ex04")
//	public void ex04(@ModelAttribute GuestVo command, Model model) {
//		model.addAttribute("bean", command);
//	}

//	@RequestMapping("/ex04")
//	public void ex04(int sabun, String name, Model model) {
//		GuestVo bean = new GuestVo();
//		bean.setSabun(sabun);
//		bean.setName(name);
//		model.addAttribute("bean", bean);
//	}
	
	
	
	
}

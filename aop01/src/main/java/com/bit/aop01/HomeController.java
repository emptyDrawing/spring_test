package com.bit.aop01;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.aop01.model.GuestDao;

@Controller
public class HomeController {
	
	@Autowired
	GuestDao proxyFactoryBean;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		proxyFactoryBean.func01();
		return "home";
	}
	
	@RequestMapping("/next")
	public String two() {
		proxyFactoryBean.func02();
		return "two";
	}
	
}

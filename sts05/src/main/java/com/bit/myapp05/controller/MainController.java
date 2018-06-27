package com.bit.myapp05.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp05.model.entity.GuestVo;
import com.bit.myapp05.services.GuestService;

@Controller
public class MainController {

	String re_view = "redirect:/guest/";
	
	@Autowired
	GuestService service;
	
	public void setService(GuestService service) {
		this.service = service;
	}
	
	@RequestMapping("/")
	public String test() throws SQLException {
		return "home";
	}
	
	@RequestMapping(value="/guest/", method=RequestMethod.GET)
	public String list(Model model) throws SQLException {
		service.listPage(model);
		return "list";
	}

	@RequestMapping(value="/guest/{sabun}", method= RequestMethod.GET)
	public String detail(Model model, @PathVariable int sabun) throws SQLException {
		model.addAttribute("sabun",sabun);
		return list(model);
	}
	@RequestMapping(value="/guest/", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestVo bean) throws SQLException {
		service.insertPage(bean);
		return re_view;
	}

	@RequestMapping(value="/guest/{sabun}", method=RequestMethod.PUT)
	public String update(@PathVariable int sabun, @ModelAttribute GuestVo bean, Model model ) throws SQLException{
		service.updateOne(bean);
		return re_view+sabun;
	}

	@RequestMapping(value="/guest/{sabun}", method=RequestMethod.DELETE)
	public String deleteOne(@PathVariable int sabun) throws SQLException{
		service.deleteOne(sabun);
		return re_view;
	}
	
}




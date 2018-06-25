package com.bit.myapp03.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.myapp03.model.GuestDao;

@Controller
public class GuestController {

	@Autowired
	GuestDao guestDao;
	private String goRoot ="./";


	@RequestMapping("/guest")
	public String list(Model model) throws SQLException{
		model.addAttribute("alist", guestDao.selectAll());
		model.addAttribute("goRoot", goRoot );
		return "list";
	}
	
}

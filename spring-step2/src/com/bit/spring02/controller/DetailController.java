package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bit.spring02.model.GuestDao1;

public class DetailController implements Controller {

	public DetailController() {
		System.out.println("DetailCon.. Create....");
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		ModelAndView mav = new ModelAndView();

		String idx = request.getParameter("idx");
		
		GuestDao1 dao = new GuestDao1();
		
		mav.addObject("bean", dao.selectOne(Integer.parseInt(idx)));
		mav.setViewName("detail");
		
		return mav;
	}

}

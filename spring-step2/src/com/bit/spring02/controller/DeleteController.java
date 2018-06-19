package com.bit.spring02.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring02.model.GuestDao1;

public class DeleteController extends AbstractController {

	
	public DeleteController() {
		System.out.println("DeleteCon.. Create....");
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		ModelAndView mav = new ModelAndView("redirect:/list.bit"); 
		GuestDao1 dao = new GuestDao1();
		dao.deleteOne(Integer.parseInt(request.getParameter("idx")));		
		return mav;
	}

}

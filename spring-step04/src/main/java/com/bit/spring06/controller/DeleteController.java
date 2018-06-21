package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring06.model.GuestDao;

public class DeleteController extends AbstractController{

	@Autowired
	private GuestDao guestDao;
	
	public void setGuestDao(GuestDao guestDao) {
		this.guestDao = guestDao;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println(guestDao);
		int pk = Integer.parseInt(request.getParameter("idx"));
		if(guestDao.deleteOne(pk)>0) return new ModelAndView("redirect:/list.bit");
		else return new ModelAndView("redirect:/detail.bit?idx="+pk); 
	}

}

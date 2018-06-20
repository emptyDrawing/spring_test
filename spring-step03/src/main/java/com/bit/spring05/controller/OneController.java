package com.bit.spring05.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring05.model.GuestDao;
import com.bit.spring05.model.GuestDaoImf;
import com.bit.spring05.model.entity.GuestVo;

public class OneController extends AbstractController {

	private GuestDao dao;
	private String viewName;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView(viewName);
		int idx = Integer.parseInt(request.getParameter("idx"));
		mav.addObject("bean",dao.selectOne(idx));
		
		return mav;
	}

}

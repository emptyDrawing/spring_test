package com.bit.spring06.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.bit.spring06.model.GuestDao;

public class DeleteController extends AbstractController{

	// Autowired 순서
	// 1. 최우선순위 : 타입, 필드명 일치
	// 2. 타입이 일치하지 않고-(대신에 상속관계-super는 일치), 필드명일치
	// 3. 필드명이 일치하지 않고, 타입이 일치하는 경우 >> 대신 타입이 중복되선 안됨.
	// 4. 타입x(super는 오케잇), 필드명 x >>> 이땐 거의 안 붙음..
	
	//그리고 이놈은 기본적으로 setter를 대신하는 놈이라
	//필드 상단에 붙임.
	
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
		return new ModelAndView("redirect:/detail.bit?idx="+pk); 
	}

}

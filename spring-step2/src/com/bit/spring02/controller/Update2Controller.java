package com.bit.spring02.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import com.bit.spring02.model.GuestDao1;
import com.bit.spring02.model.entity.GuestVo;

public class Update2Controller extends AbstractCommandController{

	public Update2Controller() {
		System.out.println("Update2Con.. Create....");

	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
					throws Exception {

		ModelAndView mav = new ModelAndView();
		GuestVo bean = (GuestVo) command;
		String viewName = "redirect:/edit.bit?idx="+bean.getSabun();
		
		if(errors.hasErrors()){
			mav.addObject("bean",bean);
			mav.addObject("errMsg","입력내용을 확인해주세요.");
			mav.setViewName("edit");
		}else{
			GuestDao1 dao =  new GuestDao1();
			int result = dao.updateOne(bean);
			if(result>0)viewName = "redirect:/detail.bit?idx="+bean.getSabun();
			mav.setViewName(viewName);
		}
		return mav;
	}



}

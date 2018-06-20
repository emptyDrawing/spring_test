package com.bit.spring05.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.bit.spring05.model.GuestDao;
import com.bit.spring05.model.GuestDaoImf;
import com.bit.spring05.model.entity.GuestVo;

public class AddController extends SimpleFormController {

	private GuestDao dao;
	
	public void setDao(GuestDao dao) {
		this.dao = dao;
	}
	
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// System.out.println("handleRequest(req, resp).. run...");
		return super.handleRequest(request, response);
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("handleRequestInternal(req, resp).. run...");
		return super.handleRequestInternal(request, response);
	}

	@Override
	protected void onBind(HttpServletRequest request, Object command,
			BindException errors) throws Exception {
		//System.out.println("handleRequestInternal(request, command, errors).. run...");

		List<FieldError> errList = errors.getAllErrors();
		Map<String,String> errs = new HashMap<String, String>();
		for(int i=0; i<errList.size(); i++){
			//System.out.println("toString() >>" +errList.get(i).toString());
			//System.out.println("getDefaultMessage() >>" +errList.get(i).getDefaultMessage());
			//System.out.println("getField() >>" +errList.get(i).getField());
			errs.put(errList.get(i).getField(), errList.get(i).getDefaultMessage());
		}
		GuestVo bean = (GuestVo) command;
		if("".equals(bean.getName())){
			errs.put("name","빈문자 불가");
			errors.addError(new ObjectError("name","빈문자 불가") );
		} 
			
		request.setAttribute("errs", errs);
		
		
	}
	
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
			HttpServletResponse response, Object command, BindException errors)
			throws Exception {
		//System.out.println("onSubmit(request, response, command, BindException errors).. run...");
		return super.onSubmit(request, response, command, errors);
	}
	
	@Override
	protected void doSubmitAction(Object command) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("doSubmitAction(command).. run...");
		
		// 그래서 여기다 넣을꺼임
		dao.insertOne((GuestVo)command);
	}

}

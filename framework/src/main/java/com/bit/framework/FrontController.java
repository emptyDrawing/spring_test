package com.bit.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class FrontController extends HttpServlet{

	@Override
	public void init() throws ServletException {
		super.init();
		
		Properties prop = new Properties();
		InputStream ras = getClass().getClassLoader().getResourceAsStream("bit.properties");
		try {
			prop.load(ras);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Set<Object> keys = prop.keySet();
		Iterator<Object> ite = keys.iterator();
		while(ite.hasNext()){
			String key = (String) ite.next();
			String value = prop.getProperty(key);
			HandlerMapping.setMap(key, value);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String uri = req.getRequestURI();
		String root = req.getContextPath();
		uri = uri.substring(root.length());
		BitController controllerSel = HandlerMapping.getMap(uri);
		
		// 2. After 처리
		String path = controllerSel.execute(req);
		
		// /WEB-INF/view/ path값 .jsp
		String prefix = "/WEB-INF/view/";
		String subfix = ".jsp";
		String modRedirect = "redirect:";
		
		if(path.startsWith(modRedirect)){
			resp.sendRedirect(path.substring(modRedirect.length()));
		}else{
			req.getRequestDispatcher(prefix+path+subfix).forward(req, resp);
		}
		
	}
	
	
}// Frontcontroller

package com.bit.myapp02;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp02.model.GuestDao;
import com.bit.myapp02.model.GuestDao01Imf;
import com.bit.myapp02.model.entity.GuestVo;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	GuestDao<GuestVo> dao;
	

	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/list-ver1.bit")
	public String list(Model model) {
		
		
		try {
			model.addAttribute("alist", dao.selectAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "ver1/list";
	}
	
	@RequestMapping("/detail-ver1.bit")
	public String detail(Model model, HttpServletRequest req) {
		
		int idx =  Integer.parseInt(req.getParameter("idx"));
		
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ver1/detail";
	}
	
	@RequestMapping("/add-ver1.bit")
	public String add() {
		return "ver1/add";
	}
	
	@RequestMapping("/insert-ver1.bit")
	public String insert(HttpServletRequest req ) {
		
		GuestVo bean = new GuestVo();
		bean.setSabun(Integer.parseInt(req.getParameter("sabun")));
		bean.setName(req.getParameter("name"));
		bean.setPay(Integer.parseInt(req.getParameter("pay")));
		
		try {
			dao.insertOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "redirect:/list-ver1.bit";
	}
	
	@RequestMapping("/edit-ver1.bit")
	public String edit(Model model, HttpServletRequest req) {
		
		int idx =  Integer.parseInt(req.getParameter("idx"));
		try {
			model.addAttribute("bean", dao.selectOne(idx));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "ver1/edit";
	}
	
	@RequestMapping("/update-ver1.bit")
	public String update(int sabun, String name, int pay) {
		GuestVo bean = new GuestVo();
		bean.setSabun(sabun);
		bean.setName(name);
		bean.setPay(pay);
		int result = 0;
		try {
			result = dao.updateOne(bean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(result>0) return "redirect:/detail-ver1.bit?idx="+sabun;
		return "redirect:/edit-ver1.bit?idx="+name;
	}
	
}

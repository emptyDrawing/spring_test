package com.bit.myapp02.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bit.myapp02.model.GuestDao;
import com.bit.myapp02.model.entity.GuestVo;

// version 2
@Controller
@RequestMapping("/bbs")
public class BbsController {

	@Autowired
	GuestDao<GuestVo> guestDao;
	
	@RequestMapping("/list")
	public String list(Model model) throws SQLException {
		model.addAttribute("alist", guestDao.selectAll());
		return "ver2/list";
	}
	
	@RequestMapping("/detail")
	public String detail(int idx, Model model) throws SQLException {
		model.addAttribute("bean", guestDao.selectOne(idx));
		return "ver2/detail";
	}
	
	@RequestMapping("/add")
	public String add() {
		return "ver2/add";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(GuestVo bean) throws SQLException {
		guestDao.insertOne(bean);
		return "redirect:list";
	}
	
	@RequestMapping("/edit")
	public String detail(Model model, int idx) throws SQLException{
		model.addAttribute("bean", guestDao.selectOne(idx));
		return "ver2/edit";
	}
	
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String update(@ModelAttribute GuestVo bean) throws SQLException {
		if(guestDao.updateOne(bean)>0)return "redirect:detail?idx="+bean.getSabun();
		return "redirect:edit?idx="+bean.getSabun();
	}
	
	@RequestMapping(value="/del")
	public String del(Model model, int idx) throws SQLException{
		if(guestDao.deleteOne(idx)>0)return "redirect:list";
		return "redirect:detail?idx="+idx;
	}
	
	
}

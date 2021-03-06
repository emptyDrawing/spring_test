package com.bit.myapp06;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bit.myapp06.model.GuestDao;
import com.bit.myapp06.model.entity.GuestVo;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	SqlSession sqlSession;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}
	
	@RequestMapping("/list")
	public void list(Model model) throws SQLException {
		model.addAttribute("alist",sqlSession.getMapper(GuestDao.class).selectAll());
	}
	
	@RequestMapping("/detail")
	public void detatil(@RequestParam(value="idx") int sabun, Model model) throws SQLException{
		model.addAttribute("bean", sqlSession.getMapper(GuestDao.class).selectOne(sabun));
	}
	
	@RequestMapping("/update")
	public String update(@ModelAttribute GuestVo bean) throws SQLException{
		sqlSession.getMapper(GuestDao.class).updateOne(bean);
		return "redirect:/detail?idx="+bean.getSabun();
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.POST)
	public String delete(@RequestParam("idx") int sabun) throws SQLException{
		sqlSession.getMapper(GuestDao.class).deleteOne(sabun);
		return "redirect:/list";
	}
	
	
	
}

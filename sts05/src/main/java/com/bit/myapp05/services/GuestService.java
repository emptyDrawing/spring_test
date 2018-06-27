package com.bit.myapp05.services;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.bit.myapp05.model.GuestDao;
import com.bit.myapp05.model.entity.GuestVo;

@Service
public class GuestService {

	@Autowired
	GuestDao guestDao;
	
	public void listPage(Model model) throws SQLException {
		model.addAttribute("alist",guestDao.selectAll());
		model.addAttribute("total", guestDao.selectTotal());
	}

	public void insertPage(GuestVo bean) throws SQLException {
		guestDao.insertOne(bean);
	}
	
	public void deleteOne(int sabun) throws SQLException {
		guestDao.deleteOne(sabun);
	}
	
	public void updateOne(GuestVo bean) throws SQLException{
		guestDao.updateOne(bean);
	}
	
}

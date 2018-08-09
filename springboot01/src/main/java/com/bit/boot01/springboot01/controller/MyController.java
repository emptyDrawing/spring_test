package com.bit.boot01.springboot01.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	
	@GetMapping("/")
	public @ResponseBody String main() {
		return "Hello SpringBoot";
	}
	
	
	@RequestMapping("/obj")
	public @ResponseBody Map<String, Object> getObj(){
		
		Map<String, Object> map;
		map = new HashMap<String, Object>();
		map.put("key","벨류");
		
		return map;
	}
	
	
}

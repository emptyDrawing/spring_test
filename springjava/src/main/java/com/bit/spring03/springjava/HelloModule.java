package com.bit.spring03.springjava;

public class HelloModule implements MyInferface{

	private String msg;
	
	public HelloModule() {
		msg = "hello";
	}
	public HelloModule(String pMsg) {
		msg = pMsg;
	}
	
	public void print(){
		System.out.println(msg);
	}
	
}

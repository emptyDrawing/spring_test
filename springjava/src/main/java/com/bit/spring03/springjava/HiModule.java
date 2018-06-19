package com.bit.spring03.springjava;

public class HiModule implements MyInferface{

	private String msg;
	
	public HiModule() {
		msg = "hi";
	}
	public HiModule(String pMsg) {
		msg = pMsg;
	}
	
	public void print(){
		System.out.println(msg);
	}
	
}

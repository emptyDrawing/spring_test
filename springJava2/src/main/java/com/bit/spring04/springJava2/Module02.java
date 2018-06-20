package com.bit.spring04.springJava2;

public class Module02 implements MyModule{

	private String msg;
	
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void print(){
		System.out.println(msg);
	}

	public void func01() {
		System.out.println("기능2 실행...");
	}

	
}

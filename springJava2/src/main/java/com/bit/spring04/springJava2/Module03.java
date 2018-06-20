package com.bit.spring04.springJava2;

public class Module03 implements MyModule{

	private String msg;
	private String msg2;
	
	public Module03(){
		
	}

	public Module03(String msg, String msg2) {
		this.msg = msg;
		this.msg2 = msg2;
	}




	public void func01() {
		if(msg!=null) System.out.println(msg);
		if(msg2!=null) System.out.println(msg2);
	}

	
}

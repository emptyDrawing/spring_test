package com.bit.spring03.springjava;

public class MyModule {

	private MyInferface module;
	
	public void setModule(MyInferface moduleP) {
		this.module = moduleP;
	}
	
	public void printHelloModule(){
    	module.print();
	}
	
	
}

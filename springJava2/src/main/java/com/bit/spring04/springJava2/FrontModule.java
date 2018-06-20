package com.bit.spring04.springJava2;

public class FrontModule {
	private MyModule module;
	
	public FrontModule(MyModule module){
		this.module = module;
	}
	public void started(){
		module.func01();
	}
	
}

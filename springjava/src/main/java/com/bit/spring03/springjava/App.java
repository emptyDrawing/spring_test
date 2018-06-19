package com.bit.spring03.springjava;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
    	MyModule my = new MyModule();
//    	Class<?> clzz = Class.forName("com.bit.spring03.springjava.HiModule");
    	Class<?> clzz = Class.forName("com.bit.spring03.springjava.HelloModule");
    	MyInferface obj = (MyInferface) clzz.newInstance();
    	
    	my.setModule(obj);
    	my.printHelloModule();
    }
}

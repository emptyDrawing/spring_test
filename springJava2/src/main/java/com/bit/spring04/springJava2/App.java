package com.bit.spring04.springJava2;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	FrontModule fm = new FrontModule();
    	fm.setModule(new Module01());
    	
    	fm.started();
    
    }
}

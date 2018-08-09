package com.bit.aop01.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundMethod implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("before");
		Object obj = null;
		try {
			obj = invocation.proceed();
		}catch(Exception e) {
			// TODO 
		}
		System.out.println("after");
		return obj;
	}

}

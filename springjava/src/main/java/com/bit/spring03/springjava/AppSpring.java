package com.bit.spring03.springjava;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class AppSpring {

	public static void main(String[] args) {
		Resource resource = new ClassPathResource("applicationContext.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		MyInferface bean = (MyInferface) factory.getBean("hello");
//		MyInferface bean = (MyInferface) factory.getBean("hi");
		bean.print();
		
		
	}

}

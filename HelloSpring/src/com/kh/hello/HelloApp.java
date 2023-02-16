package com.kh.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloApp {
	
	public static void main(String[] args) {
		
		// 이전 방식
		// MessageBean bean = new MessageBeanEng();
		// bean.sayHello("Spring");
		
		// 새로운 방식
		String resource = "spring-context.xml";
		ApplicationContext ctx = new GenericXmlApplicationContext(resource);
		MessageBean bean = (MessageBeanEng)ctx.getBean("messageBean");	// Object -> MessageBeanEng
		bean.sayHello("Spring");
	}
}

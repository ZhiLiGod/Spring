package com.zhi.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.zhi.spring.pojo.Cycle;
import com.zhi.spring.pojo.Shape;
import com.zhi.spring.pojo.Triangle;

public class DrawingApp1 {
	
	
	
	public static void main(String[] args) {
		//Triangle t = new Triangle();
		
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.registerShutdownHook();
		Shape t = (Shape) context.getBean("newShape");
		t.draw();
		
//		System.out.println(context.getMessage("greeting", null
//				, "Default Greeting", null));
		
	}
}

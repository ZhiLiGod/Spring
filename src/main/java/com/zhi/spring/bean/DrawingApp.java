package com.zhi.spring.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import com.zhi.spring.pojo.Triangle;

public class DrawingApp {
	
	
	
	public static void main(String[] args) {
		//Triangle t = new Triangle();
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Triangle t = (Triangle) context.getBean("triangle");
		t.draw();
		System.out.println(t.getType());
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Triangle t1 = (Triangle)ctx.getBean("triangleWithPoint");
		t1.drawPoint();
		Triangle t2 = (Triangle)ctx.getBean("triangleWithList");
		t2.drawPoints();
		
		Triangle t3 = (Triangle)ctx.getBean("triangleWithList");
		t3.drawPoints();
		
		AbstractApplicationContext actx = new ClassPathXmlApplicationContext("applicationContext.xml");
		actx.registerShutdownHook();
		Triangle t4 = (Triangle)actx.getBean("triangleWithList");
		t4.drawPoints();
		
		
	}
}

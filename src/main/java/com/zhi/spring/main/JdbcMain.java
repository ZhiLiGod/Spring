package com.zhi.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zhi.spring.dao.JdbcDaoImpl;
import com.zhi.spring.pojo.NewCircle;

public class JdbcMain {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("springJdbc.xml");
		JdbcDaoImpl dao = ctx.getBean("jdbcDaoImpl", JdbcDaoImpl.class);
		NewCircle circle = dao.getCircle(1);
		System.out.println(circle.getName());
		System.out.println(dao.getCircleCount());
	}
}

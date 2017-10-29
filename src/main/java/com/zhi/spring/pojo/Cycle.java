package com.zhi.spring.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Required;

public class Cycle implements Shape {
	
	private Point point;
	
	
	public Point getPoint() {
		return point;
	}

	@Required
	@Resource(name="twoPoint")
	public void setPoint(Point point) {
		this.point = point;
	}
	
	@PostConstruct
	public void myInit(){
		System.out.println("init in circle");
	}
	
	@PreDestroy
	public void myDestroy(){
		System.out.println("destroy in circle");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Cycle is: " + point);
	}

}

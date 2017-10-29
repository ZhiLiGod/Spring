package com.zhi.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Square implements Shape {
	
	private Point center;
	
	
	public Point getCenter() {
		return center;
	}

	@Autowired
	@Qualifier("circleRelated")//declare bean name if there's multiple bean with same type
	public void setCenter(Point center) {
		this.center = center;
	}


	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Point is: " + center);
		
	}

}

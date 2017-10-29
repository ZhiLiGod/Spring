package com.zhi.spring.service;

import com.zhi.spring.logging.Loggable;
import com.zhi.spring.pojo.Circle;
import com.zhi.spring.pojo.NewTriangle;

public class ShapeService {
	private Circle circle;
	private NewTriangle triangle;
	@Loggable
	public Circle getCircle() {
		System.out.println("Get Circle");
		return circle;
	}
	public void setCircle(Circle circle) {
		this.circle = circle;
	}
	public NewTriangle getTriangle() {
		return triangle;
	}
	public void setTriangle(NewTriangle triangle) {
		this.triangle = triangle;
	}
	
}

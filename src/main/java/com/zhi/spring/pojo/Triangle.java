package com.zhi.spring.pojo;

import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Triangle implements ApplicationContextAware, BeanNameAware {
	private String type;
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext ctx = null;
	private List<Point> points;
	
	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}

	public Triangle(){}
	
	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public Triangle(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public void draw(){
		System.out.println("Triangle drawn");
	}
	
	public void drawPoint(){
		System.out.println("" + pointA.getX() + " " + pointB.getX());
	}
	
	public void drawPoints(){
		System.out.println(points);
	}

	@Override
	public void setApplicationContext(ApplicationContext ctx)
			throws BeansException {
		this.ctx = ctx;
		
	}

	@Override
	public void setBeanName(String beanName) {
		// TODO Auto-generated method stub
		System.out.println("Bean name: " + beanName);
	}
	
	public void myInit(){
		System.out.println("My Initialize");
		System.out.println("hahaha");
	}
	
	public void cleanUp(){
		System.out.println("Bean is desroied");
	}
}

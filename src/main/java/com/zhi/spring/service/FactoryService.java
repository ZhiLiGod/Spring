package com.zhi.spring.service;

import com.zhi.spring.pojo.Circle;
import com.zhi.spring.pojo.NewTriangle;

public class FactoryService {
	public Object getBean(String beanType){
		if(beanType.equalsIgnoreCase("shapeService"))
			return new ShapeServiceProxy();
		if(beanType.equalsIgnoreCase("circle"))
			return new Circle();
		if(beanType.equalsIgnoreCase("triangle"))
			return new NewTriangle();
		return null;
	}
}

package com.zhi.spring.main;

import com.zhi.spring.service.FactoryService;
import com.zhi.spring.service.ShapeService;

public class AopMain1 {
	public static void main(String[] args) {
		FactoryService fs = new FactoryService();
		ShapeService shapeService = (ShapeService)fs.getBean("shapeService");
		
		shapeService.getCircle();
	}
}

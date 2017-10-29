package com.zhi.spring.service;

import com.zhi.spring.logging.LoggingAspect;
import com.zhi.spring.pojo.Circle;

public class ShapeServiceProxy extends ShapeService {
	
	public Circle getCircle(){
		new LoggingAspect().loggingAdviceforFactory();
		return super.getCircle();
	}
}

package com.zhi.spring.pojo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import com.zhi.spring.bean.DrawEvent;

@Component
public class newShape implements Shape, ApplicationEventPublisherAware {
	
	private Point point;
	@Autowired
	private MessageSource messageSource;
	private ApplicationEventPublisher publisher;
	public MessageSource getMs() {
		return messageSource;
	}

	public void setMs(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public Point getPoint() {
		return point;
	}
	
	@Resource(name="twoPoint")
	public void setPoint(Point point) {
		this.point = point;
	}

	@PostConstruct
	public void myInit(){
		System.out.println("哈哈哈");
	}
	
	@PreDestroy
	public void myDestroy(){
		System.out.println("你好");
	}
	
	@Override
	public void draw() {
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		// TODO Auto-generated method stub
		System.out.println(this.messageSource.getMessage("drawing.circle", null
				, "Default drawing.circle", null));
		System.out.println(this.messageSource.getMessage("greeting", null
				, "Default Greeting", null));
		System.out.println(this.messageSource.getMessage("drawing.point", new Object[] {point}
				, "Default Greeting", null));
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		// TODO Auto-generated method stub
		this.publisher = publisher;
	}


}

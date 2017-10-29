package com.zhi.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DisplayNameBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessAfterInitialization(Object obj, String str)
			throws BeansException {
		System.out.println("In After Initialization method, the bean name is:"+
				str);
		return obj;
	}

	@Override
	public Object postProcessBeforeInitialization(Object obj, String str)
			throws BeansException {
		System.out.println("In Before Initialization method, the bean name is:"+
			str);
		return obj;
	}
	
}

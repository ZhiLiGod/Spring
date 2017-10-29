package com.zhi.spring.logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.zhi.spring.pojo.Circle;

@Aspect
public class LoggingAspect {
	//..0 or more arguments
	//execution: point cut
	//args(name)
	//before: 在切点方法之前执行
	//after: 在切点方法之后执行
	//afterreturning: 如果正常执行就执行 有异常就不执行
	//afterThrowing: 抛出异常后执行
	//可以在方法中使用传入的值和返回的值或者异常
	//@AfterReturning(pointcut="args(name)", returning="returningValue")
	//@AfterThrowing(pointcut="args(name)", throwing="ex")
	@AfterReturning("allGetters() && allCircleMethods()")
	public void loggingAdvice(){
		System.out.println("Advice run. Get Method called");
	}
	
	@Before("allGetters()")
	public void secondAdvice(JoinPoint joinPoint){
		String methodName = joinPoint.toString();
		//Circle c = (Circle)joinPoint.getTarget();
		System.out.println("Second Advice executed " + methodName);
	}
	
	//execute before and after target
	@Around("allGetters()")
	public void myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
		
		//方法执行前
		
		try {
			System.out.println("Before advice");
			proceedingJoinPoint.proceed();
			System.out.println("After returning");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("After Throwing");
			e.printStackTrace();
		}//execute method that around 
		
		//方法执行后
		System.out.println("After finally");
	}
	
	@Pointcut("execution(* get*(..))")
	public void allGetters(){}
	
	//publin/protected/private
	//return value
	//method name
	//arguments
	//@Pointcut("execution(* * com.zhi.spring.pojo.Circle.*(..))")
	@Pointcut("within(com.zhi.spring.pojo.Circle)")//all methods in circle class
	public void allCircleMethods(){}
	
	//@Pointcut("execution(* com.zhi.spring.service.*Service.*(..))")
	
	//自定义annotation 在需要的地方直接加入注解
	@Around("@annotation(com.zhi.spring.logging.Loggable)")
	public void customAnnotation() throws Exception{
		System.out.println("Custom Annotation");
	}
	
	public void loggingAdviceforFactory(){
		System.out.println("Logging Advice");
	}
}

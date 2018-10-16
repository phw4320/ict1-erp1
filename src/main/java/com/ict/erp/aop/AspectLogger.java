package com.ict.erp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class AspectLogger {
	private static final Logger Logger = LoggerFactory.getLogger(AspectLogger.class);
	private long sTime;
	
	@Before("execution(* com.ict.erp.controller.*.*(..))")
	public void beforeLog(JoinPoint jp) {
		Logger.debug("jp=>{}",jp);
		sTime = System.currentTimeMillis();
	}
	
	@Around("execution(* com.ict.erp.controller.*.*(..))")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		String sigName = pjp.getSignature().getName();
		String targetName = pjp.getTarget().toString();
		Object[] params = pjp.getArgs();
		Logger.debug("{}.{}({})", new Object[] {targetName, sigName, params});
		Object obj = pjp.proceed();
		Logger.debug("result => {}", obj);
		return obj;
	}
	
	@After("execution(* com.ict.erp.controller.*.*(..))")
	public void afterLog(JoinPoint jp) {
		Logger.debug("end=>{}",jp);
		Logger.debug("execution time =>{}ms", (System.currentTimeMillis()) - sTime);
	}
}

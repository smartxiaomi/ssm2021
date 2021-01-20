package com.ssmbook2020.utils;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/** 需要织入的日志切面类 */
@Aspect
public class LoggerAdvice {
	// log4j日志类
	Logger logger = Logger.getLogger(LoggerAdvice.class);

	// 后置增强
	@AfterReturning(pointcut = "execution(* com.ssmbook2020..*.*(..))", returning = "ret")
	public void afterReturning(JoinPoint join, Object ret) {
		String method = join.getSignature().getName();
		Object[] args = join.getArgs();
		if ("login".equals(method)) {
			if (ret != null) {
				logger.info(new Timestamp(System.currentTimeMillis()) + " " + args[0] + "登录成功");
			} else {
				logger.info(new Timestamp(System.currentTimeMillis()) + " " + args[0] + "登录失败");
			}
		}
	}

	// 前置增强
	@Before(value = "execution(* com.ssmbook2020..*.*(..))")
	public void methodBefore(JoinPoint join) {
		String method = join.getSignature().getName();
		Object[] args = join.getArgs();
		if ("login".equals(method)) {
			logger.info(new Timestamp(System.currentTimeMillis()) + " " + args[0] + "开始登录");
		}
	}
}

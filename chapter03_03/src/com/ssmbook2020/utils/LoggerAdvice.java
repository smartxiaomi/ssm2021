package com.ssmbook2020.utils;

import java.sql.Timestamp;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/** ��Ҫ֯�����־������ */
@Aspect
public class LoggerAdvice {
	// log4j��־��
	Logger logger = Logger.getLogger(LoggerAdvice.class);

	// ������ǿ
	@AfterReturning(pointcut = "execution(* com.ssmbook2020..*.*(..))", returning = "ret")
	public void afterReturning(JoinPoint join, Object ret) {
		String method = join.getSignature().getName();
		Object[] args = join.getArgs();
		if ("login".equals(method)) {
			if (ret != null) {
				logger.info(new Timestamp(System.currentTimeMillis()) + " " + args[0] + "��¼�ɹ�");
			} else {
				logger.info(new Timestamp(System.currentTimeMillis()) + " " + args[0] + "��¼ʧ��");
			}
		}
	}

	// ǰ����ǿ
	@Before(value = "execution(* com.ssmbook2020..*.*(..))")
	public void methodBefore(JoinPoint join) {
		String method = join.getSignature().getName();
		Object[] args = join.getArgs();
		if ("login".equals(method)) {
			logger.info(new Timestamp(System.currentTimeMillis()) + " " + args[0] + "��ʼ��¼");
		}
	}
}

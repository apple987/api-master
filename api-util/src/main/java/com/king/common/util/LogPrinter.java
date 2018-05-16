package com.king.common.util;


import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

/**
 * 日志打印
 * 
 * @author 傅为地
 */
@Component
@Aspect
public class LogPrinter {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private String userName = null; // 用户名
	private Object inputParamMap = new Object(); // 传入参数
	private String className = null;// 执行类名
	private String methodName = null;// 执行方法名称
	private String functionName = "";// function注解描述的方法名称
	@Autowired
	TaskExecutor taskExecutor;
	/*@Resource(name="logService")
	LogService logService;*/
	
	/* 切入日志打印 */
	@Pointcut("execution(public * com.king.web.controller..*.*(..)) && @annotation(com.king.common.util.Function)")
	public void printLog() {
	}

	/* 日志打印 方法执行(前/后) */
	@Around("printLog()")
	public Object doAround(ProceedingJoinPoint pjp) throws Throwable {

		className = pjp.getTarget().getClass().getName();
		className = className.substring(className.lastIndexOf(".") + 1);
		methodName = pjp.getSignature().getName();
		/*SysUsers user = (SysUsers) SessionUtil.getSessionObject(Constant.CURRENT_USER);
		if (user != null && user.getLoginid() != null && !"".equals(user.getLoginid())) {
			userName = user.getLoginid();
		} else {
			userName = "未登录";
		}*/
		Object[] args = pjp.getArgs();
		Method method = ((org.aspectj.lang.reflect.MethodSignature) pjp.getSignature()).getMethod();
		Class<?>[] paremClassTypes = method.getParameterTypes();
		//自身类.class.isAssignableFrom(自身类或子类.class)  返回true 
		for (int i = 0; i < args.length; i++) {
			if (Map.class.isAssignableFrom(paremClassTypes[i])) {// 打印map
				inputParamMap = args[i];
			}
			if (MutiSort.class.isAssignableFrom(paremClassTypes[i])) {//MutiSort本类或者子类
				inputParamMap = args[i];
			}
		}
		Function f = method.getAnnotation(Function.class);
		functionName = f == null ? "" : f.value();
		
		logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S").format(new Date())+" 用户:" + userName + " [" + functionName + "] 开始:" + className + "." + methodName + "() 参数:"+ JSON.toJSONStringWithDateFormat(inputParamMap, "yyyy-MM-dd HH:mm:ss"));
		// 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
		Object result = pjp.proceed();// result的值就是被拦截方法的返回值
		if (result == null) {
			logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S").format(new Date())+" 用户:" + userName + " [" + functionName + "] 结束:" + className + "." + methodName + "() 返回:{}");
		} else {
			if (result instanceof String) {
				logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S").format(new Date())+" 用户:" + userName + " [" + functionName + "] 结束:" + className + "." + methodName + "() 返回:"
						+ result);
			} else {
				logger.info(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,S").format(new Date())+" 用户:" + userName + " [" + functionName + "] 结束:" + className + "." + methodName + "() 返回:"+ JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss"));
						
			}
		}
		//数据库记录日志
		/*final LogInfo acl=new LogInfo();
		acl.setActionType("0");
		acl.setActionStatus("1");
		acl.setActionServletPath(SessionUtil.getRequest().getRequestURI());//访问路径
		acl.setActionFunctionName(functionName); //访问方法.
		acl.setActionDescription(SessionUtil.getRequest().getRequestURI()); //模块名称.
		acl.setActionUserId(userName);
		acl.setActionAccessIp(SessionUtil.getRequest().getRemoteHost());
		acl.setActionErrorInfo("");
		String actionAccessContent = "";
		if(inputParamMap!=null &&!inputParamMap.equals("")){
			if(inputParamMap instanceof String){
				actionAccessContent=CoreUtil.getNotNullStr(inputParamMap);
			}else{
				actionAccessContent=JSON.toJSONString(inputParamMap);
			}
		}
		acl.setActionContent(actionAccessContent);*/
		/*日志写入数据库*/
		FutureTask<Object> task = new FutureTask<Object>(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				try {
					/*if(!CoreUtil.isEmpty(acl.getActionContent()) ){
						logger.info("开始 数据库记录日志 starting.................................................");
//						logService.insert(acl);
						logger.info("结束 数据库记录日志 ending.................................................");
					}*/
				} catch (Throwable e) {
					logger.error("记录失败", e);
				}
				return "ok";
			}
		});
		taskExecutor.execute(task);	//为提升访问速率, 日志记录采用异步的方式进行.
		return result;
	}

}

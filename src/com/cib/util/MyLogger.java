package com.cib.util;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @className MyLogger
 * @function 日志器
 * @version 1.0
 * @author zhaoxiaofeng
 */
public class MyLogger 
{
	private static Logger logger = Logger.getLogger(MyLogger.class.getName());
	public static MyLogger myLogger = null;
	GetSysTime getSysTime = null;
	
	private MyLogger()
	{
		//获取系统当前时间
		getSysTime = new GetSysTime();
	}
	
	/**
	 * @methodName getDeFaultInstance
	 * @function 获取属性文件名
	 * @return MyLogger
	 */
	public static MyLogger getDeFaultInstance()
	{
		PropertyConfigurator.configure("属性文件名");
		myLogger = new MyLogger();
		return myLogger;
	}
	
	/**
	 * @methodName myError
	 * @function 获取错误信息
	 * @return void
	 */
	public void myError(String err)
	{
		logger.error(getSysTime.getSysTime()+"==="+err);
	}
	
	/**
	 * @methodName getPara
	 * @function 获取警告信息
	 * @return void
	 */
	public void myWarn(String warn)
	{
		logger.error(getSysTime.getSysTime()+"==="+warn);
	}
	
	/**
	 * @methodName getPara
	 * @function 获取信息
	 * @return void
	 */
	public void myInfo(String info)
	{
		logger.error(getSysTime.getSysTime()+"==="+info);
	}
}

package com.cib.util;


import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * @className MyLogger
 * @function ��־��
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
		//��ȡϵͳ��ǰʱ��
		getSysTime = new GetSysTime();
	}
	
	/**
	 * @methodName getDeFaultInstance
	 * @function ��ȡ�����ļ���
	 * @return MyLogger
	 */
	public static MyLogger getDeFaultInstance()
	{
		PropertyConfigurator.configure("�����ļ���");
		myLogger = new MyLogger();
		return myLogger;
	}
	
	/**
	 * @methodName myError
	 * @function ��ȡ������Ϣ
	 * @return void
	 */
	public void myError(String err)
	{
		logger.error(getSysTime.getSysTime()+"==="+err);
	}
	
	/**
	 * @methodName getPara
	 * @function ��ȡ������Ϣ
	 * @return void
	 */
	public void myWarn(String warn)
	{
		logger.error(getSysTime.getSysTime()+"==="+warn);
	}
	
	/**
	 * @methodName getPara
	 * @function ��ȡ��Ϣ
	 * @return void
	 */
	public void myInfo(String info)
	{
		logger.error(getSysTime.getSysTime()+"==="+info);
	}
}

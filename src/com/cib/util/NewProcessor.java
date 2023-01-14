package com.cib.util;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.RequestProcessor;

/**
 * @className NewProcessor
 * @function 处理乱码
 * @version 1.0
 * @author zhaoxiaofeng
 */
public class NewProcessor extends RequestProcessor
{
	/**
	 * @methodName processPreprocess
	 * @function 处理格式转换
	 * @return boolean
	 * @exception UnsupportedEncodingException
	 */
	protected boolean processPreprocess(HttpServletRequest arg0,
			HttpServletResponse arg1) 
	{
		try 
		{
			arg0.setCharacterEncoding("GBK");
		} catch (UnsupportedEncodingException e) 
		{
			e.printStackTrace();
		}
		return super.processPreprocess(arg0, arg1);
	}
}

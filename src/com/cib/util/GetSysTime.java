package com.cib.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * @className GetSysTime
 * @function 获取系统当前时间,系统日期,获得一个月前日期字符串，当前日期指定前后几天的字符串
 * @version 1.0
 * @author zxf
 */
public class GetSysTime 
{
	String nowTime = null;
	String nowDate = null;
	public static Logger logger = Logger.getLogger(GetSysTime.class.getName());
	
	public GetSysTime(){}
	
	/**
	 * @method getSysTime
	 * @function 获取系统当前时间
	 * @return String
	 */
	public String getSysTime()
	{
		java.util.Date date = new java.util.Date();
		nowTime = DateFormat.getTimeInstance().format(date);
		if (nowTime.length() == 7)
		{
			nowTime = '0'+nowTime;
		}
		return nowTime;
	}
	
	/**
	 * @method getSysDate
	 * @function 获取系统当前日期
	 * @return String
	 */
	public String getSysDate()
	{
		java.util.Date date = new java.util.Date();
		nowDate = DateFormat.getDateInstance().format(date);
		return nowDate;
	}
	
	/**
	 * 根据格式获得一个月前日期字符串.
	 * 
	 * @param format	日期格式	如yyyyMMdd, HHmmSS
	 * @return	符合日期格式的当前日期。
	 */
	public static String getLastMonthTodayStrByFormat(String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		return sdf.format(calendar.getTime());
	}
	/**
	 * 根据格式获得当前日期指定前后几天的字符串.
	 * 
	 * @param format	日期格式	如yyyyMMdd, HHmmSS
	 * @param count		指定前后几天，负数表示前几天，正数表示后几天
	 * @return	符合日期格式的当前日期。
	 */
	public static String getSpecifiedDayStrByFormat(String format, int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);	
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
	}
	
	/**
	 * 根据格式获得当前日期字符串.
	 * 
	 * @param format	日期格式	如yyyyMMdd, HHmmSS
	 * @return	符合日期格式的当前日期。
	 */
	public  String getTodayStrByFormat(String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
}

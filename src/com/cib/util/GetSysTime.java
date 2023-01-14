package com.cib.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

/**
 * @className GetSysTime
 * @function ��ȡϵͳ��ǰʱ��,ϵͳ����,���һ����ǰ�����ַ�������ǰ����ָ��ǰ������ַ���
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
	 * @function ��ȡϵͳ��ǰʱ��
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
	 * @function ��ȡϵͳ��ǰ����
	 * @return String
	 */
	public String getSysDate()
	{
		java.util.Date date = new java.util.Date();
		nowDate = DateFormat.getDateInstance().format(date);
		return nowDate;
	}
	
	/**
	 * ���ݸ�ʽ���һ����ǰ�����ַ���.
	 * 
	 * @param format	���ڸ�ʽ	��yyyyMMdd, HHmmSS
	 * @return	�������ڸ�ʽ�ĵ�ǰ���ڡ�
	 */
	public static String getLastMonthTodayStrByFormat(String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(new Date());
		calendar.add(Calendar.MONTH, -1);
		return sdf.format(calendar.getTime());
	}
	/**
	 * ���ݸ�ʽ��õ�ǰ����ָ��ǰ������ַ���.
	 * 
	 * @param format	���ڸ�ʽ	��yyyyMMdd, HHmmSS
	 * @param count		ָ��ǰ���죬������ʾǰ���죬������ʾ����
	 * @return	�������ڸ�ʽ�ĵ�ǰ���ڡ�
	 */
	public static String getSpecifiedDayStrByFormat(String format, int count) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, count);	
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(cal.getTime());
	}
	
	/**
	 * ���ݸ�ʽ��õ�ǰ�����ַ���.
	 * 
	 * @param format	���ڸ�ʽ	��yyyyMMdd, HHmmSS
	 * @return	�������ڸ�ʽ�ĵ�ǰ���ڡ�
	 */
	public  String getTodayStrByFormat(String format) {
		SimpleDateFormat sdf=new SimpleDateFormat(format);
		return sdf.format(new Date());
	}
}

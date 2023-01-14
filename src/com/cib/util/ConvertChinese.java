package com.cib.util;

/**
 * @className ConvertChinese
 * @function 格式转换（ISO－8859－1和gb2312格式转换）
 * @version 1.0
 * @author zxf
 */
public class ConvertChinese
{
	public ConvertChinese(){}
	
	/**
	 * @methodName toChinese
	 * @function 把字符串转换为gb2312格式
	 * @param strValue
	 * @return String
	 */
	public static String toChinese(String strValue)
	{
		try
		{
			if (strValue == null || strValue.equals(""))
			{
				return "";
			}
			else
			{
				strValue = new String(strValue.getBytes("ISO-8859-1"),"gb2312").trim();
				return strValue;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return "";
	}
	
	/**
	 * @methodName toChinese
	 * @function 把字符串转换为ISO-8859-1格式
	 * @param strValue
	 * @return String
	 */
	public static String toUnicode(String strValue)
	{
		try
		{
			if (strValue == null || strValue.equals(""))
			{
				return "";
			}
			else
			{
				strValue = new String(strValue.getBytes("gb2312"),"ISO-8859-1").trim();
				return strValue;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		return "";
	}
}

package com.cib.util;

/**
 * @className ConvertChinese
 * @function ��ʽת����ISO��8859��1��gb2312��ʽת����
 * @version 1.0
 * @author zxf
 */
public class ConvertChinese
{
	public ConvertChinese(){}
	
	/**
	 * @methodName toChinese
	 * @function ���ַ���ת��Ϊgb2312��ʽ
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
	 * @function ���ַ���ת��ΪISO-8859-1��ʽ
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

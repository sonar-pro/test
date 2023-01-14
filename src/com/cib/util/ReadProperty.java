package com.cib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @className ReadProperty
 * @function 读属性文件
 * @version 1.0
 * @author 赵晓峰
 */
public class ReadProperty 
{
	
	private FileInputStream fis = null;
	private static final String fileName = "D:\\properties\\system.properties";
	
	//构造方法
	public ReadProperty(){}
	
	/**
	 * @methodName getPara
	 * @function 获取属性参数
	 * @return Properties
	 * @exception IOException
	 */
	public Properties getPara()
	{
		Properties prop = new Properties();
		File file = new File(fileName);
		try
		{
			fis = new FileInputStream(file);
			prop.load(fis);
			if (fis != null)
			{
				fis.close();
			}
		} catch (IOException ex)
		{
			ex.printStackTrace();
		}
		return prop;
	}
	
	//测试
	public static void main(String [] args)
	{
		ReadProperty rp = new ReadProperty();
		Properties prop = rp.getPara();
		String host = prop.getProperty("sagentDBName");
		System.out.println(host);
		String oracle = prop.getProperty("sagentDBPsw");
		System.out.println(oracle);
	}
}

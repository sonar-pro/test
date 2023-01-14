package com.cib.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @className ReadProperty
 * @function �������ļ�
 * @version 1.0
 * @author ������
 */
public class ReadProperty 
{
	
	private FileInputStream fis = null;
	private static final String fileName = "D:\\properties\\system.properties";
	
	//���췽��
	public ReadProperty(){}
	
	/**
	 * @methodName getPara
	 * @function ��ȡ���Բ���
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
	
	//����
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

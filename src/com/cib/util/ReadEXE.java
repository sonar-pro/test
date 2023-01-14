package com.cib.util;


import java.util.Properties;

public class ReadEXE 
{
	private static final String PATH = "D:\\exe\\ipmsg.exe";
	
	public static void main(String [] args)
	{
		Process process = null;
		ReadProperty readProperty = null;
		Runtime rt = Runtime.getRuntime();
		/*String PATHEXE = "sarun "cib-select2" "sa::SQLSERVER:ccc-test1:sagent_repository:sa:group1" -w";
		out = new FileOutputStream(localPath +"" + uploadFileName);*/
		try
		{
			readProperty = new ReadProperty();
			Properties prop = readProperty.getPara();
			String host = prop.getProperty("sagentDBName");
			System.out.println(host);
			String oracle = prop.getProperty("sagentDBPsw");
			System.out.println(oracle);
//			String PATHEXE = "PATH+''+";
			process = rt.exec(PATH);
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}
}

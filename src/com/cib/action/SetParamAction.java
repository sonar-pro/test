package com.cib.action;
import java.io.*;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.Action;

/**
 * @className SetParamAction
 * @function 把系统配置参数写入属性文件
 * @version 1.0
 * @author wqs
 */
public class SetParamAction implements Action
{
	private File file = null;
	private static final String path = "D:\\properties\\system.properties";
	
	/**
	 * @methodName writeProperties
	 * @function 获取属性参数,写入属性文件中
	 * @return String
	 * @exception IOException
	 */
	public String writeProperties() throws Exception
	{
		FileWriter fw = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			file = new File(path);
			if (file.isDirectory())
			{
				file.mkdirs();
			}
			if (!file.isFile())
			{
				file.createNewFile();
			}
			fw = new FileWriter(file);
			fw.write("oracle服务器配置参数"+"\r\n");
			fw.write("\r\n");
			fw.write("oracleServerAddress:"+request.getParameter("oracleServerAddress")+"\r\n");
			fw.write("oracleUserName:"+request.getParameter("oracleUserName")+"\r\n");
			fw.write("oracleUserPws:"+request.getParameter("oracleUserPws")+"\r\n");
			fw.write("oracleName:"+request.getParameter("oracleName")+"\r\n");
			fw.write("\r\n");
			fw.write("账单存储服务器配置参数"+"\r\n");
			fw.write("\r\n");
			fw.write("stroageServerAddress:"+request.getParameter("stroageServerAddress")+"\r\n");
			fw.write("billStroageName:"+request.getParameter("billStroageName")+"\r\n");
			fw.write("billStroagePws:"+request.getParameter("billStroagePws")+"\r\n");
			fw.write("billStroageDB:"+request.getParameter("billStroageDB")+"\r\n");
			fw.write("\r\n");
			fw.write("sagent服务器配置参数"+"\r\n");
			fw.write("\r\n");
			fw.write("sagentServerName:"+request.getParameter("sagentServerAddress")+"\r\n");
			fw.write("sagentName:"+request.getParameter("sagentName")+"\r\n");
			fw.write("sagentPws:"+request.getParameter("sagentPws")+"\r\n");
			fw.write("sagentDBName:"+request.getParameter("sagentDB")+"\r\n");
			fw.write("sagentDBPsw:"+request.getParameter("sagentDBPsw")+"\r\n");
			fw.write("\r\n");
			fw.write("EA/EN服务器配置参数"+"\r\n");
			fw.write("\r\n");
			fw.write("enServerAddress:"+request.getParameter("enServerAddress")+"\r\n");
			fw.write("enUserName:"+request.getParameter("enUserName")+"\r\n");
			fw.write("enUserPws:"+request.getParameter("enUserPws")+"\r\n");
			fw.write("enDB:"+request.getParameter("enDB")+"\r\n");
			fw.write("\r\n");
			fw.write("密钥服务器配置参数"+"\r\n");
			fw.write("\r\n");
			fw.write("des:"+request.getParameter("des")+"\r\n");
			
			fw.flush();
			fw.close();
		} catch (IOException io)
		{
			io.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @methodName ReadProperties
	 * @function 从属性文件中读取参数
	 * @return Properties
	 * @exception IOException
	 */
	public Properties ReadProperties() throws Exception
	{
		FileInputStream fis = null;
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		file = new File(path);
		Properties prop = new Properties();
		try
		{
			fis = new FileInputStream(file);
			prop.load(fis);
			session.setAttribute("oracleServerAddress", prop.getProperty("oracleServerAddress"));
			session.setAttribute("oracleUserName", prop.getProperty("oracleUserName"));
			session.setAttribute("oracleUserPws", prop.getProperty("oracleUserPws"));
			session.setAttribute("oracleName", prop.getProperty("oracleName"));
			session.setAttribute("billStroageName", prop.getProperty("billStroageName"));
			session.setAttribute("billStroagePws", prop.getProperty("billStroagePws"));
			session.setAttribute("billStroageDB", prop.getProperty("billStroageDB"));
			session.setAttribute("sagentName", prop.getProperty("sagentName"));
			session.setAttribute("sagentPws", prop.getProperty("sagentPws"));
			session.setAttribute("sagentDB", prop.getProperty("sagentDB"));
			session.setAttribute("enServerAddress", prop.getProperty("enServerAddress"));
			session.setAttribute("enUserName", prop.getProperty("enUserName"));
			session.setAttribute("enUserPws", prop.getProperty("enUserPws"));
			session.setAttribute("enDB", prop.getProperty("enDB"));
			session.setAttribute("des", prop.getProperty("des"));
		
			fis.close();
		} catch (IOException io)
		{
			io.printStackTrace();
		}
		return prop;
	}
	
	public String execute() throws Exception 
	{
		return null;
	}
}

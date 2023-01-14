package com.cib.constant;


/**
 * @className Constant
 * @function 常量管理类
 * @author zxf
 * @version 1.0
 */
public class Constant 
{
	public static String ip="192.168.5.108";//
	public static int port=9766;
	
//	public static String driver="com.mysql.jdbc.Driver";
//	public static String url="jdbc:mysql://127.0.0.1:3306/accountant?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true";
//	public static String name = "root";
//	public static String password = "123456";
////	public static String password = "";
//	public static String USER_KEY = "USER_KEY";
	
	public static String driver="com.microsoft.jdbc.sqlserver.SQLServerDriver";
	public static String url="jdbc:microsoft:sqlserver://123.138.22.72:1433;DatabaseName=boruiweb";
	public static String name = "sa";
	public static String password = "sasazyX";
//	public static String password = "";

	public final static String PROP_ITEM_MAX_LENGTH= "\\$\\{propItemMaxLength\\}"; 
	public static final String USER_KEY = "LOGON";
	public static final String USER_MAP = "USER_MAP";
	public static final String ONLINE_USER = "ONLINE_USER";
	public static final String ONLINE_USERNAME = "ONLINE_USERNAME";
	public static final String ONLINE_USER_RDDR = "ONLINE_USER_RDDR";
	public static final String QUICK_MENU = "QUICK_MENU";
	public static final String ADMIN_MAP = "ADMIN_MAP";
	public static final String PRIMARY_KEY_ALL = "PRIMARY_KEY_ALL";
	public static final String PRIMARY_KEY_USER = "PRIMARY_KEY_USER";
	public static final String PRIMARY_KEY_BUTTON = "PRIMARY_KEY_BUTTON";
	public static final String PRIMARY_KEY_DOMAIN = "PRIMARY_KEY_DOMAIN";
	public static final String ENTITY_PATH = "com.cib.entity.";// 实体路径
}

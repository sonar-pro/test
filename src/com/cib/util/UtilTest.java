package com.cib.util;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.sql.DataSource;

public class UtilTest {

	public UtilTest() {

	}

	public void aaa(Integer b) {
		System.out.println(b);
	}

	public static final String pageInfo = "package com.cib.model;";

	public static String methodInfo = null;
	static {
		methodInfo = new StringBuffer().append("    /** \r\n").append("    * @return the aaa \r\n").append("    */ \r\n").append("    public String getAaa() { \r\n").append("    	return aaa; \r\n")
				.append("    } \r\n").append("    \r\n")

				.append("    /** \r\n").append("    * @param aaa the aaa to set \r\n").append("    */ \r\n").append("    public void setAaa(String aaa) { \r\n").append("    	this.aaa = aaa; \r\n")
				.append("    } \r\n \r\n").append("    \r\n").toString();
	}

	public static void main(String args[]) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
		try {
			List<String> list = new ArrayList<String>();
			Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:microsoft:sqlserver://123.138.22.72:1433;DatabaseName=boruiweb", "sa", "sasazyX");
			PreparedStatement ps = con.prepareStatement("select name from sysobjects where (xtype = 'U') AND (status & 0xC0000000 <> 0xC0000000)");
			ResultSet rs2 = ps.executeQuery();
			//System.out.println("rs2="+rs2.next());
			while (rs2.next()) {
				list.add(rs2.getString("NAME"));
			}
			rs2.close();

			ps = con.prepareStatement("SELECT NAME COLNAME, TYPE_NAME(XUSERTYPE) TPNAME, LENGTH, PREC, ISNULLABLE ,CDEFAULT FROM SYSCOLUMNS WHERE ID = OBJECT_ID(?)");

			//String filePath = "D:\\java\\";
			String filePath = "D:\\Program Files\\Genuitec\\java";
			PrintWriter pw = null;

			for (String tableName : list) {
				if (null == tableName || tableName.equals("")) {
					continue;
				}
				
				//String className = getTableName(tableName).replaceFirst("Cl", "");
				String className = getTableName(tableName).replaceFirst("br", "");
				pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath + className + ".java")));
				String columnName = null;
				String clumnType = null;
				
				pw.println(pageInfo);
				pw.println("/**");

				StringBuffer methodBuf = new StringBuffer();

				pw.println("* 数据表:" + tableName);
				pw.println("* " + className + ".java");
				pw.println("* <p>Title: 系统 平台项目组</p>");
				pw.println("*");
				pw.println("* <p>Description: 用户实体类</p>");
				pw.println("*");
				pw.println("* <p>Copyright: ***Company Copyright (c) 2011</p>");
				pw.println("*");
				pw.println("* <p>Company: ***Company</p>");
				pw.println("*");
				pw.println("* @author 平台项目组:Administrator");
				pw.println("* "+sdf.format(new Date())+"");
				pw.println("* @version 1.0");
				pw.println("*/");
				pw.println("public final class " + className + "{");

				ps.setString(1, tableName);
				rs2 = ps.executeQuery();
				String defaultValue = null;
				while (rs2.next()) {
					columnName = rs2.getString("COLNAME");
					clumnType = rs2.getString("TPNAME");
					int datasize = rs2.getInt("LENGTH");
					int nullable = rs2.getInt("ISNULLABLE"); // 是否为空
					defaultValue =  rs2.getString("CDEFAULT");
					pw.printf("    private String %-33s  //数据库字段类型:%-10s  ----字段长度:%-5s ----是否可为空:%4s ----字段默认值:%8s \r\n", columnName.toLowerCase() + ";", clumnType, datasize, (nullable == 1 ? "true"
							: "false"),defaultValue);

					methodBuf.append(getMethodInfo(columnName));
				}
				pw.println(methodBuf);
				pw.println("}");
				pw.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getMethodInfo(String columnName) {
		return methodInfo.replaceAll("aaa", columnName.toLowerCase()).replace("Aaa", columnName.substring(0, 1).toUpperCase() + columnName.substring(1).toLowerCase());
	}

	public static String getTableName(String tableName) {
		StringBuffer className = new StringBuffer("");
		String temp[] = tableName.split("_");
		for (String temp2 : temp) {
			if (temp2.length() == 1) {
				continue;
			}
			className.append(temp2.charAt(0)).append(temp2.substring(1).toLowerCase());
		}
		return className.toString();
	}
}

class A {
	public int b = 1;

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}
}

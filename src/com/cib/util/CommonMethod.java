package com.cib.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cib.constant.Constant;
import com.cib.entity.User;

import net.sf.json.JSONArray;

/**
 * 
 * CommonMethod.java
 * <p>
 * Title:  系统管理运行平台
 * </p>
 * 
 * <p>
 * Description: 用户实体类
 * </p>
 * 
 * <p>
 * Copyright: XXX Copyright (c) 2010
 * </p>
 * 
 * <p>
 * Company: xxx
 * </p>
 * 
 * @author 2011.9
 * @version 1.0
 */
public class CommonMethod {
	
	
	/** 
     * 得到某一查询的结果集行数<br> 
     * @param tableName 作为表名参数<br> 
     * @param where 作为查询条件参数<br> 
     * @param con 作为数据库连接参数<br> 
     * @return rowCount<br> 
     */ 
    public static int getRowCountOfQuery(String tableName ,String where,Connection con) {
    	int rowCount = 0; 
    	StringBuffer sql = new StringBuffer("select count(*) rowCount from "+tableName+" ");
    	if(!"".equals(where)){
    		sql.append(where);
    	}
    	try {
    		PreparedStatement ps = con.prepareStatement(sql.toString());
    		ResultSet rs = ps.executeQuery();
    		if(rs.next()) { 
    			rowCount=rs.getInt("rowCount"); 
    		} 

    	}catch(Exception e) {   
    		e.printStackTrace(); 
        } 
    	return rowCount;
    }
	
	/** 将查询数据库获得的结果集转化为 二维数组 返回<br> 
     * 利用 ResultSetMetaData 获得结果集中的字段数目 k=ResultSetMetaData.getColumnCount();<br> 
     * 定义vector[k]; 将每个字段的结果集放入 vector[k]中。<br> 
     * 定义二维数组String[k][v[0].size]; 将vector[k] copyinto 到相应的二维数组中<br> 
     * 返回的二维数组为：String[i][j]  i=字段数目; j=单个字段的记录条数<br> 
     * @param rs ResultSet 作为参数<br> 
     * @return<br> 
     */ 
    public static String[][] resultTwoArray(ResultSet rs) { 
        try 
        { 
            ResultSetMetaData rsmd=rs.getMetaData(); 
            int k=rsmd.getColumnCount();                //  取出字段数目 
            System.out.println("字段返回类型＝|"+rsmd.getColumnTypeName(1)+"|"); 
            System.out.println("########查询字段数目k="+k); 
            if(k<1) 
            {   String[][] nul=null; 
                return nul; 
            } 
            Vector v[]=new Vector[k]; 
            for(int i=0;i<k;i++) 
                v[i]=new Vector(); 

            while(rs.next()) 
            {   for(int i=0;i<k;i++) 
                  v[i].addElement(rs.getObject(i+1)); 
            } 

            if(v[0]==null||v[0].size()==0) 
            {   String[][] nul2=null; 
                return nul2; 
            } 
            String[][] arr=new String[k][v[0].size()]; 
            for(int p=0;p<k;p++) 
                v[p].copyInto(arr[p]); //  将 Vector[p] copy 到数组 arr[p]中 

            //******************** null will be replaced with "" *************// 
            for(int i=0;i<arr.length;i++) 
            {   for(int j=0;j<arr[0].length;j++) 
                    if(arr[i][j]==null) 
                        arr[i][j]=""; 
            } 
            return arr; 
        } 
        catch(Exception e) 
        {   e.printStackTrace(); 
        } 
        return null; 
    } 
    /** 
     * 将查询数据库获得的结果集转化为 List返回 list中以一位数组为对象添加<br> 
     * 
     * @param rs ResultSet 作为参数<br> 
     * @return<br> 
     */ 
    public static List resultToListOfArray(ResultSet rs) {
    	List list = new ArrayList();
    	try {
    		ResultSetMetaData rsmd=rs.getMetaData();
    		int k=rsmd.getColumnCount();                //  取出字段数目
    		while(rs.next()){
    			String[] s = new String[k-1];
    			for(int i=1;i<=k;i++){
    				s[i-1]=rs.getString(i);
    			}
    			list.add(s);
    		}
    	}catch(Exception e) {   
    		e.printStackTrace(); 
        } 
    	return list;
    }
	/**
	 * @功能描述:填充函数
	 * @param str
	 *            字符串
	 * @param c
	 *            待填充
	 * @param totalLen
	 *            总长度
	 * @param leftRight
	 *            左填充还是右填充,true右补空格,false 左补空格,如果长度超过totallengh则切断后面部分
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String fillChar(String str, char c, int totalLen, boolean isLeft) {
		str = CommonMethod.ingoreNullStr(str);
		int realLen = str.length();
		if (realLen == totalLen) {
			return str;
		}

		if (realLen > totalLen) {
			return str.substring(0, totalLen);
		}

		StringBuffer strb = new StringBuffer();
		for (int i = 0; i < totalLen; i++) {
			strb.append(c);
		}
		if (isLeft) {
			strb.replace((totalLen - realLen), totalLen, str);
		} else {
			strb.replace(0, realLen, str);
		}

		return strb.toString();
	}

	/**
	 * @功能描述:获取下拉列表选中值
	 * @param request
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String getParameterValue(HttpServletRequest request, String paramName) {
		if (request.getParameter(paramName) == null) {
			return "";
		}
		return request.getParameter(paramName);
	}

	/**
	 * @功能描述:获取下拉列表选中值
	 * @param request
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String getSelectValue(HttpServletRequest request) {
		String selectlist = getParameterValue(request, "selectlist");
		String select = "";
		String selectarray[] = selectlist.split("#");
		for (String temp : selectarray) {
			if (CommonMethod.isNull(temp)) {
				continue;
			}
			select = temp;
			break;
		}

		return select;
	}

	/**
	 * @功能描述:
	 * @param request
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static User getUser(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Constant.USER_KEY);
		return obj == null ? null : (User) obj;
	}

	/**
	 * @功能描述:将null 对象转换为Sring对象
	 * @param obj
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String ingoreNullStr(Object obj) {
		if (null == obj) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * @功能描述:判断字符串是否为空:null 或者 "" 返回true
	 * @param str
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static boolean isNull(String str) {
		if (null == str || "".equals(str.trim())|| "null".equals(str.trim())) {
			return true;
		}
		return false;

	}

	/**
	 * @功能描述:比较两个字符串四否相等
	 * @param base
	 * @param target
	 * @return 如果两个字符串都为空 或者两个字符串相等,则返回true,否则返回false;
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static boolean isTextEqual(String base, String target) {
		if (null == base || null == target) {
			return !((null == base) ^ (null == base));
		}

		if (base.equals(target)) {
			return true;
		}

		return false;
	}

	/**
	 * @功能描述:验证用户密码是否匹配,方便以后密码加密
	 * @param pwd
	 * @param target
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static boolean isPassWordEqual(String pwd, String target) {
		return isTextEqual(encrypt(pwd), target);
	}

	/**
	 * @功能描述:获取结果集---所取List 里面封装的是HashMap对象,每一个HashMap对象封装一条数据库记录,键(数据库字段名)值(该条记录对应的值)
	 * @param rs
	 * @return
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static List<HashMap<String, String>> processResultMedaData(ResultSet rs) throws Exception {
		List<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
		ResultSetMetaData d = rs.getMetaData();
		int columncount = d.getColumnCount();
		String columnName[] = new String[columncount];
		String columnType[] = new String[columncount];
		String columnContent = null;
		for (int i = 1; i <= columncount; i++) {
			columnName[i - 1] = d.getColumnName(i);
			columnType[i - 1] = d.getColumnTypeName(i);
		}
		while (rs.next()) {
			HashMap<String, String> dataMap = new HashMap<String, String>();
			for (int i = 0; i < columncount; i++) {
				if (columnType[i].toUpperCase().equals("DATETIME")) {
					columnContent = DateUtil.parseDateToString(rs.getTimestamp(columnName[i]), null);
				} else if (columnType[i].toUpperCase().equals("VARCHAR")) {
					columnContent = CommonMethod.ingoreNullStr(rs.getString(columnName[i]));
				} else if (columnType[i].toUpperCase().equals("INT")) {
					columnContent = rs.getInt(columnName[i]) + "";
				} else if (columnType[i].toUpperCase().equals("CHAR")) {
					columnContent = rs.getString(columnName[i]) + "";
				} else {
					columnContent = rs.getString(columnName[i]) + "";
					// continue;
				}

				dataMap.put(columnName[i].toUpperCase(), columnContent);
			}

			resultList.add(dataMap);
		}
		return resultList;
	}

	/**
	 * @功能描述:获取指定对象 字段的指定属性值
	 * @param ojb
	 * @param filedName
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String getObjectField(Object ojb, String filedName) {
		String methodValue = "";
		try {
			Method method = ojb.getClass().getMethod("get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1), null);
			Object temp = method.invoke(ojb, null);
			if (null != temp) {
				methodValue = temp.toString();
			}
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}

		return methodValue;
	}

	

	/**
	 * @功能描述:获取指定对象 字段的指定属性值
	 * @param ojb
	 * @param filedName
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String setObjectField(Object ojb, String filedName, String value) {
		String methodValue = "";
		try {
			Class ptypes[] = new Class[1];
			ptypes[0] = Class.forName("java.lang.String");
			Method method = ojb.getClass().getMethod("set" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1), ptypes);
			if (null != method) {
				method.invoke(ojb, new Object[] { value });
			}
		} catch (Exception ex) {
			System.out.println(ex.getCause());
		}

		return methodValue;
	}

	/**
	 * @功能描述:将查询结果转换为实体
	 * @param entityPathInfo
	 *            需转换后的实体类路径
	 * @param rs
	 *            查询出的结果集
	 * @return
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static List convertResultSetToEntity(String entityPathInfo, ResultSet rs) throws Exception {
		List<HashMap<String, String>> data = processResultMedaData(rs);
		return convertResultSetToEntity(entityPathInfo, data);
	}

	public static List convertResultSetToArray(ResultSet rs) throws Exception {
		List<HashMap<String, String>> data = processResultMedaData(rs);
		return convertResultSetToArray(data);
	}

	/**
	 * @功能描述:将查询结果转换为实体
	 * @param entityPathInfo
	 *            需转换出的实体类名,譬如 com.cib.entity.User 只需传入 User即可
	 * @param map
	 *            从数据库查询出的ResultSet 经processResultMedaData方法处理过的List<HashMap> 对象
	 * @return
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static List convertResultSetToEntity(String entityPathInfo, List<HashMap<String, String>> dataList) throws Exception {
		List entityList = new ArrayList();
		if (null == dataList || dataList.isEmpty()) {
			return entityList;
		}
		Class target = Class.forName(Constant.ENTITY_PATH + entityPathInfo);
		Object[] paraObj = new Object[1];
		HashMap<String, Method> methodsMap = new HashMap();
		Method[] methods = target.getMethods();
		for (Method method : methods) {
			methodsMap.put(method.getName().replace("set", "").toUpperCase(), method);
		}
		Method method;
		for (HashMap<String, String> map : dataList) {
			Object entity = target.newInstance();
			Iterator<String> ite = map.keySet().iterator();
			while (ite.hasNext()) {
				String columnName = ite.next();
				paraObj[0] = map.get(columnName);
				method = methodsMap.get(columnName);
				if (null != method) {
					method.invoke(entity, paraObj);
				}
			}
			entityList.add(entity);
		}

		return entityList;
	}

	public static List convertResultSetToArray(List<HashMap<String, String>> dataList) throws Exception {
		List entityList = new ArrayList();
		int m = 0;
		String[] array = null;
		if (null == dataList || dataList.isEmpty()) {
			return entityList;
		} else {
			HashMap hash = (HashMap) dataList.get(0);
			m = hash.size();
			// 创建批次策略执行结果存放数组
			array = new String[m];
			// 通过第一条记录得到批次策略执行结果表表字段名称
			Iterator<String> it = hash.keySet().iterator();
			int i = 0;
			while (it.hasNext()) {
				String columnName = it.next();
				array[i] = columnName;
				i++;
			}
			entityList.add(array);
		}
		// 得到批次策略执行结果表内容
		for (HashMap<String, String> map : dataList) {
			Iterator<String> ite = map.keySet().iterator();
			String[] array0 = new String[m];
			int i = 0;
			while (ite.hasNext()) {
				// Map.Entry entry = (Map.Entry) ite.next();
				// String key = (String)entry.getKey();
				// String val = (String)entry.getValue();
				// System.out.println(key+" = "+val);
				String columnName = ite.next();
				String val = map.get(columnName);
				array0[i] = val;
				i++;
			}
			entityList.add(array0);
		}

		return entityList;
	}

	/**
	 * @功能描述:获取指定类型的指定属性
	 * @param entity
	 * @param propertyName
	 * @return
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String getEntityPropertyValue(Object entity, String propertyName) throws Exception {
		String methodName = "get" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1).toLowerCase();
		Class ptypes[] = new Class[0];
		Method method = entity.getClass().getMethod(methodName, ptypes);
		if (null == method) {
			return "";
		}
		Object value = method.invoke(entity, new Object[] {});
		if (null == value) {
			return "";
		}

		return value.toString();
	}

	/**
	 * @功能描述:Ajax 服务器向客户端格式化数据
	 * @param response
	 * @param resultList
	 *            查询结果集对象---可以为对象数组,字符串,基本数据类型
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author beedoor
	 */
	public static void setAjaxUtil(HttpServletResponse response, List resultList) throws Exception {
		response.setHeader("Cache-Control", "no-cache");
		response.setContentType("text/json;charset=GBK");
		PrintWriter out = response.getWriter();
		JSONArray jsonObject = new JSONArray();
		for (int i = 0; i < resultList.size(); i++) {
			jsonObject.add(resultList.get(i));
		}
		out.print(jsonObject.toString());
		out.flush();
		out.close();
	}

	

	/**
	 * @功能描述:解码选择列表
	 * @param selectList
	 *            选择的字符串
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String[] decodeSelectList(String selectList) {
		if (isNull(selectList)) {
			return null;
		}
		String[] temp = selectList.split("#");
		return temp;
	}

	/** ********************************MD5加密模块**************************************************** */
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * @功能描述: MD5加密串算法
	 * @param target
	 *            代码加的字符串
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static String encrypt(String target) {
		byte[] result = null;
		String resultString = "";
		try {
			MessageDigest alg = java.security.MessageDigest.getInstance("MD5");
			alg.update(target.getBytes());
			result = alg.digest();
			resultString = byteArrayToHexString(result).substring(10, 26);
			return (resultString);

		} catch (Exception ex) {
			return null;
		}

	}

	/**
	 * @功能描述:
	 * @param writer
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static void closeWriter(Writer writer) {
		try {
			if (writer != null) {
				writer.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @功能描述:
	 * @param writer
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public static void closeReader(Reader reader) {
		try {
			if (reader != null) {
				reader.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @功能描述: 转换字节数组为16进制字串
	 * @param b
	 *            字节数组
	 * @return 16进制字串
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * @功能描述:字节转换为16进制串
	 * @param b
	 * @return
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	/** ***********************end***************************************** */

	public static void main(String args[]) {
		System.out.print(getObjectField(new CommonMethod(), "Aaa"));
	}

	public static String getAaa() throws Exception {
		throw new Exception(new Exception("BBBBBB"));
		// return "TTT";
	}
}

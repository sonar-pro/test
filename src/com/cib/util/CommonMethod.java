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
 * Title:  ϵͳ��������ƽ̨
 * </p>
 * 
 * <p>
 * Description: �û�ʵ����
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
     * �õ�ĳһ��ѯ�Ľ��������<br> 
     * @param tableName ��Ϊ��������<br> 
     * @param where ��Ϊ��ѯ��������<br> 
     * @param con ��Ϊ���ݿ����Ӳ���<br> 
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
	
	/** ����ѯ���ݿ��õĽ����ת��Ϊ ��ά���� ����<br> 
     * ���� ResultSetMetaData ��ý�����е��ֶ���Ŀ k=ResultSetMetaData.getColumnCount();<br> 
     * ����vector[k]; ��ÿ���ֶεĽ�������� vector[k]�С�<br> 
     * �����ά����String[k][v[0].size]; ��vector[k] copyinto ����Ӧ�Ķ�ά������<br> 
     * ���صĶ�ά����Ϊ��String[i][j]  i=�ֶ���Ŀ; j=�����ֶεļ�¼����<br> 
     * @param rs ResultSet ��Ϊ����<br> 
     * @return<br> 
     */ 
    public static String[][] resultTwoArray(ResultSet rs) { 
        try 
        { 
            ResultSetMetaData rsmd=rs.getMetaData(); 
            int k=rsmd.getColumnCount();                //  ȡ���ֶ���Ŀ 
            System.out.println("�ֶη������ͣ�|"+rsmd.getColumnTypeName(1)+"|"); 
            System.out.println("########��ѯ�ֶ���Ŀk="+k); 
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
                v[p].copyInto(arr[p]); //  �� Vector[p] copy ������ arr[p]�� 

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
     * ����ѯ���ݿ��õĽ����ת��Ϊ List���� list����һλ����Ϊ�������<br> 
     * 
     * @param rs ResultSet ��Ϊ����<br> 
     * @return<br> 
     */ 
    public static List resultToListOfArray(ResultSet rs) {
    	List list = new ArrayList();
    	try {
    		ResultSetMetaData rsmd=rs.getMetaData();
    		int k=rsmd.getColumnCount();                //  ȡ���ֶ���Ŀ
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
	 * @��������:��亯��
	 * @param str
	 *            �ַ���
	 * @param c
	 *            �����
	 * @param totalLen
	 *            �ܳ���
	 * @param leftRight
	 *            ����仹�������,true�Ҳ��ո�,false �󲹿ո�,������ȳ���totallengh���жϺ��沿��
	 * @return
	 * @����ʱ�� 2011.9
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
	 * @��������:��ȡ�����б�ѡ��ֵ
	 * @param request
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static String getParameterValue(HttpServletRequest request, String paramName) {
		if (request.getParameter(paramName) == null) {
			return "";
		}
		return request.getParameter(paramName);
	}

	/**
	 * @��������:��ȡ�����б�ѡ��ֵ
	 * @param request
	 * @return
	 * @����ʱ�� 2011.9
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
	 * @��������:
	 * @param request
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static User getUser(HttpServletRequest request) {
		Object obj = request.getSession().getAttribute(Constant.USER_KEY);
		return obj == null ? null : (User) obj;
	}

	/**
	 * @��������:��null ����ת��ΪSring����
	 * @param obj
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static String ingoreNullStr(Object obj) {
		if (null == obj) {
			return "";
		}
		return obj.toString();
	}

	/**
	 * @��������:�ж��ַ����Ƿ�Ϊ��:null ���� "" ����true
	 * @param str
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean isNull(String str) {
		if (null == str || "".equals(str.trim())|| "null".equals(str.trim())) {
			return true;
		}
		return false;

	}

	/**
	 * @��������:�Ƚ������ַ����ķ����
	 * @param base
	 * @param target
	 * @return ��������ַ�����Ϊ�� ���������ַ������,�򷵻�true,���򷵻�false;
	 * @����ʱ�� 2011.9
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
	 * @��������:��֤�û������Ƿ�ƥ��,�����Ժ��������
	 * @param pwd
	 * @param target
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static boolean isPassWordEqual(String pwd, String target) {
		return isTextEqual(encrypt(pwd), target);
	}

	/**
	 * @��������:��ȡ�����---��ȡList �����װ����HashMap����,ÿһ��HashMap�����װһ�����ݿ��¼,��(���ݿ��ֶ���)ֵ(������¼��Ӧ��ֵ)
	 * @param rs
	 * @return
	 * @throws Exception
	 * @����ʱ�� 2011.9
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
	 * @��������:��ȡָ������ �ֶε�ָ������ֵ
	 * @param ojb
	 * @param filedName
	 * @return
	 * @����ʱ�� 2011.9
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
	 * @��������:��ȡָ������ �ֶε�ָ������ֵ
	 * @param ojb
	 * @param filedName
	 * @return
	 * @����ʱ�� 2011.9
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
	 * @��������:����ѯ���ת��Ϊʵ��
	 * @param entityPathInfo
	 *            ��ת�����ʵ����·��
	 * @param rs
	 *            ��ѯ���Ľ����
	 * @return
	 * @throws Exception
	 * @����ʱ�� 2011.9
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
	 * @��������:����ѯ���ת��Ϊʵ��
	 * @param entityPathInfo
	 *            ��ת������ʵ������,Ʃ�� com.cib.entity.User ֻ�贫�� User����
	 * @param map
	 *            �����ݿ��ѯ����ResultSet ��processResultMedaData�����������List<HashMap> ����
	 * @return
	 * @throws Exception
	 * @����ʱ�� 2011.9
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
			// �������β���ִ�н���������
			array = new String[m];
			// ͨ����һ����¼�õ����β���ִ�н������ֶ�����
			Iterator<String> it = hash.keySet().iterator();
			int i = 0;
			while (it.hasNext()) {
				String columnName = it.next();
				array[i] = columnName;
				i++;
			}
			entityList.add(array);
		}
		// �õ����β���ִ�н��������
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
	 * @��������:��ȡָ�����͵�ָ������
	 * @param entity
	 * @param propertyName
	 * @return
	 * @throws Exception
	 * @����ʱ�� 2011.9
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
	 * @��������:Ajax ��������ͻ��˸�ʽ������
	 * @param response
	 * @param resultList
	 *            ��ѯ���������---����Ϊ��������,�ַ���,������������
	 * @throws Exception
	 * @����ʱ�� 2011.9
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
	 * @��������:����ѡ���б�
	 * @param selectList
	 *            ѡ����ַ���
	 * @return
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public static String[] decodeSelectList(String selectList) {
		if (isNull(selectList)) {
			return null;
		}
		String[] temp = selectList.split("#");
		return temp;
	}

	/** ********************************MD5����ģ��**************************************************** */
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * @��������: MD5���ܴ��㷨
	 * @param target
	 *            ����ӵ��ַ���
	 * @return
	 * @����ʱ�� 2011.9
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
	 * @��������:
	 * @param writer
	 * @����ʱ�� 2011.9
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
	 * @��������:
	 * @param writer
	 * @����ʱ�� 2011.9
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
	 * @��������: ת���ֽ�����Ϊ16�����ִ�
	 * @param b
	 *            �ֽ�����
	 * @return 16�����ִ�
	 * @����ʱ�� 2011.9
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
	 * @��������:�ֽ�ת��Ϊ16���ƴ�
	 * @param b
	 * @return
	 * @����ʱ�� 2011.9
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

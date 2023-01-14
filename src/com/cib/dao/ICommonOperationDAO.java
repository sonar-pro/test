package com.cib.dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.cib.entity.User;
import com.cib.model.ActionRule2;
import com.cib.util.CommonMethod;



/**
 * @interface IActionRuleDAO
 * @function ���Ի���ҳDAO�ӿ�
 * @version 1.0
 * @author wqs
 */
public interface ICommonOperationDAO {
	
	/**
	 * ���ݱ����õ������������ִ�
	 * @param sql
	 * @throws SQLException
	 */
	public String getAllColsName(String sql)throws SQLException;
	/**
	 * ���ݱ����õ���һ����ֵ
	 * @param sql
	 * @throws SQLException
	 */
	public String getOneColValue(String sql)throws SQLException;
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void query(String sql)throws SQLException;
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(String sql);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public int delete(String sql);
	
	/*
	 * @method findAll
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAll(String sql);
	
	/*
	 * @method findById
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public ActionRule2 findById(java.lang.Long id);
	
	
	public List queryDataArray(String sql) throws Exception;
	
	
	//��ѯ��listȻ����з�װ
	public List queryEntityList(String entityPath,String sql) throws Exception ;

	/**
	 * @
	 */
	public void insertUnit(String insertSql, HashMap<Integer, Object> para)  throws Exception  ;

	/**
	 * @
	 */
	public List<HashMap<String, String>> queryEntityList(String sql)  throws Exception ;

	/**
	 * @��������:����Sql��䣬�Ա������޸ģ�update��
	 * @param AreaConfig
	 * @throws Exception
	 * @����ʱ�� 2011
	 * @author zxf
	 */
	public void update(String sql)  throws Exception ;

	
	public void update(String sql, HashMap<Integer, String> paraMap)  throws Exception ;
	
	public int queryTotalCount(String sql) throws Exception ;
	
	public int queryTotalCount(String sql,String index)  throws Exception ;
	public HashMap queryUserInfo()  throws Exception ;
	/**
	 * @��������: ��¼������־
	 * @param con
	 *            ���ݿ�����
	 * @param user
	 *            ��½�û�����
	 * @param operIP
	 *            ����IP
	 * @param logType
	 *            ��־����
	 * @param operNo
	 *            ����NO
	 * @param operDesc
	 *            ��־����
	 * @throws Exception
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */

	public void insertSysOperatorLog(Connection con, User user, String operIP, String logType, String operNo, String operDesc)  throws Exception ;

	/**
	 * @��������: ��¼������־
	 * @param user
	 *            ��½�û�����
	 * @param operIP
	 *            ����IP
	 * @param logType
	 *            ��־����0ϵͳ 1�˹�����
	 * @param operNo
	 *            ����NO ģ������
	 * @param operDesc
	 *            ��־����
	 * @throws Exception
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public void insertSysOperatorLog(User user, String operIP, String logType, String operNo, String operDesc)  throws Exception ;

	/**
	 * @��������:��¼������־
	 * @param oplogid
	 *            ������ID
	 * @param user
	 *            ��½�û�����
	 * @param operIP
	 *            ����IP
	 * @param logType
	 *            ��־����
	 * @param operNo
	 *            ����NO
	 * @param operDesc
	 *            ��־����
	 * @throws Exception
	 * @����ʱ�� 2011.9
	 * @author zxf
	 */
	public void insertSysOperatorLog(String oplogid, User user, String operIP, String logType, String operNo, String operDesc) throws Exception ;
	public HashMap queryColumnType(String tableName)  throws Exception ;
	/**
	 * @��������:�õ���ID
	 * @param sql
	 * @return int
	 * @throws Exception
	 * @����ʱ�� 2011.9
	 * @author Administrator
	 */
	public int getMaxId(String sql)  throws Exception ;
	
	/**************************FlexiGrid Start******************************/
	public int executeUpdate(String sqlQuery, String sqlValue[]);
	//���ؼ�¼��
	public int executeQuery(String sql);
	public ArrayList executeQueryList(String sql);
	/**************************FlexiGrid End******************************/
}
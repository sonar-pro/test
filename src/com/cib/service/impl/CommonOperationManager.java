package com.cib.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cib.dao.hibernate.ActionRule2DAO;
import com.cib.dao.hibernate.CommonOperationDAO;
import com.cib.dao.hibernate.LoginDAO;
import com.cib.entity.User;

import com.cib.model.ActionRule2;
import com.cib.service.ICommonOperationManager;

/**
 * @className ActionRuleManager
 * @function ���Ի���ҳ������Ϣҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class CommonOperationManager implements ICommonOperationManager
{
	
	 private CommonOperationDAO commonOperationDAO; //�˴�������ΪloginDAO

	public CommonOperationDAO getCommonOperationDAO() {
		return commonOperationDAO;
	}

	public void setCommonOperationDAO(CommonOperationDAO commonOperationDAO) {
		this.commonOperationDAO = commonOperationDAO;
	}
	/**
	 * ����sql�õ�����������ƴ�ӳɣ�col1,col2,col3,col4,col5�ַ���
	 * @param sql
	 * @throws SQLException
	 */
	public String getAllColsName(String sql)throws SQLException{
		return commonOperationDAO.getAllColsName(sql);
	}
	/**
	 * ����sql�õ���һ����ֵ
	 * @param sql
	 * @throws SQLException
	 */
	public String getOneColValue(String sql)throws SQLException{
		return commonOperationDAO.getOneColValue(sql);
	}
	@Override
	public void query(String sql) throws SQLException {
		// TODO Auto-generated method stub
		commonOperationDAO.query(sql);
	}

	/*
	 * @function ɾ�����Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public int delete(String id) 
	{
		return commonOperationDAO.delete(id);
	}

	/*
	 * @function ��ѯ���Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public List findAllActionRule(String sql)
	{
		return commonOperationDAO.findAll( sql);
	}

	/*
	 * @function ���ݸ��Ի���ҳ��Ż�ȡ���Ի���ҳʵ��
	 * @param id ���Ի���ҳ���
	 * @return actionRule ���Ի���ҳʵ��
	 */
	public ActionRule2 findByIdActionRule(Long id)
	{
		return commonOperationDAO.findById(id);
	}

	/*
	 * @function ������Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public void saveActionRule(String sql) 
	{
		commonOperationDAO.save(sql);
	}
	public List queryDataArray(String sql) throws Exception{
		return commonOperationDAO.queryDataArray(sql);
	}
	@Override
	public List queryEntityList(String entityPath, String sql) throws Exception {
		// TODO Auto-generated method stub
		
		return commonOperationDAO.queryEntityList(entityPath, sql);
	}

	@Override
	public void insertUnit(String insertSql, HashMap<Integer, Object> para) throws Exception{
		// TODO Auto-generated method stub
		commonOperationDAO.insertUnit(insertSql, para);
	}

	@Override
	public List<HashMap<String, String>> queryEntityList(String sql) throws Exception{
		// TODO Auto-generated method stub
		return commonOperationDAO.queryEntityList(sql);
	}

	@Override
	public void update(String sql) throws Exception{
		// TODO Auto-generated method stub
		commonOperationDAO.update(sql);
	}

	@Override
	public void update(String sql, HashMap<Integer, String> paraMap) throws Exception{
		// TODO Auto-generated method stub
		commonOperationDAO.update(sql, paraMap);
	}

	@Override
	public int queryTotalCount(String sql) throws Exception{
		// TODO Auto-generated method stub
		return commonOperationDAO.queryTotalCount(sql);
	}

	@Override
	public int queryTotalCount(String sql, String index) throws Exception{
		// TODO Auto-generated method stub
		return commonOperationDAO.queryTotalCount(sql, index);
	}

	@Override
	public HashMap queryUserInfo() throws Exception{
		// TODO Auto-generated method stub
		return commonOperationDAO.queryUserInfo();
	}

	@Override
	public void insertSysOperatorLog(Connection con, User user, String operIP,
			String logType, String operNo, String operDesc) throws Exception{
		// TODO Auto-generated method stub
		commonOperationDAO.insertSysOperatorLog(con, user, operIP, logType, operNo, operDesc);
	}

	@Override
	public void insertSysOperatorLog(User user, String operIP, String logType,
			String operNo, String operDesc) throws Exception{
		// TODO Auto-generated method stub
		commonOperationDAO.insertSysOperatorLog(user, operIP, logType, operNo, operDesc);
	}

	@Override
	public void insertSysOperatorLog(String oplogid, User user, String operIP,
			String logType, String operNo, String operDesc) throws Exception{
		// TODO Auto-generated method stub
		commonOperationDAO.insertSysOperatorLog(oplogid, user, operIP, logType, operNo, operDesc);
	}

	@Override
	public HashMap queryColumnType(String tableName) throws Exception{
		// TODO Auto-generated method stub
		return commonOperationDAO.queryColumnType(tableName);
	}

	@Override
	public int getMaxId(String sql) throws Exception{
		// TODO Auto-generated method stub
		return commonOperationDAO.getMaxId(sql);
	}
	/**************************FlexiGrid Start******************************/
	public int executeUpdate(String sqlQuery, String sqlValue[]) {
		return commonOperationDAO.executeUpdate(sqlQuery, sqlValue);
	}

	//���ؼ�¼��
	public int executeQuery(String sql){
		return commonOperationDAO.executeQuery(sql);
	}
	public ArrayList executeQueryList(String sql) {
		return commonOperationDAO.executeQueryList(sql);
	}
	/**************************FlexiGrid End******************************/
}

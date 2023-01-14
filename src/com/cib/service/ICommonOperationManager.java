package com.cib.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cib.entity.User;
import com.cib.model.ActionRule2;



/**
 * @interface IActionRule2Manager
 * @function 个性化插页业务接口
 * @version 1.0
 * @author wqs
 */
public interface ICommonOperationManager 
{
	/**
	 * 根据sql得到表所有列名
	 * @param sql
	 * @throws SQLException
	 */
	public String getAllColsName(String sql)throws SQLException;
	/**
	 * 根据sql得到表一个列值
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
	public String getOneColValue(String sql)throws SQLException;
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void query(String sql) throws SQLException;
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void saveActionRule(String sql);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public int delete(String sql);
	
	/*
	 * @method findAll
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAllActionRule(String sql);
	
	/*
	 * @method findById
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 模板管理实体对象
	 */
	public ActionRule2 findByIdActionRule(java.lang.Long id);
	
	
	public List queryDataArray(String sql) throws Exception;
	
	
	//查询出list然后进行封装
	public List queryEntityList(String entityPath,String sql) throws Exception;

	/**
	 * @
	 */
	public void insertUnit(String insertSql, HashMap<Integer, Object> para) throws Exception;

	/**
	 * @
	 */
	public List<HashMap<String, String>> queryEntityList(String sql) throws Exception;

	/**
	 * @功能描述:传递Sql语句，对表进行修改（update）
	 * @param AreaConfig
	 * @throws Exception
	 * @创建时间 2011
	 * @author zxf
	 */
	public void update(String sql) throws Exception;

	
	public void update(String sql, HashMap<Integer, String> paraMap) throws Exception ;
	
	public int queryTotalCount(String sql) throws Exception;
	
	public int queryTotalCount(String sql,String index) throws Exception;
	public HashMap queryUserInfo() throws Exception;
	/**
	 * @功能描述: 记录操作日志
	 * @param con
	 *            数据库连接
	 * @param user
	 *            登陆用户对象
	 * @param operIP
	 *            操作IP
	 * @param logType
	 *            日志类型
	 * @param operNo
	 *            操作NO
	 * @param operDesc
	 *            日志描述
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */

	public void insertSysOperatorLog(Connection con, User user, String operIP, String logType, String operNo, String operDesc) throws Exception;

	/**
	 * @功能描述: 记录操作日志
	 * @param user
	 *            登陆用户对象
	 * @param operIP
	 *            操作IP
	 * @param logType
	 *            日志类型0系统 1人工操作
	 * @param operNo
	 *            操作NO 模块名字
	 * @param operDesc
	 *            日志描述
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public void insertSysOperatorLog(User user, String operIP, String logType, String operNo, String operDesc) throws Exception;

	/**
	 * @功能描述:记录操作日志
	 * @param oplogid
	 *            操作表ID
	 * @param user
	 *            登陆用户对象
	 * @param operIP
	 *            操作IP
	 * @param logType
	 *            日志类型
	 * @param operNo
	 *            操作NO
	 * @param operDesc
	 *            日志描述
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author zxf
	 */
	public void insertSysOperatorLog(String oplogid, User user, String operIP, String logType, String operNo, String operDesc) throws Exception;
	public HashMap queryColumnType(String tableName) throws Exception;
	/**
	 * @功能描述:得到表ID
	 * @param sql
	 * @return int
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public int getMaxId(String sql) throws Exception;
	
	/**************************FlexiGrid Start******************************/
	public int executeUpdate(String sqlQuery, String sqlValue[]);
	//返回记录数
	public int executeQuery(String sql);
	public ArrayList executeQueryList(String sql);
	/**************************FlexiGrid End******************************/
}

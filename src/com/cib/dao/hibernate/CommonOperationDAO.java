package com.cib.dao.hibernate;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.cib.dao.ICommonOperationDAO;
import com.cib.model.ActionRule2;
import com.cib.entity.User;
import com.cib.util.CommonMethod;

import javax.sql.DataSource;


/**
 * @interface IActionRuleDAO
 * @function 个性化插页DAO接口
 * @version 1.0
 * @author wqs
 */
//public class CommonOperationDAO extends HibernateDaoSupport implements ICommonOperationDAO
//public class CommonOperationDAO extends JdbcDaoSupport  implements ICommonOperationDAO
public class CommonOperationDAO implements ICommonOperationDAO
{
	private static final Log log = LogFactory.getLog(CommonOperationDAO.class);
	private DataSource dataSource;
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public String getAllColsName(String sql) throws SQLException {
		StringBuffer cols = new StringBuffer("");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String name = rs.getString(1);
			if(cols.length()==0){
				cols.append(name);
			}else{
				cols.append(","+name);
			}
		}
		return cols.toString();
	}
	@Override
	public String getOneColValue(String sql) throws SQLException {
		StringBuffer cols = new StringBuffer("");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()){
			String name = rs.getString(1);
			if(cols.length()==0){
				cols.append(name);
			}else{
				cols.append(","+name);
			}
		}
		return cols.toString();
	}
	/*
	 * @function 
	 * @param 
	 * @return void
	 */
	public void query(String sql) throws SQLException 
	{

		log.debug("query  start");
		try
		{
			//Connection conn = getJdbcTemplate().getDataSource().getConnection();
			//System.out.println("getJdbcTemplate conn="+conn);
			System.out.println("dataSource conn="+dataSource.getConnection());
			//Connection conn = getHibernateTemplate().getSessionFactory().getCurrentSession().connection();
			//System.out.println("getHibernateTemplate() conn="+conn);
			
			log.debug("query  successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("query  failure", re);
			throw re;
		}
	}
	
	/*
	 * @function 删除个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public int delete(String sql ) {	
		int i = 0;
		log.debug("delete  start");
		try{
			Connection con = dataSource.getConnection();  
			PreparedStatement ps = con.prepareStatement(sql);
			i = ps.executeUpdate();
			log.debug("delete  successful");
		} catch (Exception re){
			re.printStackTrace();
			log.error("delete  failure", re);
			//throw re;
		}
		return i;
	}

	/*
	 * @function 查询个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public List findAll(String sql) {
		log.debug("findAll  start");
		
		log.debug("findAll  successful");
		return null;
			
	}

	/*
	 * @function 根据个性化插页编号获取个性化插页实体
	 * @param id 个性化插页编号
	 * @return actionRule 个性化插页实体
	 */
	public ActionRule2 findById(Long id) {
		log.debug("findById start");
		
		return null;	
	}

	/*
	 * @function 保存个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void save(String sql) {
		log.debug("save  start");
		try
		{
			//getHibernateTemplate().saveOrUpdate(actionRule);
			log.debug("save  successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save  failure", re);
			throw re;
		}
	}
	/*
	 * @function 保存更新
	 * @param id 查询ID是否存在
	 * @param sql 执行语句
	 * @return int
	 */
	public int saveOrUpdate(String id,String sql) throws Exception{
		log.debug("saveUpdate start");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		int i = ps.executeUpdate();
		return i;
	}
	
	/*
	 * @function 查询结果集转化为保存一维数组的list对象
	 * @param sql 查询语句
	 * @return list
	 */
	public List queryDataArray(String sql) throws Exception {
		log.debug("queryDataArray start");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List list = CommonMethod.resultToListOfArray(rs);
		if(!list.isEmpty()){
			return list;
		}
		return null;
	}
	
	
	//查询出实体对象然后进行list封装
	public List queryEntityList(String entityPath,String sql) throws Exception {
		log.debug("queryEntityList start");
		return CommonMethod.convertResultSetToEntity(entityPath, new ArrayList());
	}

	/**
	 * @
	 */
	public void insertUnit(String insertSql, HashMap<Integer, Object> para) throws Exception {
		log.debug("insertUnit start");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(insertSql);
		if (null != para && !para.isEmpty()) {
			Iterator<Integer> ite = para.keySet().iterator();
			while (ite.hasNext()) {
				Integer key = ite.next();
				Object value = para.get(key);
				if (value instanceof String) {
					ps.setString(key, (String) value);
				} else if (value instanceof Integer) {
					ps.setInt(key, (Integer) value);
				} else if (value instanceof Date) {
					ps.setDate(key, (Date) value);
				}
			}
		}
		ps.executeUpdate();
	}

	/**
	 * @
	 */
	public List<HashMap<String, String>> queryEntityList(String sql) throws Exception {
		log.debug("queryEntityList start");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		//System.out.println("sql=="+sql);
		return CommonMethod.processResultMedaData(rs);
	}

	/**
	 * @功能描述:传递Sql语句，对表进行修改（update）
	 * @param AreaConfig
	 * @throws Exception
	 * @创建时间 2011
	 * @author zxf
	 */
	public void update(String sql) throws Exception {
		log.debug("update start");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
	}

	
	public void update(String sql, HashMap<Integer, String> paraMap) throws Exception {
		log.debug("update start");
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		Set<Integer> keySet = paraMap.keySet();
		for (Integer temp : keySet) {
			ps.setString(temp, paraMap.get(temp));
		}
		ps.executeUpdate();
	}
	
	public int queryTotalCount(String sql) throws Exception {
		log.debug("queryTotalCount start");
		int count = 0;
		Connection con = dataSource.getConnection();
		StringBuffer sbf = new StringBuffer("select count(*) from (").append(sql).append(") ddd");
		log.info("查询总条数:" + sbf);
		PreparedStatement ps = con.prepareStatement(sbf.toString());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}

		return count;
	}
	
	public int queryTotalCount(String sql,String index) throws Exception {
		log.debug("queryTotalCount start");
		int count = 0;
		Connection con = dataSource.getConnection();
		StringBuffer sbf = new StringBuffer("select count("+index+") from (").append(sql).append(") ddd");
		log.info("查询总条数:" + sbf);
		PreparedStatement ps = con.prepareStatement(sbf.toString());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			count = rs.getInt(1);
		}
		
		return count;
	}
	public HashMap queryUserInfo() throws Exception {
		log.debug("queryUserInfo start");
		HashMap<String, String> userMap = new HashMap<String, String>();
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement("select t.user_id,t.user_name from cl_user t");
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			userMap.put(CommonMethod.ingoreNullStr(rs.getInt("USER_ID")) + "", CommonMethod.ingoreNullStr(rs.getString("USER_NAME")));
		}

		return userMap;
	}
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

	public void insertSysOperatorLog(Connection con, User user, String operIP, String logType, String operNo, String operDesc) throws Exception {
		log.debug("insertSysOperatorLog start");
		StringBuffer sqlBuffer = new StringBuffer("insert into cl_op_log (LOG_TYPE,OPER_UID,OPER_LOGINNAME,OPER_NAME,OPER_TIME,OPERATION_NO,OP_DESC,OP_IP)");
		sqlBuffer.append(" values (?,?,?,?,getDate(),?,?,?)");
		PreparedStatement ps = con.prepareStatement(sqlBuffer.toString());
		ps.setString(1, logType);
//		ps.setInt(2, Integer.parseInt(user.getUser_id()));
//		ps.setString(3, user.getUser_name());
//		ps.setString(4, user.getFullname());
		ps.setString(5, operNo);
		ps.setString(6, operDesc);
		ps.setString(7, operIP);
		ps.executeUpdate();
	}

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
	public void insertSysOperatorLog(User user, String operIP, String logType, String operNo, String operDesc) throws Exception {
		log.debug("insertSysOperatorLog start");
		Connection con = dataSource.getConnection();
		StringBuffer sqlBuffer = new StringBuffer("insert into cl_op_log (LOG_TYPE,OPER_UID,OPER_LOGINNAME,OPER_NAME,OPER_TIME,OPERATION_NO,OP_DESC,OP_IP)");
		sqlBuffer.append(" values (?,?,?,?,getDate(),?,?,?)");
		PreparedStatement ps = con.prepareStatement(sqlBuffer.toString());
		ps.setString(1, logType);
//		ps.setInt(2, Integer.parseInt(user.getUser_id()));
//		ps.setString(3, user.getUser_name());
//		ps.setString(4, user.getFullname());
		ps.setString(5, operNo);
		ps.setString(6, operDesc);
		ps.setString(7, operIP);
		ps.executeUpdate();
	}

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
	public void insertSysOperatorLog(String oplogid, User user, String operIP, String logType, String operNo, String operDesc) throws Exception {
		log.debug("insertSysOperatorLog start");
		Connection con = dataSource.getConnection();
		StringBuffer sqlBuffer = new StringBuffer("insert into cl_op_log (LOG_TYPE,OPER_UID,OPER_LOGINNAME,OPER_NAME,OPER_TIME,OPERATION_NO,OP_DESC,OP_IP)");
		sqlBuffer.append(" values (?,?,?,?,getDate(),?,?,?)");
		PreparedStatement ps = con.prepareStatement(sqlBuffer.toString());
		ps.setString(1, logType);
//		ps.setInt(2, Integer.parseInt(user.getUser_id()));
//		ps.setString(3, user.getUser_name());
//		ps.setString(4, user.getFullname());
		ps.setString(5, operNo);
		ps.setString(6, operDesc);
		ps.setString(7, operIP);
		ps.executeUpdate();
	}
	public HashMap queryColumnType(String tableName) throws Exception {
		log.debug("queryColumnType start");
		HashMap<String, String> columnTypeMap = new HashMap<String, String>();
		Connection con = dataSource.getConnection();
		DatabaseMetaData medaData = con.getMetaData();
		ResultSet columnRet = medaData.getColumns(null, "%", tableName, "%");
		while (columnRet.next()) {
			columnTypeMap.put(columnRet.getString("COLUMN_NAME"), columnRet.getString("TYPE_NAME"));
		}
		return columnTypeMap;
	}
	/**
	 * @功能描述:得到表ID
	 * @param sql
	 * @return int
	 * @throws Exception
	 * @创建时间 2011.9
	 * @author Administrator
	 */
	public int getMaxId(String sql)throws Exception
	   {	log.debug("getMaxId start");
		   Connection conn = null;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	       int id=0;
           conn = dataSource.getConnection();
           ps = conn.prepareStatement(sql);
           rs = ps.executeQuery();
           while (rs.next()) {
            id=rs.getInt("id");
           }
		   return id;
	   }
	
	/**************************FlexiGrid Start******************************/
	public int executeUpdate(String sqlQuery, String sqlValue[]) {
		int count = 0;
		try {
			Connection conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sqlQuery);
			if (sqlValue != null) {
				for (int i = 0; i < sqlValue.length; i++)
					ps.setString(i + 1, sqlValue[i]);
			}
			count = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

	//返回记录数
	public int executeQuery(String sql){
		ResultSet rs = null;
		//PreparedStatement ps;
		Statement st = null;
		int count=0;
		//System.out.println("conn="+conn);
		//System.out.println("sql1="+sql);
		try {
			Connection conn = dataSource.getConnection();
			//ps = conn.prepareStatement(sql);
			//rs = ps.executeQuery(sql);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			rs.next();
			count=rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	public ArrayList executeQueryList(String sql) {
		Statement st = null;
		ArrayList alResult = new ArrayList();
		try {
			Connection conn = dataSource.getConnection();
			st = conn.createStatement();
			ResultSet rs = st.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String colum[] = new String[count];
			for (int i = 0; i < colum.length; i++)
				if (rsmd.getColumnName(i + 1) != null)
					colum[i] = rsmd.getColumnName(i + 1);
				else
					colum[i] = rsmd.getColumnLabel(i + 1);

			HashMap row = null;
			String fieldValue = null;
			for (; rs.next(); alResult.add(row)) {
				row = new HashMap();
				for (int i = 0; i < colum.length; i++) {
					int iType = rsmd.getColumnType(i + 1);
					if (iType == 2 || iType == 3) {
						if (rsmd.getScale(i + 1) == 0)
							fieldValue = String.valueOf(rs.getLong(i + 1));
						else
							fieldValue = rs.getString(i + 1);
					} else if (iType == 8)
						fieldValue = String.valueOf(rs.getDouble(i + 1));
					else if (iType == 6 || iType == 7)
						fieldValue = String.valueOf(rs.getFloat(i + 1));
					else
						fieldValue = rs.getString(i + 1);
					if (fieldValue == null)
						fieldValue = "";
					else
						fieldValue = fieldValue.trim();
					row.put(colum[i], fieldValue);//.toLowerCase()
				}
			}
		} catch (Exception e) {}
		return alResult;
	}
	/**************************FlexiGrid End******************************/
}

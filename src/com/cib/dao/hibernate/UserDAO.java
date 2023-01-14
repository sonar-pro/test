package com.cib.dao.hibernate;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import com.cib.dao.IUserDAO;
import com.cib.model.ActionRule2;
import javax.sql.DataSource;


/**
 * @interface IActionRuleDAO
 * @function 个性化插页DAO接口
 * @version 1.0
 * @author wqs
 */
//public class LoginDAO extends HibernateDaoSupport implements ILoginDAO
public class UserDAO extends JdbcDaoSupport  implements IUserDAO
//public class LoginDAO implements ILoginDAO
{
	private static final Log log = LogFactory.getLog(UserDAO.class);
//	private DataSource dataSource;
//	public DataSource getDataSource() {
//		return dataSource;
//	}
//	public void setDataSource(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}
	/**
	 * @return the dataSource
	 */
	
	/*
	 * @function 删除个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void query(ActionRule2 actionRule) throws SQLException 
	{

		log.debug("query ActionRule2DAO start");
		try
		{
			Connection conn = getJdbcTemplate().getDataSource().getConnection();
			System.out.println("getJdbcTemplate conn="+conn);
			//System.out.println("dataSource conn="+dataSource.getConnection());
			//Connection conn = getHibernateTemplate().getSessionFactory().getCurrentSession().connection();
			//System.out.println("getHibernateTemplate() conn="+conn);
			
			log.debug("query ActionRule2DAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("query ActionRule2DAO failure", re);
			throw re;
		}
	}
	
	/*
	 * @function 删除个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void delete(ActionRule2 actionRule) 
	{

		log.debug("delete ActionRule2DAO start");
		try
		{
			//getHibernateTemplate().delete(actionRule);
			log.debug("delete ActionRule2DAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("delete ActionRule2DAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 查询个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public List findAll() 
	{
		log.debug("findAll ActionRule2DAO start");
		
				log.debug("findAll ActionRule2DAO successful");
				return null;
			
	}

	/*
	 * @function 根据个性化插页编号获取个性化插页实体
	 * @param id 个性化插页编号
	 * @return actionRule 个性化插页实体
	 */
	public ActionRule2 findById(Long id) {
		log.debug("findById ActionRule2DAO start");
		
				return null;
			
	}

	/*
	 * @function 保存个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void save(ActionRule2 actionRule) 
	{
		log.debug("save ActionRule2DAO start");
		try
		{
			//getHibernateTemplate().saveOrUpdate(actionRule);
			log.debug("save ActionRule2DAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save ActionRule2DAO failure", re);
			throw re;
		}
	}
}

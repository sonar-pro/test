package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IActionRule2DAO;
import com.cib.model.ActionRule2;



/**
 * @interface IActionRuleDAO
 * @function 个性化插页DAO接口
 * @version 1.0
 * @author wqs
 */
public class ActionRule2DAO extends HibernateDaoSupport implements IActionRule2DAO
{
private static final Log log = LogFactory.getLog(ActionRuleDAO.class);
	
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
			getHibernateTemplate().delete(actionRule);
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
		try
		{
			List list = getHibernateTemplate().find("from ActionRule2");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAll ActionRule2DAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAll ActionRule2DAO failure",re);
			throw re;
		}
	}

	/*
	 * @function 根据个性化插页编号获取个性化插页实体
	 * @param id 个性化插页编号
	 * @return actionRule 个性化插页实体
	 */
	public ActionRule2 findById(Long id) {
		log.debug("findById ActionRule2DAO start");
		try
		{
			ActionRule2 actionRule = (ActionRule2) getHibernateTemplate().get(ActionRule2.class, id);
			if (actionRule != null)
			{
				log.debug("findById ActionRule2DAO successful");
				return actionRule;
			} 
			else
			{
				log.debug("findById ActionRule2DAO is empty");
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findById ActionRule2DAO failure", re);
			throw re;
		}
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
			getHibernateTemplate().saveOrUpdate(actionRule);
			log.debug("save ActionRule2DAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save ActionRule2DAO failure", re);
			throw re;
		}
	}
}

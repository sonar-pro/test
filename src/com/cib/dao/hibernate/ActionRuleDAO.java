package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IActionRuleDAO;
import com.cib.model.ActionRule;

/**
 * @className ActionRuleDAO
 * @function 个性化插页规则信息DAO
 * @author wqs
 * @version 1.0
 */
public class ActionRuleDAO extends HibernateDaoSupport implements IActionRuleDAO
{
	private static final Log log = LogFactory.getLog(ActionRuleDAO.class);
	
	/*
	 * @function 删除个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void delete(ActionRule actionRule) 
	{

		log.debug("delete ActionRuleDAO start");
		try
		{
			getHibernateTemplate().delete(actionRule);
			log.debug("delete ActionRuleDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("delete ActionRuleDAO failure", re);
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
		log.debug("findAll ActionRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("from ActionRule");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAll ActionRuleDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAll ActionRuleDAO failure",re);
			throw re;
		}
	}

	/*
	 * @function 根据个性化插页编号获取个性化插页实体
	 * @param id 个性化插页编号
	 * @return actionRule 个性化插页实体
	 */
	public ActionRule findById(Long id) {
		log.debug("findById ActionRuleDAO start");
		try
		{
			ActionRule actionRule = (ActionRule) getHibernateTemplate().get(ActionRule.class, id);
			if (actionRule != null)
			{
				log.debug("findById ActionRuleDAO successful");
				return actionRule;
			} 
			else
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findById ActionRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 保存个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void save(ActionRule actionRule) 
	{
		log.debug("save ActionRuleDAO start");
		try
		{
			getHibernateTemplate().saveOrUpdate(actionRule);
			log.debug("save ActionRuleDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save ActionRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 查询分行列表
	 * @return List 分行城市集合
	 */
	public List findAllBank() 
	{
		log.debug("findAllBank ActionRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select distinct l.branchName as branchName from LocationDic l");
			//List list = getHibernateTemplate().find("from LocationDic");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAllBank ActionRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 查询分行所在城市
	 * @return List　城市集合
	 */
	public List findAllCity(String bankName)
	{
		log.debug("findAllCity ActionRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select l.location as location from LocationDic as l where l.branchName = ?",bankName);
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAllPro ActionRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 查询产品名称
	 * @return List　产品名称集合
	 */
	public List findAllPro() 
	{
		log.debug("findAllPro ActionRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select distinct c.cardClass as cardClass from CardTypeDic as c");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAllPro ActionRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 查询产品名称
	 * @return List　产品名称集合
	 */
	public List findAllCard(String cardClass) 
	{
		try
		{
			List list = getHibernateTemplate().find("select c.cardType as cardType from CardTypeDic c where c.cardClass = ?",cardClass);
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAllPro ActionRuleDAO failure", re);
			throw re;
		}
	}
}

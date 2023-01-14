package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IPrintRuleDAO;
import com.cib.model.PrintRule;

/**
 * @className PrintRuleDAO
 * @function 打印规则DAO
 * @author wqs
 * @version 1.0
 */
public class PrintRuleDAO extends HibernateDaoSupport implements IPrintRuleDAO
{
	private static final Log log = LogFactory.getLog(PrintRuleDAO.class);
	
	/*
	 * @function 删除打印规则
	 * @param printRule 打印规则实体
	 * @return void
	 */
	public void delete(PrintRule printRule) 
	{
		log.debug("delete PrintRuleDAO start");
		try
		{
			getHibernateTemplate().delete(printRule);
			log.debug("delete PrintRuleDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("delete PrintRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 查询打印规则
	 * @param printRule 打印规则实体
	 * @return void
	 */
	public List findAll() {
		log.debug("findAll PrintRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("from PrintRule p order by p.prtRuleId asc");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAll PrintRuleDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAll PrintRuleDAO failure",re);
			throw re;
		}
	}

	/*
	 * @function 根据打印规则编号获取打印规则
	 * @param id 打印规则编号
	 * @return printRule 打印规则实体
	 */
	public PrintRule findById(java.lang.Long id)
	{
		log.debug("findById PrintRuleDAO start");
		try
		{
			PrintRule printRule = (PrintRule) getHibernateTemplate().get(PrintRule.class, id);
			if (printRule != null)
			{
				log.debug("findById PrintRuleDAO successful");
				return printRule;
			} 
			else
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findById PrintRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 保存打印规则
	 * @param printRule 打印规则实体
	 * @return void
	 */
	public void save(PrintRule printRule) 
	{
		log.debug("save PrintRuleDAO start");
		try
		{
			getHibernateTemplate().saveOrUpdate(printRule);
			log.debug("save PrintRuleDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save PrintRuleDAO failure", re);
			throw re;
		}
	}

	/*
	 * @method findAllTempletId
	 * @function 获取模板编号列表
	 * @return List 模板编号集合
	 */
	public List findAllTempletId()
	{
		log.debug("findAllTempletId PrintRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select t.templateId as templateId from TmpMsg t");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAllTempletId PrintRuleDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAllTempletId PrintRuleDAO failure",re);
			throw re;
		}
	}
	
	/*
	 * @method findBytempletName
	 * @function 根据模板编号获取模板名称
	 * @return List 模板名称集合
	 */
	public List findBytempletName(Long id)
	{
		log.debug("findBytempletName PrintRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select t.templateName as templateName from TmpMsg t where  t.templateId =?",id);
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findBytempletName PrintRuleDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findBytempletName PrintRuleDAO failure",re);
			throw re;
		}
	}
	
	/*
	 * @method findAllActiveId
	 * @function 获取活动编号列表
	 * @return List 活动编号集合
	 */
	public List findAllActiveId() 
	{
		log.debug("findAllActiveId PrintRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select a.advActionId as advActionId from ActionRule a");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAllActiveId PrintRuleDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAllActiveId PrintRuleDAO failure",re);
			throw re;
		}
	}
	
	/*
	 * @method findActiveName
	 * @function 根据活动编号获取活动名称
	 * @return List 活动名称集合
	 */
	public List findActiveName(Long id) 
	{
		log.debug("findAllTempletId PrintRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select a.advActionName as advActionName from ActionRule a where a.advActionId =?",id);
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAllTempletId PrintRuleDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAllTempletId PrintRuleDAO failure",re);
			throw re;
		}
	}
	
	/*
	 * @method findByProductId
	 * @function 根据模板编号获取产品代码
	 * @return List 产品代码集合
	 */
	public List findByProductId(Long id)
	{
		log.debug("findByProductId PrintRuleDAO start");
		try
		{
			List list = getHibernateTemplate().find("select t.cardCode as cardCode from TmpMsg t where  t.templateId =?",id);
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findByProductId PrintRuleDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findByProductId PrintRuleDAO failure",re);
			throw re;
		}
	}
}

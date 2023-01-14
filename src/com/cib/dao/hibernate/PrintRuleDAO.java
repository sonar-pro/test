package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IPrintRuleDAO;
import com.cib.model.PrintRule;

/**
 * @className PrintRuleDAO
 * @function ��ӡ����DAO
 * @author wqs
 * @version 1.0
 */
public class PrintRuleDAO extends HibernateDaoSupport implements IPrintRuleDAO
{
	private static final Log log = LogFactory.getLog(PrintRuleDAO.class);
	
	/*
	 * @function ɾ����ӡ����
	 * @param printRule ��ӡ����ʵ��
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
	 * @function ��ѯ��ӡ����
	 * @param printRule ��ӡ����ʵ��
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
	 * @function ���ݴ�ӡ�����Ż�ȡ��ӡ����
	 * @param id ��ӡ������
	 * @return printRule ��ӡ����ʵ��
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
	 * @function �����ӡ����
	 * @param printRule ��ӡ����ʵ��
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
	 * @function ��ȡģ�����б�
	 * @return List ģ���ż���
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
	 * @function ����ģ���Ż�ȡģ������
	 * @return List ģ�����Ƽ���
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
	 * @function ��ȡ�����б�
	 * @return List ���ż���
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
	 * @function ���ݻ��Ż�ȡ�����
	 * @return List ����Ƽ���
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
	 * @function ����ģ���Ż�ȡ��Ʒ����
	 * @return List ��Ʒ���뼯��
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

package com.cib.dao.hibernate;


import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.ITmpMgDAO;
import com.cib.model.TmpMsg;

/**
 * @className TmpMgDAO
 * @function ģ��DAO
 * @author wqs
 * @version 1.0
 */
public class TmpMgDAO extends HibernateDaoSupport implements ITmpMgDAO
{
	private static final Log log = LogFactory.getLog(TmpMgDAO.class);
	
	/*
	 * @function ɾ��ģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public void delete(TmpMsg tmpmg) 
	{
		log.debug("delete UserDAO start");
		try
		{
			getHibernateTemplate().delete(tmpmg);
			log.debug("delete UserDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("delete UserDao failure", re);
			throw re;
		}
	}

	/*
	 * @function ��ѯģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public List findAll() {
		log.debug("findAll UserDAO start");
		try
		{
			List list = getHibernateTemplate().find("from TmpMsg");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAll UserDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAll UserDAO failure",re);
			throw re;
		}
	}

	/*
	 * @function ����ģ���Ż�ȡģ��
	 * @param id ģ����
	 * @return TmpMg ģ��ʵ��
	 */
	public TmpMsg findById(java.lang.Long id)
	{
		log.debug("findById UserDAO start");
		try
		{
			TmpMsg tmpmg = (TmpMsg) getHibernateTemplate().get(TmpMsg.class, id);
			if (tmpmg != null)
			{
				log.debug("findById UserDAO successful");
				return tmpmg;
			} 
			else
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findById UserDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function ����ģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public void save(TmpMsg tmpmg) 
	{
		log.debug("save userDAO start");
		try
		{
			getHibernateTemplate().saveOrUpdate(tmpmg);
			log.debug("save UserDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save userDAO failure", re);
			throw re;
		}
	}
}

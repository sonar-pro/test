package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IDepartmentDAO;
import com.cib.model.DepartmentMg;


/**
 * @className DepartmentDAO
 * @function ���Ź���DAO
 * @author wqs
 * @version 1.0
 */
public class DepartmentDAO extends HibernateDaoSupport implements IDepartmentDAO
{
	private static final Log log = LogFactory.getLog(DepartmentDAO.class);
	
	/*
	 * @function ɾ��ģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public void delete(DepartmentMg dept) 
	{
		log.debug("delete DepartmentDAO start");
		try
		{
			getHibernateTemplate().delete(dept);
			log.debug("delete DepartmentDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("delete DepartmentDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function ��ѯģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public List findAll() {
		log.debug("findAll DepartmentDAO start");
		try
		{
			List list = getHibernateTemplate().find("from DepartmentMg");
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAll DepartmentDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAll DepartmentDAO failure",re);
			throw re;
		}
	}

	/*
	 * @function ����ģ���Ż�ȡģ��
	 * @param id ģ����
	 * @return TmpMg ģ��ʵ��
	 */
	public DepartmentMg findById(java.lang.Long id)
	{
		log.debug("findById DepartmentDAO start");
		try
		{
			DepartmentMg dept = (DepartmentMg) getHibernateTemplate().get(DepartmentMg.class, id);
			if (dept != null)
			{
				log.debug("findById DepartmentDAO successful");
				return dept;
			} 
			else
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findById DepartmentDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function ����ģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public void save(DepartmentMg dept) 
	{
		log.debug("save DepartmentDAO start");
		try
		{
			System.out.println(dept.getDeptId());
			System.out.println(dept.getDeptName());
			getHibernateTemplate().saveOrUpdate(dept);
			
			log.debug("save DepartmentDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save DepartmentDAO failure", re);
			throw re;
		}
	}
}

package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IDepartmentDAO;
import com.cib.model.DepartmentMg;


/**
 * @className DepartmentDAO
 * @function 部门管理DAO
 * @author wqs
 * @version 1.0
 */
public class DepartmentDAO extends HibernateDaoSupport implements IDepartmentDAO
{
	private static final Log log = LogFactory.getLog(DepartmentDAO.class);
	
	/*
	 * @function 删除模板
	 * @param tmpmg 模板实体
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
	 * @function 查询模板
	 * @param tmpmg 模板实体
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
	 * @function 根据模板编号获取模板
	 * @param id 模板编号
	 * @return TmpMg 模板实体
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
	 * @function 保存模板
	 * @param tmpmg 模板实体
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

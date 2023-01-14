package com.cib.dao.hibernate;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IPrintInstDAO;
import com.cib.model.PrintInstitution;

public class PrintInstDAO extends HibernateDaoSupport implements IPrintInstDAO
{
	
	public void delete(PrintInstitution printInst) 
	{
		try
		{
			getHibernateTemplate().delete(printInst);
		} catch (RuntimeException re)
		{
			re.printStackTrace();
		}
	}

	public List findAll() 
	{
		List list = null;
		try
		{
			list = getHibernateTemplate().find("from PrintInstitution");
			if (list == null || list.size() < 1)
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
		}
		return list;
	}

	public PrintInstitution findById(Long id) 
	{
		PrintInstitution  print = (PrintInstitution) getHibernateTemplate().get(PrintInstitution.class, id);
		return print;
	}

	public void save(PrintInstitution printInst)
	{
		getHibernateTemplate().saveOrUpdate(printInst);
	}
}

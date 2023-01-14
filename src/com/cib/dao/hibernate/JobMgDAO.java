package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.cib.dao.IJobMgDAO;
import com.cib.model.JobMg;

/**
 * @className JobMgDAO
 * @function 模板DAO
 * @author wqs
 * @version 1.0
 */
public class JobMgDAO extends HibernateDaoSupport implements IJobMgDAO
{
	private static final Log log = LogFactory.getLog(JobMgDAO.class);
	
	/*
	 * @function 删除作业管理
	 * @param jobMg 作业管理实体
	 * @return void
	 */
	public void delete(JobMg jobMg) 
	{
		log.debug("delete JobMgDAO start");
		try
		{
			getHibernateTemplate().delete(jobMg);
			log.debug("delete JobMgDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("delete JobMgDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 查询作业管理
	 * @param jobMg 作业管理实体
	 * @return void
	 */
	public List findAll() {
		log.debug("findAll JobMgDAO start");
		/*String hql = "select jm.jobId as jobId,jm.cardType as cardType,jm.statementDate as statementDate," +
		"jm.consolStatus as consolStatus,jm.dataloadStatus as dataloadStatus," +
		"jm.streamloadStatus as streamloadStatus ,jp.genStatus as genStatus from JobMg jm,JobPrinting jp where jm.batchId = jp.batchId";*/
		try
		{
			List list = getHibernateTemplate().find("from JobMg jm order by jm.jobId");
			/*List list = getHibernateTemplate().find("select jm.jobId as jobId,jm.cardType as cardType,jm.statementDate as statementDate," +
					"jm.consolStatus as consolStatus,jm.dataloadStatus as dataloadStatus," +
					"jm.streamloadStatus as streamloadStatus ,jp.genStatus as genStatus from JobMg jm,JobPrinting jp where jm.batchId = jp.batchId");*/
			if (list == null || list.size() < 1)
			{
				return null;
			}
			else
			{
				log.debug("findAll JobMgDAO successful");
				return list;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findAll JobMgDAO failure",re);
			throw re;
		}
	}

	/*
	 * @function 根据作业管理编号获取作业管理
	 * @param id 作业管理编号
	 * @return jobMg 作业管理实体
	 */
	public JobMg findById(java.lang.Long id)
	{
		log.debug("findById JobMgDAO start");
		try
		{
			JobMg jobMg = (JobMg) getHibernateTemplate().get(JobMg.class, id);
			if (jobMg != null)
			{
				log.debug("findById JobMgDAO successful");
				return jobMg;
			} 
			else
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("findById JobMgDAO failure", re);
			throw re;
		}
	}

	/*
	 * @function 保存作业管理
	 * @param jobMg 作业管理实体
	 * @return void
	 */
	public void save(JobMg jobMg) 
	{
		log.debug("save JobMgDAO start");
		try
		{
			getHibernateTemplate().saveOrUpdate(jobMg);
			log.debug("save JobMgDAO successful");
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("save JobMgDAO failure", re);
			throw re;
		}
	}
}

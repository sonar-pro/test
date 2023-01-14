package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.JobMgDAO;
import com.cib.model.JobMg;
import com.cib.service.IJobMgManager;

/**
 * @className JobMgManager
 * @function 作业管理实现类
 * @author wqs
 * @version 1.0
 */
public class JobMgManager implements IJobMgManager
{
	private JobMgDAO jobMgDAO;
	
	/*
	 * @function 删除作业管理
	 * @param jobMg 作业管理实体
	 * @return void
	 */
	public void deleteJobMg(JobMg jobMg) 
	{
		jobMgDAO.delete(jobMg);
	}

	/*
	 * @function 查询作业管理
	 * @param jobMg 作业管理实体
	 * @return void
	 */
	public List findAllJobMg() 
	{
		return jobMgDAO.findAll();
	}

	/*
	 * @function 根据作业管理编号获取作业管理
	 * @param id 作业管理编号
	 * @return jobMg 作业管理实体
	 */
	public JobMg findByIdJobMg(Long id)
	{
		return jobMgDAO.findById(id);
	}

	/*
	 * @function 保存作业管理
	 * @param jobMg 作业管理实体
	 * @return void
	 */
	public void saveJobMg(JobMg jobMg) 
	{
		jobMgDAO.save(jobMg);
	}

	public JobMgDAO getJobMgDAO() {
		return jobMgDAO;
	}

	public void setJobMgDAO(JobMgDAO jobMgDAO) {
		this.jobMgDAO = jobMgDAO;
	}
}

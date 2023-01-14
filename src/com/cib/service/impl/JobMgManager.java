package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.JobMgDAO;
import com.cib.model.JobMg;
import com.cib.service.IJobMgManager;

/**
 * @className JobMgManager
 * @function ��ҵ����ʵ����
 * @author wqs
 * @version 1.0
 */
public class JobMgManager implements IJobMgManager
{
	private JobMgDAO jobMgDAO;
	
	/*
	 * @function ɾ����ҵ����
	 * @param jobMg ��ҵ����ʵ��
	 * @return void
	 */
	public void deleteJobMg(JobMg jobMg) 
	{
		jobMgDAO.delete(jobMg);
	}

	/*
	 * @function ��ѯ��ҵ����
	 * @param jobMg ��ҵ����ʵ��
	 * @return void
	 */
	public List findAllJobMg() 
	{
		return jobMgDAO.findAll();
	}

	/*
	 * @function ������ҵ�����Ż�ȡ��ҵ����
	 * @param id ��ҵ������
	 * @return jobMg ��ҵ����ʵ��
	 */
	public JobMg findByIdJobMg(Long id)
	{
		return jobMgDAO.findById(id);
	}

	/*
	 * @function ������ҵ����
	 * @param jobMg ��ҵ����ʵ��
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

package com.cib.service;

import java.util.List;

import com.cib.model.JobMg;

/**
 * @className IJobMgManager
 * @function ��ҵ����ҵ��ӿ�
 * @author wqs
 * @version 1.0
 */
public interface IJobMgManager 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void saveJobMg(JobMg jobMg);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void deleteJobMg(JobMg jobMg);
	
	/*
	 * @method findAll
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAllJobMg();
	
	/*
	 * @method findById
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public JobMg findByIdJobMg(java.lang.Long id);
}

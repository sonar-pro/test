package com.cib.dao;

import java.util.List;

import com.cib.model.JobMg;

public interface IJobMgDAO
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(JobMg jobMg);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(JobMg jobMg);
	
	/*
	 * @method findAll
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAll();
	
	/*
	 * @method findById
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public JobMg findById(java.lang.Long id);
}

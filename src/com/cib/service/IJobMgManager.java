package com.cib.service;

import java.util.List;

import com.cib.model.JobMg;

/**
 * @className IJobMgManager
 * @function 作业管理业务接口
 * @author wqs
 * @version 1.0
 */
public interface IJobMgManager 
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void saveJobMg(JobMg jobMg);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void deleteJobMg(JobMg jobMg);
	
	/*
	 * @method findAll
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAllJobMg();
	
	/*
	 * @method findById
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 模板管理实体对象
	 */
	public JobMg findByIdJobMg(java.lang.Long id);
}

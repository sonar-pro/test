package com.cib.dao;

import java.util.List;

import com.cib.model.JobMg;

public interface IJobMgDAO
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void save(JobMg jobMg);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void delete(JobMg jobMg);
	
	/*
	 * @method findAll
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAll();
	
	/*
	 * @method findById
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 模板管理实体对象
	 */
	public JobMg findById(java.lang.Long id);
}

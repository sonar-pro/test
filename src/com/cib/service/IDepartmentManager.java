package com.cib.service;

import java.util.List;

import com.cib.model.DepartmentMg;


/**
 * @className IDepartmentManager
 * @function 部门管理业务接口
 * @author wqs
 * @version 1.0
 */
public interface IDepartmentManager 
{
	/*
	 * @method saveDept
	 * @function 保存实体对象
	 * @return void
	 */
	public void saveDept(DepartmentMg dept);
	
	/*
	 * @method deleteDept
	 * @function 删除实体对象
	 * @return void
	 */
	public void deleteDept(DepartmentMg dept);
	
	/*
	 * @method findAllDept
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAllDept();
	
	/*
	 * @method DepartmentMg
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 模板管理实体对象
	 */
	public DepartmentMg findByIdDept(java.lang.Long id);
}

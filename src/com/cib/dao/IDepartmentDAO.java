package com.cib.dao;

import java.util.List;

import com.cib.model.DepartmentMg;


/**
 * @interface IDepartmentMg
 * @function 部门管理DAO接口
 * @version 1.0
 * @author wqs
 */
public interface IDepartmentDAO 
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void save(DepartmentMg dept);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void delete(DepartmentMg dept);
	
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
	public DepartmentMg findById(java.lang.Long id);
}

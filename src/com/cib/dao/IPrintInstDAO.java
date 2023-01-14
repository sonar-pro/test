package com.cib.dao;

import java.util.List;

import com.cib.model.PrintInstitution;

/**
 * @interface IPrintInstDAO
 * @function 模板管理DAO接口
 * @version 1.0
 * @author wqs
 */
public interface IPrintInstDAO 
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void save(PrintInstitution printInst);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void delete(PrintInstitution printInst);
	
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
	public PrintInstitution findById(java.lang.Long id);
}

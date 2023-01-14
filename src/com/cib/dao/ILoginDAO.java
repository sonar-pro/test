package com.cib.dao;

import java.sql.SQLException;
import java.util.List;

import com.cib.model.ActionRule2;



/**
 * @interface IActionRuleDAO
 * @function 个性化插页DAO接口
 * @version 1.0
 * @author wqs
 */
public interface ILoginDAO 
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void query(ActionRule2 actionRule)throws SQLException;
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void save(ActionRule2 actionRule);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void delete(ActionRule2 actionRule);
	
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
	public ActionRule2 findById(java.lang.Long id);
}

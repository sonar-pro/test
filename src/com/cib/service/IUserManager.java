package com.cib.service;

import java.sql.SQLException;
import java.util.List;

import com.cib.model.ActionRule2;



/**
 * @interface IActionRule2Manager
 * @function 个性化插页业务接口
 * @version 1.0
 * @author wqs
 */
public interface IUserManager 
{
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void query(ActionRule2 actionRule) throws SQLException;
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void saveActionRule(ActionRule2 actionRule);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void deleteActionRule(ActionRule2 actionRule);
	
	/*
	 * @method findAll
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAllActionRule();
	
	/*
	 * @method findById
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 模板管理实体对象
	 */
	public ActionRule2 findByIdActionRule(java.lang.Long id);
}

package com.cib.dao;

import java.util.List;

import com.cib.model.ActionRule;

/**
 * @interface IActionRuleDAO
 * @function 个性化插页DAO接口
 * @version 1.0
 * @author wqs
 */
public interface IActionRuleDAO 
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void save(ActionRule actionRule);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void delete(ActionRule actionRule);
	
	/*
	 * @method findAll
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAll();
	
	/*
	 * @method findById
	 * @function 根据实体的id，获取该实体
	 * @return ActionRule 个性化实体对象
	 */
	public ActionRule findById(java.lang.Long id);
	
	/*
	 * @method findAllCity
	 * @function 获取城市实体列表
	 * @return List 分行集合
	 */
	public List findAllBank();
	
	/*
	 * @method findAllPro
	 * @function 获取城市列表
	 * @return List 城市集合
	 */
	public List findAllCity(String bankName);
	
	/*
	 * @method findAllPro
	 * @function 获取产品名称实体列表
	 * @return List 产品名称集合
	 */
	public List findAllPro();
	
	/*
	 * @method findAllCard
	 * @function 获取卡类实体列表
	 * @return List 卡类集合
	 */
	public List findAllCard(String cardClass);
	
}

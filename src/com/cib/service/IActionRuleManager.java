package com.cib.service;

import java.util.List;

import com.cib.model.ActionRule;

/**
 * @interface IActionRuleManager
 * @function 个性化插页业务接口
 * @version 1.0
 * @author wqs
 */
public interface IActionRuleManager 
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void saveActionRule(ActionRule actionRule);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void deleteActionRule(ActionRule actionRule);
	
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
	public ActionRule findByIdActionRule(java.lang.Long id);
	
	/*
	 * @method findAllBank
	 * @function　获取分行实体列表
	 * @return List 分行实体集合 
	 */
	public List findAllBanks();
	
	/*
	 * @method findAllCity
	 * @function 获取城市实体列表
	 * @return List 城市实体集合 
	 */
	public List findAllCitys(String bankName);
	
	/*
	 * @method findAllPros
	 * @function 获取产品名称实体列表
	 * @return List 产品名称实体集合
	 */
	public List findAllPros();
	
	/*
	 * @method findAllCard
	 * @function 获取卡类实体列表
	 * @return List 卡类集合
	 */
	public List findAllCard(String cardClass);
	
	
}

package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.ActionRuleDAO;
import com.cib.model.ActionRule;
import com.cib.service.IActionRuleManager;

/**
 * @className ActionRuleManager
 * @function 个性化插页规则信息业务实现类
 * @author wqs
 * @version 1.0
 */
public class ActionRuleManager implements IActionRuleManager
{
	private ActionRuleDAO actionRuleDAO;
	
	/*
	 * @function 删除个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void deleteActionRule(ActionRule actionRule) 
	{
		actionRuleDAO.delete(actionRule);
	}

	/*
	 * @function 查询个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public List findAllActionRule()
	{
		return actionRuleDAO.findAll();
	}

	/*
	 * @function 根据个性化插页编号获取个性化插页实体
	 * @param id 个性化插页编号
	 * @return actionRule 个性化插页实体
	 */
	public ActionRule findByIdActionRule(Long id)
	{
		return actionRuleDAO.findById(id);
	}

	/*
	 * @function 保存个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void saveActionRule(ActionRule actionRule) 
	{
		actionRuleDAO.save(actionRule);
	}
	
	/*
	 * @method findAllCity
	 * @function 获取分行实体列表
	 * @return List 分行实体集合 
	 */
	public List findAllBanks() 
	{
		return actionRuleDAO.findAllBank();
	}

	/*
	 * @method findAllCity
	 * @function 获取城市实体列表
	 * @return List 城市实体集合 
	 */
	public List findAllCitys(String bankName)
	{
		return actionRuleDAO.findAllCity(bankName);
	}
	
	/*
	 * @method findAllPros
	 * @function 获取产品名称实体列表
	 * @return List 产品实体名称集合
	 */
	public List findAllPros() 
	{
		return actionRuleDAO.findAllPro();
	}
	
	/*
	 * @method findAllPros
	 * @function 获取卡类实体列表
	 * @return List 卡类集合
	 */
	public List findAllCard(String cardClass) 
	{
		return actionRuleDAO.findAllCard(cardClass);
	}

	
	
	public ActionRuleDAO getActionRuleDAO() {
		return actionRuleDAO;
	}

	public void setActionRuleDAO(ActionRuleDAO actionRuleDAO) {
		this.actionRuleDAO = actionRuleDAO;
	}
}

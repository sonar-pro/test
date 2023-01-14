package com.cib.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cib.dao.hibernate.ActionRule2DAO;
import com.cib.dao.hibernate.UserDAO;

import com.cib.model.ActionRule2;
import com.cib.service.IUserManager;

/**
 * @className ActionRuleManager
 * @function 个性化插页规则信息业务实现类
 * @author wqs
 * @version 1.0
 */
public class UserManager implements IUserManager
{
	
	private UserDAO userDAO; //此处属性名为loginDAO

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void query(ActionRule2 actionRule) throws SQLException {
		// TODO Auto-generated method stub
		userDAO.query(actionRule);
	}
	private ActionRule2DAO actionRule2DAO;
	/*
	 * @function 删除个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void deleteActionRule(ActionRule2 actionRule) 
	{
		actionRule2DAO.delete(actionRule);
	}

	/*
	 * @function 查询个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public List findAllActionRule()
	{
		return actionRule2DAO.findAll();
	}

	/*
	 * @function 根据个性化插页编号获取个性化插页实体
	 * @param id 个性化插页编号
	 * @return actionRule 个性化插页实体
	 */
	public ActionRule2 findByIdActionRule(Long id)
	{
		return actionRule2DAO.findById(id);
	}

	/*
	 * @function 保存个性化插页规则信息
	 * @param actionRule 个性化插页规则信息实体
	 * @return void
	 */
	public void saveActionRule(ActionRule2 actionRule) 
	{
		actionRule2DAO.save(actionRule);
	}

	public ActionRule2DAO getActionRule2DAO() {
		return actionRule2DAO;
	}

	public void setActionRule2DAO(ActionRule2DAO actionRule2DAO) {
		this.actionRule2DAO = actionRule2DAO;
	}

	
}

package com.cib.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.cib.dao.hibernate.ActionRule2DAO;
import com.cib.dao.hibernate.LoginDAO;

import com.cib.model.ActionRule2;
import com.cib.service.ILoginManager;

/**
 * @className ActionRuleManager
 * @function ���Ի���ҳ������Ϣҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class LoginManager implements ILoginManager
{
	
	 private LoginDAO loginDAO; //�˴�������ΪloginDAO
	public LoginDAO getLoginDAO() {
		return loginDAO;
	}

	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public void query(ActionRule2 actionRule) throws SQLException {
		// TODO Auto-generated method stub
		loginDAO.query(actionRule);
	}
	private ActionRule2DAO actionRule2DAO;
	/*
	 * @function ɾ�����Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public void deleteActionRule(ActionRule2 actionRule) 
	{
		actionRule2DAO.delete(actionRule);
	}

	/*
	 * @function ��ѯ���Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public List findAllActionRule()
	{
		return actionRule2DAO.findAll();
	}

	/*
	 * @function ���ݸ��Ի���ҳ��Ż�ȡ���Ի���ҳʵ��
	 * @param id ���Ի���ҳ���
	 * @return actionRule ���Ի���ҳʵ��
	 */
	public ActionRule2 findByIdActionRule(Long id)
	{
		return actionRule2DAO.findById(id);
	}

	/*
	 * @function ������Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
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

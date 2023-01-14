package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.ActionRuleDAO;
import com.cib.model.ActionRule;
import com.cib.service.IActionRuleManager;

/**
 * @className ActionRuleManager
 * @function ���Ի���ҳ������Ϣҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class ActionRuleManager implements IActionRuleManager
{
	private ActionRuleDAO actionRuleDAO;
	
	/*
	 * @function ɾ�����Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public void deleteActionRule(ActionRule actionRule) 
	{
		actionRuleDAO.delete(actionRule);
	}

	/*
	 * @function ��ѯ���Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public List findAllActionRule()
	{
		return actionRuleDAO.findAll();
	}

	/*
	 * @function ���ݸ��Ի���ҳ��Ż�ȡ���Ի���ҳʵ��
	 * @param id ���Ի���ҳ���
	 * @return actionRule ���Ի���ҳʵ��
	 */
	public ActionRule findByIdActionRule(Long id)
	{
		return actionRuleDAO.findById(id);
	}

	/*
	 * @function ������Ի���ҳ������Ϣ
	 * @param actionRule ���Ի���ҳ������Ϣʵ��
	 * @return void
	 */
	public void saveActionRule(ActionRule actionRule) 
	{
		actionRuleDAO.save(actionRule);
	}
	
	/*
	 * @method findAllCity
	 * @function ��ȡ����ʵ���б�
	 * @return List ����ʵ�弯�� 
	 */
	public List findAllBanks() 
	{
		return actionRuleDAO.findAllBank();
	}

	/*
	 * @method findAllCity
	 * @function ��ȡ����ʵ���б�
	 * @return List ����ʵ�弯�� 
	 */
	public List findAllCitys(String bankName)
	{
		return actionRuleDAO.findAllCity(bankName);
	}
	
	/*
	 * @method findAllPros
	 * @function ��ȡ��Ʒ����ʵ���б�
	 * @return List ��Ʒʵ�����Ƽ���
	 */
	public List findAllPros() 
	{
		return actionRuleDAO.findAllPro();
	}
	
	/*
	 * @method findAllPros
	 * @function ��ȡ����ʵ���б�
	 * @return List ���༯��
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

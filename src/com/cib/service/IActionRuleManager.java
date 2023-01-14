package com.cib.service;

import java.util.List;

import com.cib.model.ActionRule;

/**
 * @interface IActionRuleManager
 * @function ���Ի���ҳҵ��ӿ�
 * @version 1.0
 * @author wqs
 */
public interface IActionRuleManager 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void saveActionRule(ActionRule actionRule);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void deleteActionRule(ActionRule actionRule);
	
	/*
	 * @method findAll
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAllActionRule();
	
	/*
	 * @method findById
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public ActionRule findByIdActionRule(java.lang.Long id);
	
	/*
	 * @method findAllBank
	 * @function����ȡ����ʵ���б�
	 * @return List ����ʵ�弯�� 
	 */
	public List findAllBanks();
	
	/*
	 * @method findAllCity
	 * @function ��ȡ����ʵ���б�
	 * @return List ����ʵ�弯�� 
	 */
	public List findAllCitys(String bankName);
	
	/*
	 * @method findAllPros
	 * @function ��ȡ��Ʒ����ʵ���б�
	 * @return List ��Ʒ����ʵ�弯��
	 */
	public List findAllPros();
	
	/*
	 * @method findAllCard
	 * @function ��ȡ����ʵ���б�
	 * @return List ���༯��
	 */
	public List findAllCard(String cardClass);
	
	
}

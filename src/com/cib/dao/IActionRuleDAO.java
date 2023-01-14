package com.cib.dao;

import java.util.List;

import com.cib.model.ActionRule;

/**
 * @interface IActionRuleDAO
 * @function ���Ի���ҳDAO�ӿ�
 * @version 1.0
 * @author wqs
 */
public interface IActionRuleDAO 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(ActionRule actionRule);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(ActionRule actionRule);
	
	/*
	 * @method findAll
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAll();
	
	/*
	 * @method findById
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return ActionRule ���Ի�ʵ�����
	 */
	public ActionRule findById(java.lang.Long id);
	
	/*
	 * @method findAllCity
	 * @function ��ȡ����ʵ���б�
	 * @return List ���м���
	 */
	public List findAllBank();
	
	/*
	 * @method findAllPro
	 * @function ��ȡ�����б�
	 * @return List ���м���
	 */
	public List findAllCity(String bankName);
	
	/*
	 * @method findAllPro
	 * @function ��ȡ��Ʒ����ʵ���б�
	 * @return List ��Ʒ���Ƽ���
	 */
	public List findAllPro();
	
	/*
	 * @method findAllCard
	 * @function ��ȡ����ʵ���б�
	 * @return List ���༯��
	 */
	public List findAllCard(String cardClass);
	
}

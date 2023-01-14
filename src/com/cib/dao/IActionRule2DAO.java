package com.cib.dao;

import java.util.List;

import com.cib.model.ActionRule2;



/**
 * @interface IActionRuleDAO
 * @function ���Ի���ҳDAO�ӿ�
 * @version 1.0
 * @author wqs
 */
public interface IActionRule2DAO 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(ActionRule2 actionRule);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(ActionRule2 actionRule);
	
	/*
	 * @method findAll
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAll();
	
	/*
	 * @method findById
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public ActionRule2 findById(java.lang.Long id);
}

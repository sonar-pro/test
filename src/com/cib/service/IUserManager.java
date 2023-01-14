package com.cib.service;

import java.sql.SQLException;
import java.util.List;

import com.cib.model.ActionRule2;



/**
 * @interface IActionRule2Manager
 * @function ���Ի���ҳҵ��ӿ�
 * @version 1.0
 * @author wqs
 */
public interface IUserManager 
{
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void query(ActionRule2 actionRule) throws SQLException;
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void saveActionRule(ActionRule2 actionRule);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void deleteActionRule(ActionRule2 actionRule);
	
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
	public ActionRule2 findByIdActionRule(java.lang.Long id);
}

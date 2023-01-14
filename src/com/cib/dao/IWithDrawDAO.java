package com.cib.dao;

import java.util.List;

import com.cib.model.WithdrawManager;

/**
 * @interface IWithDrawDAO
 * @function ���ţģ��Ͻӿ�
 * @author wqs
 * @version 1.0
 */
public interface IWithDrawDAO 
{
	/*
	 * @methodName save
	 * @functionn ����������Ϣ
	 * @param WithdrawManager ����ʵ��
	 * @return void 
	 */
	public void save(WithdrawManager withdraw);
	
	/*
	 * @methodName findByCardId
	 * @functionn �������ſ��Ų���������Ϣ
	 * @param id ���ſ���
	 * @return List ����ʵ�弯��
	 */
	public List findByCardId(String id);
	
	/*
	 * @methodName findByCardId
	 * @functionn �����˵��ڲ���������Ϣ
	 * @param id ���ſ���
	 * @return List ����ʵ�弯��
	 */
	public List findByBillDate(String date);
}

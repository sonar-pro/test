package com.cib.service;

import java.util.List;

import com.cib.model.WithdrawManager;

/**
 * @interface IWithdrawManager
 * @function ����ҵ��ӿ�
 * @author wqs
 * @version 1.0
 */
public interface IWithdrawManager 
{
	/*
	 * @methodName save
	 * @functionn ����������Ϣ
	 * @param WithdrawManager ����ʵ��
	 * @return void 
	 */
	public void saveWithdraw(WithdrawManager withdraw);
	
	/*
	 * @methodName findByCardId
	 * @functionn �������ſ��Ų���������Ϣ
	 * @param id ���ſ���
	 * @return List ����ʵ�弯��
	 */
	public List findByCardNo(String id);
	
	/*
	 * @methodName findByBillTime
	 * @functionn �����˵��ڲ���������Ϣ
	 * @param id ���ſ���
	 * @return List ����ʵ�弯��
	 */
	public List findByBillTime(String date);
}

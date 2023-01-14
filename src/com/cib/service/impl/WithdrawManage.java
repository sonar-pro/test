package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.WithDrawDAO;
import com.cib.model.WithdrawManager;
import com.cib.service.IWithdrawManager;

/**
 * @className WithdrawManager
 * @function ����ҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class WithdrawManage implements IWithdrawManager
{
	private WithDrawDAO withdrawDAO;
	
	/*
	 * @methodName save
	 * @functionn ����������Ϣ
	 * @param WithdrawManager ����ʵ��
	 * @return void 
	 */
	public void saveWithdraw(WithdrawManager withdraw)
	{
		withdrawDAO.save(withdraw);
	}
	
	/*
	 * @methodName findByCardId
	 * @functionn �������ſ��Ų���������Ϣ
	 * @param id ���ſ���
	 * @return List ����ʵ�弯��
	 */
	public List findByCardNo(String id) 
	{
		return withdrawDAO.findByCardId(id);
	}
	
	/*
	 * @methodName findByBillTime
	 * @functionn �����˵��ڲ���������Ϣ
	 * @param id ���ſ���
	 * @return List ����ʵ�弯��
	 */
	public List findByBillTime(String date) 
	{
		return withdrawDAO.findByBillDate(date);
	}

	public WithDrawDAO getWithdrawDAO() {
		return withdrawDAO;
	}

	public void setWithdrawDAO(WithDrawDAO withdrawDAO) {
		this.withdrawDAO = withdrawDAO;
	}
}

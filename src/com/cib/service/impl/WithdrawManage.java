package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.WithDrawDAO;
import com.cib.model.WithdrawManager;
import com.cib.service.IWithdrawManager;

/**
 * @className WithdrawManager
 * @function 退信业务实现类
 * @author wqs
 * @version 1.0
 */
public class WithdrawManage implements IWithdrawManager
{
	private WithDrawDAO withdrawDAO;
	
	/*
	 * @methodName save
	 * @functionn 保存退信信息
	 * @param WithdrawManager 退信实体
	 * @return void 
	 */
	public void saveWithdraw(WithdrawManager withdraw)
	{
		withdrawDAO.save(withdraw);
	}
	
	/*
	 * @methodName findByCardId
	 * @functionn 根据退信卡号查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
	 */
	public List findByCardNo(String id) 
	{
		return withdrawDAO.findByCardId(id);
	}
	
	/*
	 * @methodName findByBillTime
	 * @functionn 根据账单期查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
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

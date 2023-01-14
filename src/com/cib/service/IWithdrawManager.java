package com.cib.service;

import java.util.List;

import com.cib.model.WithdrawManager;

/**
 * @interface IWithdrawManager
 * @function 退信业务接口
 * @author wqs
 * @version 1.0
 */
public interface IWithdrawManager 
{
	/*
	 * @methodName save
	 * @functionn 保存退信信息
	 * @param WithdrawManager 退信实体
	 * @return void 
	 */
	public void saveWithdraw(WithdrawManager withdraw);
	
	/*
	 * @methodName findByCardId
	 * @functionn 根据退信卡号查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
	 */
	public List findByCardNo(String id);
	
	/*
	 * @methodName findByBillTime
	 * @functionn 根据账单期查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
	 */
	public List findByBillTime(String date);
}

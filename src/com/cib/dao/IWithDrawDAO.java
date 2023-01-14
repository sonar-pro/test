package com.cib.dao;

import java.util.List;

import com.cib.model.WithdrawManager;

/**
 * @interface IWithDrawDAO
 * @function 退信ＤＡＯ接口
 * @author wqs
 * @version 1.0
 */
public interface IWithDrawDAO 
{
	/*
	 * @methodName save
	 * @functionn 保存退信信息
	 * @param WithdrawManager 退信实体
	 * @return void 
	 */
	public void save(WithdrawManager withdraw);
	
	/*
	 * @methodName findByCardId
	 * @functionn 根据退信卡号查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
	 */
	public List findByCardId(String id);
	
	/*
	 * @methodName findByCardId
	 * @functionn 根据账单期查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
	 */
	public List findByBillDate(String date);
}

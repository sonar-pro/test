package com.cib.service;

import java.util.List;

import com.cib.model.TmpMsg;


/**
 * @className ITmpmgManager
 * @function 模板管理业务接口
 * @author wqs
 * @version 1.0
 */
public interface ITmpmgManager 
{
	/*
	 * @method saveTmpMg
	 * @function 保存实体对象
	 * @return void
	 */
	public void saveTmpMg(TmpMsg tmpmg);
	
	/*
	 * @method deleteTmpMg
	 * @function 删除实体对象
	 * @return void
	 */
	public void deleteTmpMg(TmpMsg tmpmg);
	
	/*
	 * @method findAllTmpMg
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAllTmpMg();
	
	/*
	 * @method findByIdTmpMg
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 模板管理实体对象
	 */
	public TmpMsg findByIdTmpMg(java.lang.Long id);
}

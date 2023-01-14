package com.cib.dao;

import java.util.List;

import com.cib.model.PrintRule;


public interface IPrintRuleDAO 
{
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void save(PrintRule printRule);
	
	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void delete(PrintRule printRule);
	
	/*
	 * @method findAll
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAll();
	
	/*
	 * @method findById
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 模板管理实体对象
	 */
	public PrintRule findById(java.lang.Long id);
	
	/*
	 * @method findAllTempletId
	 * @function 获取模板编号列表
	 * @return List 模板编号集合
	 */
	public List findAllTempletId();
	
	/*
	 * @method findBytempletName
	 * @function 根据模板编号获取模板名称
	 * @return List 模板名称集合
	 */
	public List findBytempletName(Long id);
	
	/*
	 * @method findByProductId
	 * @function 根据模板编号获取产品代码
	 * @return List 产品代码集合
	 */
	public List findByProductId(Long id);
	
	/*
	 * @method findAllActiveId
	 * @function 获取活动编号列表
	 * @return List 活动编号集合
	 */
	public List findAllActiveId();
	
	/*
	 * @method findActiveName
	 * @function 根据活动编号获取活动名称
	 * @return List 活动名称集合
	 */
	public List findActiveName(Long id);
	
}

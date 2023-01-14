package com.cib.service;

import java.util.List;

import com.cib.model.PrintRule;

/**
 * @className IPrintRuleManager
 * @function 打印规则管理业务接口
 * @author wqs
 * @version 1.0
 */
public interface IPrintRuleManager 
{
	/*
	 * @function 保存实体对象
	 * @return void
	 */
	public void savePrintRule(PrintRule printRule);
	
	/*
	 * @function 删除实体对象
	 * @return void
	 */
	public void deletePrintRule(PrintRule printRule);
	
	/*
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List findAllPrintRule();
	
	/*
	 * @function 根据实体的id，获取该实体
	 * @return TmpMg 打印规则管理实体对象
	 */
	public PrintRule findByIdPrintRule(java.lang.Long id);
	
	/*
	 * @method findAllTempletId
	 * @function 获取模板编号列表
	 * @return List 模板编号集合
	 */
	public List findAllTemplet();
	
	/*
	 * @method findBytemplet
	 * @function 根据模板编号获取模板名称
	 * @return List 模板名称集合
	 */
	public List findBytemplet(Long id);
	
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
	public List findAllActive();
	
	/*
	 * @method findActive
	 * @function 根据活动编号获取活动名称
	 * @return List 活动名称集合
	 */
	public List findActive(Long id);
}

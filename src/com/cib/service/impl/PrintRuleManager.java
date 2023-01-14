package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.PrintRuleDAO;
import com.cib.model.PrintRule;
import com.cib.service.IPrintRuleManager;

/**
 * @className PrintRuleManager
 * @function 打印规则业务实现类
 * @author wqs
 * @version 1.0
 */
public class PrintRuleManager implements IPrintRuleManager
{
	private PrintRuleDAO printRuleDAO;
	
	/*
	 * @function 删除打印规则
	 * @param printRule 打印规则实体
	 * @return void
	 */
	public void deletePrintRule(PrintRule printRule) 
	{
		printRuleDAO.delete(printRule);
	}

	/*
	 * @function 查询打印规则
	 * @param printRule 打印规则实体
	 * @return void
	 */
	public List findAllPrintRule()
	{
		return printRuleDAO.findAll();
	}

	/*
	 * @function 根据打印规则编号获取打印规则
	 * @param id 打印规则编号
	 * @return printRule 打印规则实体
	 */
	public PrintRule findByIdPrintRule(java.lang.Long id) 
	{
		return printRuleDAO.findById(id);
	}

	/*
	 * @function 保存打印规则
	 * @param printRule 打印规则实体
	 * @return void
	 */
	public void savePrintRule(PrintRule printRule) 
	{
		printRuleDAO.save(printRule);
	}

	/*
	 * @method findAllTempletId
	 * @function 获取模板编号列表
	 * @return List 模板编号集合
	 */
	public List findAllTemplet() 
	{
		return printRuleDAO.findAllTempletId();
	}
	
	/*
	 * @method findBytemplet
	 * @function 根据模板编号获取模板名称
	 * @return List 模板名称集合
	 */
	public List findBytemplet(Long id) 
	{
		return printRuleDAO.findBytempletName(id);
	}
	
	/*
	 * @method findByProductId
	 * @function 根据模板编号获取产品代码
	 * @return List 产品代码集合
	 */
	public List findByProductId(Long id) 
	{
		return printRuleDAO.findByProductId(id);
	}
	
	/*
	 * @method findAllActiveId
	 * @function 获取活动编号列表
	 * @return List 活动编号集合
	 */
	public List findAllActive() 
	{
		return printRuleDAO.findAllActiveId();
	}
	
	/*
	 * @method findActive
	 * @function 根据活动编号获取活动名称
	 * @return List 活动名称集合
	 */
	public List findActive(Long id) 
	{
		return printRuleDAO.findActiveName(id);
	}
	
	public PrintRuleDAO getPrintRuleDAO() {
		return printRuleDAO;
	}

	public void setPrintRuleDAO(PrintRuleDAO printRuleDAO) {
		this.printRuleDAO = printRuleDAO;
	}
}

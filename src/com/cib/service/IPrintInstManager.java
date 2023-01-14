package com.cib.service;

import java.util.List;

import com.cib.model.PrintInstitution;

/**
 * @interface IPrintInstManager
 * @function 打印服务商业务接口
 * @author wqs
 * @version 1.0
 */
public interface IPrintInstManager 
{
	/*
	 * @function 保存打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return void
	 */
	public void savePrintInst(PrintInstitution printInst);
	
	/*
	 * @function 删除打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return void
	 */
	public void deletePrintInst(PrintInstitution printInst);
	
	/*
	 * @function 获取打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return List 打印服务商集合
	 */
	public List findAllPrintInst();
	
	/*
	 * @function 查找打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return void
	 */
	public PrintInstitution findByIdPrintInst(java.lang.Long id);
}

package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.PrintInstDAO;
import com.cib.model.PrintInstitution;
import com.cib.service.IPrintInstManager;

/**
 * @className PrintInstManager
 * @function 打印服务商业务实现类
 * @author wqs
 * @version 1.0
 */
public class PrintInstManager implements IPrintInstManager
{
	private PrintInstDAO printInstDAO;
	
	/*
	 * @function 删除打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return void
	 */
	public void deletePrintInst(PrintInstitution printInst) 
	{
		printInstDAO.delete(printInst);
	}

	/*
	 * @function 获取打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return List 打印服务商集合
	 */
	public List findAllPrintInst() {
		return printInstDAO.findAll();
	}

	/*
	 * @function 查找打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return void
	 */
	public PrintInstitution findByIdPrintInst(Long id) {
		return printInstDAO.findById(id);
	}

	/*
	 * @function 保存打印服务商信息
	 * @param PrintInstitution 打印服务商实体
	 * @return void
	 */
	public void savePrintInst(PrintInstitution printInst) {
		printInstDAO.save(printInst);
		
	}

	public PrintInstDAO getPrintInstDAO() {
		return printInstDAO;
	}

	public void setPrintInstDAO(PrintInstDAO printInstDAO) {
		this.printInstDAO = printInstDAO;
	}

}

package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.PrintInstDAO;
import com.cib.model.PrintInstitution;
import com.cib.service.IPrintInstManager;

/**
 * @className PrintInstManager
 * @function ��ӡ������ҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class PrintInstManager implements IPrintInstManager
{
	private PrintInstDAO printInstDAO;
	
	/*
	 * @function ɾ����ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
	 * @return void
	 */
	public void deletePrintInst(PrintInstitution printInst) 
	{
		printInstDAO.delete(printInst);
	}

	/*
	 * @function ��ȡ��ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
	 * @return List ��ӡ�����̼���
	 */
	public List findAllPrintInst() {
		return printInstDAO.findAll();
	}

	/*
	 * @function ���Ҵ�ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
	 * @return void
	 */
	public PrintInstitution findByIdPrintInst(Long id) {
		return printInstDAO.findById(id);
	}

	/*
	 * @function �����ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
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

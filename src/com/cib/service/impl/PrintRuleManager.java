package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.PrintRuleDAO;
import com.cib.model.PrintRule;
import com.cib.service.IPrintRuleManager;

/**
 * @className PrintRuleManager
 * @function ��ӡ����ҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class PrintRuleManager implements IPrintRuleManager
{
	private PrintRuleDAO printRuleDAO;
	
	/*
	 * @function ɾ����ӡ����
	 * @param printRule ��ӡ����ʵ��
	 * @return void
	 */
	public void deletePrintRule(PrintRule printRule) 
	{
		printRuleDAO.delete(printRule);
	}

	/*
	 * @function ��ѯ��ӡ����
	 * @param printRule ��ӡ����ʵ��
	 * @return void
	 */
	public List findAllPrintRule()
	{
		return printRuleDAO.findAll();
	}

	/*
	 * @function ���ݴ�ӡ�����Ż�ȡ��ӡ����
	 * @param id ��ӡ������
	 * @return printRule ��ӡ����ʵ��
	 */
	public PrintRule findByIdPrintRule(java.lang.Long id) 
	{
		return printRuleDAO.findById(id);
	}

	/*
	 * @function �����ӡ����
	 * @param printRule ��ӡ����ʵ��
	 * @return void
	 */
	public void savePrintRule(PrintRule printRule) 
	{
		printRuleDAO.save(printRule);
	}

	/*
	 * @method findAllTempletId
	 * @function ��ȡģ�����б�
	 * @return List ģ���ż���
	 */
	public List findAllTemplet() 
	{
		return printRuleDAO.findAllTempletId();
	}
	
	/*
	 * @method findBytemplet
	 * @function ����ģ���Ż�ȡģ������
	 * @return List ģ�����Ƽ���
	 */
	public List findBytemplet(Long id) 
	{
		return printRuleDAO.findBytempletName(id);
	}
	
	/*
	 * @method findByProductId
	 * @function ����ģ���Ż�ȡ��Ʒ����
	 * @return List ��Ʒ���뼯��
	 */
	public List findByProductId(Long id) 
	{
		return printRuleDAO.findByProductId(id);
	}
	
	/*
	 * @method findAllActiveId
	 * @function ��ȡ�����б�
	 * @return List ���ż���
	 */
	public List findAllActive() 
	{
		return printRuleDAO.findAllActiveId();
	}
	
	/*
	 * @method findActive
	 * @function ���ݻ��Ż�ȡ�����
	 * @return List ����Ƽ���
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

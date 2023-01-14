package com.cib.service;

import java.util.List;

import com.cib.model.PrintInstitution;

/**
 * @interface IPrintInstManager
 * @function ��ӡ������ҵ��ӿ�
 * @author wqs
 * @version 1.0
 */
public interface IPrintInstManager 
{
	/*
	 * @function �����ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
	 * @return void
	 */
	public void savePrintInst(PrintInstitution printInst);
	
	/*
	 * @function ɾ����ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
	 * @return void
	 */
	public void deletePrintInst(PrintInstitution printInst);
	
	/*
	 * @function ��ȡ��ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
	 * @return List ��ӡ�����̼���
	 */
	public List findAllPrintInst();
	
	/*
	 * @function ���Ҵ�ӡ��������Ϣ
	 * @param PrintInstitution ��ӡ������ʵ��
	 * @return void
	 */
	public PrintInstitution findByIdPrintInst(java.lang.Long id);
}

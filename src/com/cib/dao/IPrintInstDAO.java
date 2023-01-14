package com.cib.dao;

import java.util.List;

import com.cib.model.PrintInstitution;

/**
 * @interface IPrintInstDAO
 * @function ģ�����DAO�ӿ�
 * @version 1.0
 * @author wqs
 */
public interface IPrintInstDAO 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(PrintInstitution printInst);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(PrintInstitution printInst);
	
	/*
	 * @method findAll
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAll();
	
	/*
	 * @method findById
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public PrintInstitution findById(java.lang.Long id);
}

package com.cib.dao;

import java.util.List;

import com.cib.model.TmpMsg;

/**
 * @interface ITmpMgDAO
 * @function ģ�����DAO�ӿ�
 * @version 1.0
 * @author wqs
 */
public interface ITmpMgDAO 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(TmpMsg tmpmg);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(TmpMsg tmpmg);
	
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
	public TmpMsg findById(java.lang.Long id);
}

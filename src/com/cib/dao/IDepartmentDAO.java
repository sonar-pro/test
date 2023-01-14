package com.cib.dao;

import java.util.List;

import com.cib.model.DepartmentMg;


/**
 * @interface IDepartmentMg
 * @function ���Ź���DAO�ӿ�
 * @version 1.0
 * @author wqs
 */
public interface IDepartmentDAO 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(DepartmentMg dept);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(DepartmentMg dept);
	
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
	public DepartmentMg findById(java.lang.Long id);
}

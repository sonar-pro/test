package com.cib.service;

import java.util.List;

import com.cib.model.DepartmentMg;


/**
 * @className IDepartmentManager
 * @function ���Ź���ҵ��ӿ�
 * @author wqs
 * @version 1.0
 */
public interface IDepartmentManager 
{
	/*
	 * @method saveDept
	 * @function ����ʵ�����
	 * @return void
	 */
	public void saveDept(DepartmentMg dept);
	
	/*
	 * @method deleteDept
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void deleteDept(DepartmentMg dept);
	
	/*
	 * @method findAllDept
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAllDept();
	
	/*
	 * @method DepartmentMg
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public DepartmentMg findByIdDept(java.lang.Long id);
}

package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.DepartmentDAO;
import com.cib.model.DepartmentMg;
import com.cib.service.IDepartmentManager;

/**
 * @function ���Ź���ҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class DepartmentManager implements IDepartmentManager
{
	private DepartmentDAO deptDAO;
	
	/*
	 * @function ɾ������
	 * @param DepartmentMg ���Ź���ʵ��
	 * @return void
	 */
	public void deleteDept(DepartmentMg dept) 
	{
		deptDAO.delete(dept);
	}

	/*
	 * @function ��ѯ����
	 * @param DepartmentMg ����ʵ��
	 * @return void
	 */
	public List findAllDept()
	{
		return deptDAO.findAll();
	}

	/*
	 * @function ����ģ���Ż�ȡģ��
	 * @param id ���ű��
	 * @return DepartmentMg ���Ź���ʵ��
	 */
	public DepartmentMg findByIdDept(java.lang.Long id) 
	{
		return deptDAO.findById(id);
	}

	/*
	 * @function ���沿��
	 * @param DepartmentMg ����ʵ��
	 * @return void
	 */
	public void saveDept(DepartmentMg dept) 
	{
		deptDAO.save(dept);
	}

	public DepartmentDAO getDeptDAO() {
		return deptDAO;
	}

	public void setDeptDAO(DepartmentDAO deptDAO) {
		this.deptDAO = deptDAO;
	}

	
}

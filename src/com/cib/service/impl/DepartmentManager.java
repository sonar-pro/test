package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.DepartmentDAO;
import com.cib.model.DepartmentMg;
import com.cib.service.IDepartmentManager;

/**
 * @function 部门管理业务实现类
 * @author wqs
 * @version 1.0
 */
public class DepartmentManager implements IDepartmentManager
{
	private DepartmentDAO deptDAO;
	
	/*
	 * @function 删除部门
	 * @param DepartmentMg 部门管理实体
	 * @return void
	 */
	public void deleteDept(DepartmentMg dept) 
	{
		deptDAO.delete(dept);
	}

	/*
	 * @function 查询部门
	 * @param DepartmentMg 部门实体
	 * @return void
	 */
	public List findAllDept()
	{
		return deptDAO.findAll();
	}

	/*
	 * @function 根据模板编号获取模板
	 * @param id 部门编号
	 * @return DepartmentMg 部门管理实体
	 */
	public DepartmentMg findByIdDept(java.lang.Long id) 
	{
		return deptDAO.findById(id);
	}

	/*
	 * @function 保存部门
	 * @param DepartmentMg 部门实体
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

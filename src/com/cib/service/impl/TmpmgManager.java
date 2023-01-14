package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.TmpMgDAO;
import com.cib.model.TmpMsg;
import com.cib.service.ITmpmgManager;

/**
 * @function 模板业务实现类
 * @author wqs
 * @version 1.0
 */
public class TmpmgManager implements ITmpmgManager
{
	private TmpMgDAO tmpMgDAO;
	
	/*
	 * @function 删除模板
	 * @param tmpmg 模板实体
	 * @return void
	 */
	public void deleteTmpMg(TmpMsg tmpmg) 
	{
		tmpMgDAO.delete(tmpmg);
	}

	/*
	 * @function 查询模板
	 * @param tmpmg 模板实体
	 * @return void
	 */
	public List findAllTmpMg()
	{
		return tmpMgDAO.findAll();
	}

	/*
	 * @function 根据模板编号获取模板
	 * @param id 模板编号
	 * @return TmpMg 模板实体
	 */
	public TmpMsg findByIdTmpMg(java.lang.Long id) 
	{
		return tmpMgDAO.findById(id);
	}

	/*
	 * @function 保存模板
	 * @param tmpmg 模板实体
	 * @return void
	 */
	public void saveTmpMg(TmpMsg tmpmg) 
	{
		tmpMgDAO.save(tmpmg);
	}

	public TmpMgDAO getTmpMgDAO() {
		return tmpMgDAO;
	}

	public void setTmpMgDAO(TmpMgDAO tmpMgDAO) {
		this.tmpMgDAO = tmpMgDAO;
	}

}

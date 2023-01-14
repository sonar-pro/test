package com.cib.service.impl;

import java.util.List;

import com.cib.dao.hibernate.TmpMgDAO;
import com.cib.model.TmpMsg;
import com.cib.service.ITmpmgManager;

/**
 * @function ģ��ҵ��ʵ����
 * @author wqs
 * @version 1.0
 */
public class TmpmgManager implements ITmpmgManager
{
	private TmpMgDAO tmpMgDAO;
	
	/*
	 * @function ɾ��ģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public void deleteTmpMg(TmpMsg tmpmg) 
	{
		tmpMgDAO.delete(tmpmg);
	}

	/*
	 * @function ��ѯģ��
	 * @param tmpmg ģ��ʵ��
	 * @return void
	 */
	public List findAllTmpMg()
	{
		return tmpMgDAO.findAll();
	}

	/*
	 * @function ����ģ���Ż�ȡģ��
	 * @param id ģ����
	 * @return TmpMg ģ��ʵ��
	 */
	public TmpMsg findByIdTmpMg(java.lang.Long id) 
	{
		return tmpMgDAO.findById(id);
	}

	/*
	 * @function ����ģ��
	 * @param tmpmg ģ��ʵ��
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

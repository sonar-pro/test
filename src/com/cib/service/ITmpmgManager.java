package com.cib.service;

import java.util.List;

import com.cib.model.TmpMsg;


/**
 * @className ITmpmgManager
 * @function ģ�����ҵ��ӿ�
 * @author wqs
 * @version 1.0
 */
public interface ITmpmgManager 
{
	/*
	 * @method saveTmpMg
	 * @function ����ʵ�����
	 * @return void
	 */
	public void saveTmpMg(TmpMsg tmpmg);
	
	/*
	 * @method deleteTmpMg
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void deleteTmpMg(TmpMsg tmpmg);
	
	/*
	 * @method findAllTmpMg
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAllTmpMg();
	
	/*
	 * @method findByIdTmpMg
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ģ�����ʵ�����
	 */
	public TmpMsg findByIdTmpMg(java.lang.Long id);
}

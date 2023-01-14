package com.cib.dao;

import java.util.List;

import com.cib.model.PrintRule;


public interface IPrintRuleDAO 
{
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(PrintRule printRule);
	
	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(PrintRule printRule);
	
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
	public PrintRule findById(java.lang.Long id);
	
	/*
	 * @method findAllTempletId
	 * @function ��ȡģ�����б�
	 * @return List ģ���ż���
	 */
	public List findAllTempletId();
	
	/*
	 * @method findBytempletName
	 * @function ����ģ���Ż�ȡģ������
	 * @return List ģ�����Ƽ���
	 */
	public List findBytempletName(Long id);
	
	/*
	 * @method findByProductId
	 * @function ����ģ���Ż�ȡ��Ʒ����
	 * @return List ��Ʒ���뼯��
	 */
	public List findByProductId(Long id);
	
	/*
	 * @method findAllActiveId
	 * @function ��ȡ�����б�
	 * @return List ���ż���
	 */
	public List findAllActiveId();
	
	/*
	 * @method findActiveName
	 * @function ���ݻ��Ż�ȡ�����
	 * @return List ����Ƽ���
	 */
	public List findActiveName(Long id);
	
}

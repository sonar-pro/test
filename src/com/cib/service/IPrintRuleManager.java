package com.cib.service;

import java.util.List;

import com.cib.model.PrintRule;

/**
 * @className IPrintRuleManager
 * @function ��ӡ�������ҵ��ӿ�
 * @author wqs
 * @version 1.0
 */
public interface IPrintRuleManager 
{
	/*
	 * @function ����ʵ�����
	 * @return void
	 */
	public void savePrintRule(PrintRule printRule);
	
	/*
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void deletePrintRule(PrintRule printRule);
	
	/*
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List findAllPrintRule();
	
	/*
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return TmpMg ��ӡ�������ʵ�����
	 */
	public PrintRule findByIdPrintRule(java.lang.Long id);
	
	/*
	 * @method findAllTempletId
	 * @function ��ȡģ�����б�
	 * @return List ģ���ż���
	 */
	public List findAllTemplet();
	
	/*
	 * @method findBytemplet
	 * @function ����ģ���Ż�ȡģ������
	 * @return List ģ�����Ƽ���
	 */
	public List findBytemplet(Long id);
	
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
	public List findAllActive();
	
	/*
	 * @method findActive
	 * @function ���ݻ��Ż�ȡ�����
	 * @return List ����Ƽ���
	 */
	public List findActive(Long id);
}

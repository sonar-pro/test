package com.cib.dao;

import java.util.List;
import java.io.Serializable;

/**
 * @interface DAO
 * @function ���ϲ�DAO�ӿ�,����ģ��DAO���̳д˽ӿڡ�
 * @version 1.0
 * @author wqs
 */
public interface DAO {
	
	/*
	 * @method save
	 * @function ����ʵ�����
	 * @return void
	 */
	public void save(Object object);

	/*
	 * @method delete
	 * @function ɾ��ʵ�����
	 * @return void
	 */
	public void delete(Class clazz, Serializable id);

	/*
	 * @method getObject
	 * @function ����ʵ���id����ȡ��ʵ��
	 * @return Object ʵ�����
	 */
	public Object getObject(Class clazz, Serializable id);

	/*
	 * @method getObject
	 * @function ��ȡʵ���б�
	 * @return List ʵ�弯��
	 */
	public List getObject();
}

package com.cib.dao;

import java.util.List;
import java.io.Serializable;

/**
 * @interface DAO
 * @function 最上层DAO接口,下面模块DAO来继承此接口。
 * @version 1.0
 * @author wqs
 */
public interface DAO {
	
	/*
	 * @method save
	 * @function 保存实体对象
	 * @return void
	 */
	public void save(Object object);

	/*
	 * @method delete
	 * @function 删除实体对象
	 * @return void
	 */
	public void delete(Class clazz, Serializable id);

	/*
	 * @method getObject
	 * @function 根据实体的id，获取该实体
	 * @return Object 实体对象
	 */
	public Object getObject(Class clazz, Serializable id);

	/*
	 * @method getObject
	 * @function 获取实体列表
	 * @return List 实体集合
	 */
	public List getObject();
}

package com.cib.dao;

import java.util.List;

import com.cib.model.TbTest;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ITestDAO {

	/*
	 * @return List<TbTest> 得到分页后的数据
	 * @param int pageSize 每页的记录条敄1�7
	 * @param int pageNumber 页号
	 */
    public List<TbTest> getPage(int pageSize,int pageNumber);
   
    /*
     * @return int 总数据条数数
     */
    public int getPageCount();

}

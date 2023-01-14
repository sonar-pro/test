package com.cib.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cib.dao.ITestDAO;
import com.cib.entity.Page_bak;

import com.cib.model.TbTest;
import com.cib.service.ITestService;

public class TestService implements ITestService {

	public TestService() {}

	private ITestDAO testDao;


	/*
	 * @return List<TbTest> 得到分页后的数据
	 * @param int pageSize 每页的记录条敄1�7
	 * @param int pageNumber 页号
	 */
	@Override
	public List<TbTest> getPage(int pageSize,int pageNumber) {
		
			return testDao.getPage(pageSize, pageNumber);
	}
     
	/*
     * @return int 总数据条数数
     */
	@Override
	public int getPageCount() {
		
		return testDao.getPageCount();
	}

		
	public ITestDAO getTestDao() {
		return testDao;
	}

	public void setTestDao(ITestDAO testDao) {
		this.testDao = testDao;
	}

}

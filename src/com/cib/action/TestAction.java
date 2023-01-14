package com.cib.action;

import java.util.List;

import com.cib.model.TbTest;
import com.cib.service.ITestService;

import com.opensymphony.xwork2.ActionSupport;

import com.cib.entity.Page_bak;

public class TestAction extends ActionSupport {

	private ITestService testService;

	private List<TbTest> testlist;

	private int pageSize = 5;
	private int pageNumber = 0;
	private int pagecount;

	@Override
	public String execute() throws Exception {

		// 得到总页敄1�7
		System.out.println("执行了。。。");
		pagecount = Page_bak.pageCount(pageSize, testService.getPageCount());

		testlist = testService.getPage(pageSize, pageNumber);

		return SUCCESS;
	}

	public ITestService getTestService() {
		return testService;
	}

	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

	public List<TbTest> getTestlist() {
		return testlist;
	}

	public void setTestlist(List<TbTest> testlist) {
		this.testlist = testlist;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPagecount() {
		return pagecount;
	}

	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}

}

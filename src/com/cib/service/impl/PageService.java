package com.cib.service.impl;


import java.util.List;

import com.cib.dao.hibernate.PageDAO;
import com.cib.entity.User;

import com.cib.service.IPageService;


public class PageService implements IPageService {

	private PageDAO pageDAO; //此处属性名为loginDAO

	public PageDAO getPageDAO() {
		return pageDAO;
	}

	public void setPageDAO(PageDAO pageDAO) {
		this.pageDAO = pageDAO;
	}

	@Override
	public void insertUser() {
		pageDAO.insertUser();
		
	}

	@Override
	public List<User> pageUser(int pageNow, int pageSize) {
		return pageDAO.pageUser(pageNow, pageSize);
	}

	@Override
//	public int pageCount(int pageSize) {
//		
//		return userPageDAO.pageCount(pageSize);
//	}
	public int totalCount() {
		
		return pageDAO.totalCount();
	}


}

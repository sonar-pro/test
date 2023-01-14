package com.cib.service.impl;


import java.util.List;

import com.cib.dao.hibernate.ExamineeDAO;

import com.cib.entity.Examinee;
import com.cib.entity.Page;

import com.cib.service.IExamineeService;


public class ExamineeService implements IExamineeService {

	private ExamineeDAO examineeDAO; //此处属性名为loginDAO

    public ExamineeDAO getExamineeDAO() {
		return examineeDAO;
	}

	public void setExamineeDAO(ExamineeDAO examineeDAO) {
		this.examineeDAO = examineeDAO;
	}

	//后台对页数的处理   
	public Page total(){  
	    Page page = examineeDAO.total();  
	    return page;  
	      
	}  
	  
	//后台分页的设置   
	public Page firstPage(Page page) {  
	    page = examineeDAO.firstPage(page);  
	    return page;  
	}  
	public List<Examinee> queryByPage(Page page) {  
	    List<Examinee> examinees = examineeDAO.list(page);  
	    return examinees;  
	}  
	  
	public Page lastPage(Page page) {  
	    page = examineeDAO.lastPage(page);  
	    return page;  
	}  


}

package com.cib.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cib.entity.Examinee;
import com.cib.entity.Page;
import com.cib.model.TbTest;

public interface IExamineeService {

        //后台对页数的处理   
    public Page total(); 
      
    //后台分页的设置   
    public Page firstPage(Page page) ;  
    public List<Examinee> queryByPage(Page page); 
      
    public Page lastPage(Page page);
	

}

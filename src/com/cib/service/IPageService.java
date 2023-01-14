package com.cib.service;

import java.util.List;
import com.cib.entity.User;


public interface IPageService {

        //后台对页数的处理   
	public void insertUser() ;
    
    public List<User> pageUser(int pageNow,int pageSize);
    
    //public int pageCount(int pageSize);
    public int totalCount();
}

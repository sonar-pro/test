package com.cib.service;

import java.util.List;
import com.cib.entity.User;


public interface IPageService {

        //��̨��ҳ���Ĵ���   
	public void insertUser() ;
    
    public List<User> pageUser(int pageNow,int pageSize);
    
    //public int pageCount(int pageSize);
    public int totalCount();
}

package com.cib.dao;

import java.util.List;
import com.cib.entity.User;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IPageDAO {

	 //��̨��ҳ���Ĵ���   
	public void insertUser() ;
    
    public List<User> pageUser(int pageNow,int pageSize);
    
    //public int pageCount(int pageSize);
    public int totalCount();
	      

}

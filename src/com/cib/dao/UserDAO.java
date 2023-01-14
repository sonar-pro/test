package com.cib.dao;

import java.util.List;

//import com.cib.entity.page.Page;
import com.cib.entity.User;

public interface UserDAO {
	
	/**
	 * ����û��Ƿ����
	 * */
	public User getUserByUserIdAndUserNameExits(User user);
	public void saveUser(User user);
	public void updateUser(User user);
	public User getUser(User user);
	public void delUser(User user);	
	public List<User> finUserAll();		
	
	public Long getUserCount();  //�������ݵ�����   
	//public List<User> getUserListByPage(Page page);    
	
	//��ѯ�������ݵ�����   
	public Long getUserCount(String querySql);  //
	
}

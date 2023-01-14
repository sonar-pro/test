package com.cib.service;

import java.util.List;

import com.cib.entity.User;

public interface UserService {
	
	public User checkUserExits(User user);	
	public void addUser(User user);
	public void editUser(User user);
	public void delUser(User user);
	public List<User> getUserList();
	public User getUserByUid(User user);
	
	//public List<User> getUserListByPage(Page page);   
	public Long getUserCount();	
	public Long getUserCount(String querySql);
	
}

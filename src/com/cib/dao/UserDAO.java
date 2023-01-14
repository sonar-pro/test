package com.cib.dao;

import java.util.List;

//import com.cib.entity.page.Page;
import com.cib.entity.User;

public interface UserDAO {
	
	/**
	 * 检查用户是否存在
	 * */
	public User getUserByUserIdAndUserNameExits(User user);
	public void saveUser(User user);
	public void updateUser(User user);
	public User getUser(User user);
	public void delUser(User user);	
	public List<User> finUserAll();		
	
	public Long getUserCount();  //返回数据的总数   
	//public List<User> getUserListByPage(Page page);    
	
	//查询返回数据的总数   
	public Long getUserCount(String querySql);  //
	
}

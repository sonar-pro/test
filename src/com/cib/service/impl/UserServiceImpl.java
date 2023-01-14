package com.cib.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cib.dao.UserDAO;
import com.cib.entity.User;
import com.cib.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService {

	private UserDAO userDao = null;

	public UserDAO getUserDao() {
		return userDao;
	}

	@Resource
	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	public User checkUserExits(User user){
		return this.userDao.getUserByUserIdAndUserNameExits(user);
	}

	public void delUser(User user) {
		this.userDao.delUser(user);
	}

	public User getUserByUid(User user) {
		return this.userDao.getUser(user);
	}

	public List<User> getUserList() {
		return this.userDao.finUserAll();
	}

	public void addUser(User user) {				
		this.userDao.saveUser(user);
	}

	public void editUser(User user) {
		this.userDao.updateUser(user);
	}
	

	//public List<User> getUserListByPage(Page page) {			
	//	return  this.userDao.getUserListByPage(page);
	//}

	
	public Long getUserCount() {		
		return this.userDao.getUserCount();		
	}
	
	public Long getUserCount(String querySql) {		
		return this.userDao.getUserCount(querySql);		
	}
	
}

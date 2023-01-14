package com.cib.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

import com.cib.entity.User;
import com.cib.constant.Constant;

/**
 * [监听]用户登录管理  
 * 一个用户名只允许登录一次
 * 一台电脑只允许一个用户登录
 * 在一台已经有用户登录的电脑上再次登录，则踢掉原来已经登录的用户
 * 流程：
 *      1.判断同一机器是否为二次登录
 *         1.1 是：跳转2
 *         1.2 否：跳转3
 *      2.判断用户是否为本机用户
 *         2.1 是：踢除本机已经登录用户 4
 *         2.2 否：跳转3
 *      3.判断用户是否为二次登录
 *         3.1 是：跳转 5
 *         3.2。1 否：踢除本机已经登录用户 4
 *         3.2。2 否： 4  (从1.2跳转过来的，就不需要剔除用户)
 *      4.校验
 * 
 */
public class OnlineUsers implements HttpSessionBindingListener {
	private HashMap<User, HttpSession> users = new HashMap<User, HttpSession>();
	private static OnlineUsers onlineUsers = new OnlineUsers();
	//private static OnlineUsers onlineUsers = null;

	/**
	 * 取得对象实例
	 * 
	 * @return OnlineUsers
	 */
	public static OnlineUsers getInstance() {
		return onlineUsers;
	}
	//public synchronized static OnlineUsers getInstance() {
	//	if (null == onlineUsers) {
	//		onlineUsers = new OnlineUsers();
	//	}
	//	return onlineUsers;
	//}

	/**
	 * 取得有用户列表
	 * 
	 * @return
	 */
	public HashMap<User, HttpSession> getUsers() {
		return users;

	}

	/**
	 * 用户列表中添加登录用户
	 * 
	 * @param session
	 *            HttpSession
	 * @param userName
	 *            String
	 */
	public void addUser(HttpSession session, User user) {
		try {
			users.put(user, session);
			System.out.println("-=====================user " + user.getUsername() + " logined------------");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 通过用户名踢出用户
	 * 
	 * @param userName
	 *            String
	 * @param stopSession
	 *            boolean
	 */
	public void removeUser(String userName, boolean stopSession) {
		try {

			Iterator<User> ite = users.keySet().iterator();
			User removeUser = null;
			while (ite.hasNext()) {
				User temp = ite.next();
				if (temp.getUsername().equals(userName)) {
					HttpSession value = users.get(temp);
					value.invalidate();
					removeUser = temp;
					break;
				}
			}
			if (null != removeUser) {
				users.remove(removeUser);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 通过session踢出用户
	 * 
	 * @param session
	 *            HttpSession
	 * @param stopSession
	 *            boolean
	 */
	public void removeUser(HttpSession session, boolean stopSession) {
		try {
			Iterator<User> ite = users.keySet().iterator();
			User removeUser = null;
			while (ite.hasNext()) {
				User temp = ite.next();
				HttpSession value = users.get(temp);
				if (value.equals(session)) {
					value.invalidate();
					removeUser = temp;
					break;
				}
			}

			if (null != removeUser) {
				users.remove(removeUser);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	/**
	 * @功能描述:判断本机是否有用户登陆
	 * @param localIP
	 * @return
	 * @创建时间 2008-7-15
	 * @author Administrator
	 */
	public boolean hasLocalUser(String localIP) {
		try {
			Iterator<User> ite = users.keySet().iterator();
			while (ite.hasNext()) {
				User temp = ite.next();
				HttpSession value = users.get(temp);
				String ip = (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
				if (ip.equals(localIP)) {
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	/**
	 * @功能描述:取得该用户名的登陆IP
	 * @param localIP
	 * @return
	 * @创建时间 2008-7-15
	 * @author Administrator
	 */
	public String getUserLoginIp(String username) {
		try {
			Iterator<User> ite = users.keySet().iterator();
			while (ite.hasNext()) {
				User temp = ite.next();
				if (temp.getUsername().equals(username)) {
					HttpSession value = users.get(temp);
					return (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断用户是否为本机用户
	 * 
	 * @param userName
	 *            String
	 * @param localIP
	 *            String
	 * @return boolean
	 */
	public boolean hasLocalUser(String userName, String localIP) {
		try {
			Iterator<User> ite = users.keySet().iterator();
			while (ite.hasNext()) {
				User temp = ite.next();
				if (temp.getUsername().equals(userName)) {
					HttpSession value = users.get(temp);
					String ip = (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
					if (ip.equals(localIP)) {
						return true;
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 判断用户是否为本机用户
	 * 
	 * @param userName
	 *            String
	 * @param localIP
	 *            String
	 * @return boolean
	 */
	public String getLocalUser(String localIP) {
		try {
			Iterator<User> ite = users.keySet().iterator();
			while (ite.hasNext()) {
				User temp = ite.next();
				HttpSession value = users.get(temp);
				String ip = (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
				if (ip.equals(localIP)) {
					return temp.getUsername();
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	/**
	 * 判断此机是否为2次登录
	 * 
	 * @param loginname
	 *            String
	 * @param session
	 *            HttpSession
	 * @return int
	 */
	public boolean hostOnline(HttpServletRequest request) {
		String localIP = request.getRemoteAddr();// 获取本机ip
		try {
			Iterator<User> ite = users.keySet().iterator();
			while (ite.hasNext()) {
				User temp = ite.next();
				HttpSession value = users.get(temp);
				String ip = (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
				if (ip.equals(localIP)) {
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return false;
	}

	/**
	 * 剔除本机已经登录用户
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param loginname
	 *            String
	 */

	public void kickLocalUser(HttpServletRequest request, String loginname) {
		String localIP = request.getRemoteAddr();// 获取本机ip
		try {
			try {
				User removeUser = null;
				Iterator<User> ite = users.keySet().iterator();
				while (ite.hasNext()) {
					User temp = ite.next();
					HttpSession value = users.get(temp);
					String ip = (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
					if (ip.equals(localIP) && temp.getUsername().equals(loginname)) {
						System.out.println("剔除登陆IP为" + localIP + " 登录名为 " + loginname + " 的用户(指定用户名)");
						value.invalidate();
						removeUser = temp;
						break;
					}
				}
				if (null != removeUser) {
					users.remove(removeUser);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 踢出本机已登录的未知名用户
	 * 
	 * @param localIp
	 *            String
	 */
	public void kickLocalUserByIp(String localIp) {
		try {
			Iterator<User> ite = users.keySet().iterator();
			User removeUser = null;
			while (ite.hasNext()) {
				User temp = ite.next();
				HttpSession value = users.get(temp);
				String ip = (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
				if (ip.equals(localIp)) {
					System.out.println("剔除登陆IP为" + localIp + " 登录名为 " + temp.getUsername() + " 的用户(未指定用户名)");
					value.invalidate();
					removeUser = temp;
					break;
				}
			}
			/**赵晓峰修改于20100225*/
			if (null != removeUser) {
				users.remove(removeUser);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 根据用户名，判断此用户是否已经登录
	 * 
	 * @param userName
	 *            String
	 * @return boolean
	 */
	public boolean userOnLine(String userName) {
		try {
			Iterator<User> ite = users.keySet().iterator();
			while (ite.hasNext()) {
				User temp = ite.next();
				if (temp.getUsername().equals(userName)) {
					return true;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return false;
	}

	/**
	 * 取得页面刷新许可
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @return boolean
	 */
	public boolean allowRefresh(HttpServletRequest request) {
		boolean result = false;
		try {

			String refresh = (String) request.getParameter("refresh");

			if ((refresh == null && hostOnline(request)) || refresh != null) {
				result = true;
			}

			System.out.println("========================refresh:" + (String) request.getParameter("refresh"));

			// Calendar c = Calendar.getInstance();
			// int maxTime = request.getSession().getMaxInactiveInterval();
			// long lastActiveTime = request.getSession().getLastAccessedTime();
			// long remainTime = c.getTimeInMillis() - lastActiveTime;
			// if(remainTime > maxTime*1000){
			// result = false;
			// }else{
			// result = true;
			// }
			// System.out.println("========remianTime:"+remainTime+"
			// now:"+c.getTimeInMillis());
			// System.out.println("======================maxTime:"+maxTime + "
			// lastActiveTime:"+lastActiveTime);
			// String ip =
			// (String)request.getSession().getAttribute(Constants.ONLINE_USER_RDDR);
			// System.out.println("======================================ip:"+ip);
			// if (ip ==null || hostOnline(request)){
			// result = true;
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return result;
	}

	/**
	 * 监听用户登录
	 * 
	 * @param event
	 *            HttpSessionBindingEvent
	 */
	public void valueBound(HttpSessionBindingEvent event) {
		try {
			HttpSession session = event.getSession();
			/***/
			//ServletContext application = session.getServletContext();
		    // 把用户名放入在线列表
			//HashMap<User, HttpSession> users = (HashMap<User, HttpSession>) application.getAttribute("users");
		    // 第一次使用前，需要初始化
		    //if (users == null) {
		    //	users = new HashMap<User, HttpSession>();
		    //    application.setAttribute("users", users);
		    //}
			/***/
			
			User user = (User) session.getAttribute(Constant.USER_KEY);
			System.out.println("bound user " + user.getUsername());
			addUser(session, user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 监听用户退出
	 * 
	 * @param event
	 *            HttpSessionBindingEvent
	 */
	public void valueUnbound(HttpSessionBindingEvent event) {
		try {
			HttpSession session = event.getSession();
			/***/
			//ServletContext application = session.getServletContext();
			//User user = (User) session.getAttribute(Constants.USER_KEY);
		    // 从在线列表中删除用户名
			//HashMap<User, HttpSession> users = (HashMap<User, HttpSession>) application.getAttribute("users");
			//users.remove(user);
		    /***/
			//session.removeAttribute("submit");
			//System.out.println("remove submit " + session.getAttribute("submit"));
			System.out.println("remove user session " + session.getId());
			removeUser(session, false);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

}

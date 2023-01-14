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
 * [����]�û���¼����  
 * һ���û���ֻ�����¼һ��
 * һ̨����ֻ����һ���û���¼
 * ��һ̨�Ѿ����û���¼�ĵ������ٴε�¼�����ߵ�ԭ���Ѿ���¼���û�
 * ���̣�
 *      1.�ж�ͬһ�����Ƿ�Ϊ���ε�¼
 *         1.1 �ǣ���ת2
 *         1.2 ����ת3
 *      2.�ж��û��Ƿ�Ϊ�����û�
 *         2.1 �ǣ��߳������Ѿ���¼�û� 4
 *         2.2 ����ת3
 *      3.�ж��û��Ƿ�Ϊ���ε�¼
 *         3.1 �ǣ���ת 5
 *         3.2��1 ���߳������Ѿ���¼�û� 4
 *         3.2��2 �� 4  (��1.2��ת�����ģ��Ͳ���Ҫ�޳��û�)
 *      4.У��
 * 
 */
public class OnlineUsers implements HttpSessionBindingListener {
	private HashMap<User, HttpSession> users = new HashMap<User, HttpSession>();
	private static OnlineUsers onlineUsers = new OnlineUsers();
	//private static OnlineUsers onlineUsers = null;

	/**
	 * ȡ�ö���ʵ��
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
	 * ȡ�����û��б�
	 * 
	 * @return
	 */
	public HashMap<User, HttpSession> getUsers() {
		return users;

	}

	/**
	 * �û��б�����ӵ�¼�û�
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
	 * ͨ���û����߳��û�
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
	 * ͨ��session�߳��û�
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
	 * @��������:�жϱ����Ƿ����û���½
	 * @param localIP
	 * @return
	 * @����ʱ�� 2008-7-15
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
	 * @��������:ȡ�ø��û����ĵ�½IP
	 * @param localIP
	 * @return
	 * @����ʱ�� 2008-7-15
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
	 * �ж��û��Ƿ�Ϊ�����û�
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
	 * �ж��û��Ƿ�Ϊ�����û�
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
	 * �жϴ˻��Ƿ�Ϊ2�ε�¼
	 * 
	 * @param loginname
	 *            String
	 * @param session
	 *            HttpSession
	 * @return int
	 */
	public boolean hostOnline(HttpServletRequest request) {
		String localIP = request.getRemoteAddr();// ��ȡ����ip
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
	 * �޳������Ѿ���¼�û�
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param loginname
	 *            String
	 */

	public void kickLocalUser(HttpServletRequest request, String loginname) {
		String localIP = request.getRemoteAddr();// ��ȡ����ip
		try {
			try {
				User removeUser = null;
				Iterator<User> ite = users.keySet().iterator();
				while (ite.hasNext()) {
					User temp = ite.next();
					HttpSession value = users.get(temp);
					String ip = (String) value.getAttribute(Constant.ONLINE_USER_RDDR);
					if (ip.equals(localIP) && temp.getUsername().equals(loginname)) {
						System.out.println("�޳���½IPΪ" + localIP + " ��¼��Ϊ " + loginname + " ���û�(ָ���û���)");
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
	 * �߳������ѵ�¼��δ֪���û�
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
					System.out.println("�޳���½IPΪ" + localIp + " ��¼��Ϊ " + temp.getUsername() + " ���û�(δָ���û���)");
					value.invalidate();
					removeUser = temp;
					break;
				}
			}
			/**�������޸���20100225*/
			if (null != removeUser) {
				users.remove(removeUser);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * �����û������жϴ��û��Ƿ��Ѿ���¼
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
	 * ȡ��ҳ��ˢ�����
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
	 * �����û���¼
	 * 
	 * @param event
	 *            HttpSessionBindingEvent
	 */
	public void valueBound(HttpSessionBindingEvent event) {
		try {
			HttpSession session = event.getSession();
			/***/
			//ServletContext application = session.getServletContext();
		    // ���û������������б�
			//HashMap<User, HttpSession> users = (HashMap<User, HttpSession>) application.getAttribute("users");
		    // ��һ��ʹ��ǰ����Ҫ��ʼ��
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
	 * �����û��˳�
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
		    // �������б���ɾ���û���
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

package com.cib.action;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.json.JSONException;
import org.json.JSONObject;

import com.cib.constant.Constant;
import com.cib.entity.User;
import com.cib.model.ActionRule2;
import com.cib.service.ILoginManager;
import com.cib.util.OnlineUsers;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//@Results({ 

//@Result(name="success", location="/index.action", type="redirect"), 

//@Result(name="input", location="login.jsp", type="dispatcher") 

//}) 

public class LoginAction extends ActionSupport implements Action{
	
	private List list;
	private ILoginManager loginManager;
	private ActionRule2 actionRule2 = new ActionRule2();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(LoginAction.class);
	
	private static final long serialVersionUID = 1030294046920869257L;   
	private String username;   
	private String password;
	
	private String json;    //JSON�ַ���,JS��Action�������ݵ�����
    public String getJson() {
        return json;
    }
    public void setJson(String json) {
        this.json = json;
    }

	
	
	// �����û������execute����   
    //public String execute() throws Exception {
    public String exec() throws Exception {
    	log.debug("LoginAction execute start");
    	System.out.println(getUsername()+":"+getPassword());
//        if (isInvalid(getUsername()))   
//            return INPUT;     
//        if (isInvalid(getPassword()))   
//            return INPUT;   
    	User user = new User();
        if ((getUsername().equals("admin") || getUsername().equals("admin"))   
                && getPassword().equals("admin")) {   
            // ͨ��ActionContext�������WebӦ�õ�Session   
            ActionContext.getContext().getSession().put("user", getUsername());   
            ActionContext.getContext().getSession().put("pass", getPassword());   
            System.out.println(getUsername() + "----" + getPassword());   
            //[����]�û���¼���� 
            OnlineUsers onlineUsers = OnlineUsers.getInstance();
            ActionContext context = ActionContext.getContext();   
            HttpServletRequest request = (HttpServletRequest) context.get(ServletActionContext.HTTP_REQUEST);  
            // ��½�ɹ����û���Ϣ����Session ���޸������ꑕr�g
            user.setId(1);
            user.setUsername(getUsername());
            user.setPassword(getPassword());
			request.getSession().setAttribute(Constant.USER_KEY, user);
			request.getSession().setAttribute(Constant.ONLINE_USERNAME, user.getUsername());
			request.getSession().setAttribute(Constant.ONLINE_USER_RDDR, request.getRemoteAddr());
            request.getSession().setAttribute(Constant.ONLINE_USER, onlineUsers);
            return SUCCESS;   
        } else {   
            System.out.println(getUsername() + "----" + getPassword());   
            return ERROR;   
        }   
    }   
  
    private boolean isInvalid(String value) {   
        return (value == null || value.length() == 0);   
    }   
    
    public String add() {   
        return SUCCESS;   
    }   
  
    public String show() {   
        return SUCCESS;   
    }   
  
    public String qurey() {   
        return SUCCESS;   
    }   
  
    public String getUsername() {   
        return username;   
    }   
  
    public void setUsername(String username) {   
        this.username = username;   
    }   
  
    public String getPassword() {   
        return password;   
    }   
  
    public void setPassword(String password) {   
        this.password = password;   
    }   

	
	public String query() throws Exception
	{
		log.debug("ActionRule2Action query ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		ActionRule2 actionrule2 = new ActionRule2();
		try
		{
			loginManager.query(actionrule2);

		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action query ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	
	/**
	 * @function ������Ի���ҳ������Ϣ
	 * @return String 
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		log.debug("ActionRule2Action save ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		actionRule2.setCCity(request.getParameter("id"));
		actionRule2.setCrateDatetime(new Date());
		try
		{
			loginManager.saveActionRule(actionRule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action save ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function ɾ�����Ի���ҳ������Ϣ
	 * @return String 
	 * @throws Exception
	 */
	public String delete() throws Exception
	{
		log.debug("ActionRule2Action delete ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		try
		{
			ActionRule2 actionrule2 = loginManager.findByIdActionRule(advActionId);
			loginManager.deleteActionRule(actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action delete ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function ��ѯ���Ի���ҳ������Ϣ
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		log.debug("ActionRule2Action getAll ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			list  = loginManager.findAllActionRule();
			request.getSession().setAttribute("ActionRule2s", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action getAll ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function ���¸��Ի���ҳ������Ϣ
	 * @return String 
	 * @throws Exception
	 */
	public String update() throws Exception
	{
		log.debug("ActionRule2Action update ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		try
		{
			ActionRule2 actionrule2 = loginManager.findByIdActionRule(advActionId);
			request.getSession().setAttribute("actionrule2", actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action update ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function ������¸��Ի���ҳ������Ϣ
	 * @return String 
	 * @throws Exception
	 */
	public String saveOrUpdate() throws Exception
	{
		log.debug("ActionRule2Action saveOrUpdate ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		ActionRule2 actionrule2 = loginManager.findByIdActionRule(advActionId);
		actionrule2.setAdvActionId(Long.valueOf(advActionId));
		
		try
		{
			loginManager.saveActionRule(actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action saveOrUpdate ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	

	public ILoginManager getLoginManager() {
		return loginManager;
	}

	public void setLoginManager(ILoginManager loginManager) {
		this.loginManager = loginManager;
	}

	public ActionRule2 getActionRule2() {
		return actionRule2;
	}

	public void setActionRule2(ActionRule2 actionRule2) {
		this.actionRule2 = actionRule2;
	}
//	public void validate()
//	{
//		if (getUsername() == null || getUsername().trim().equals(""))
//		{
//			addFieldError("username", getText("user.required"));
//		}
//		if (getPassword() == null || getPassword().trim().equals(""))
//		{
//			addFieldError("password", getText("pass.required"));
//		}
//	}
	
	public void valid() throws Exception {
		
		JSONObject jsonObj = new JSONObject(json);
		//��JSON��ʽ���ַ��������JSON����
		String username = jsonObj.getString("username"); //��ȡJSON�����е�loginName���Ե�ֵ
		String password = jsonObj.getString("password");    //��ȡJSON�����е�password���Ե�ֵ
		//System.out.println(username+"*"+username.equals("admin"));
		if(!username.equals("admin")){
			//��ʱ��JSON����,����������suc��msg,����suc��ʾ�Ƿ��¼�ɹ���״̬
			json = "{suc:0, msg:'�û���������'}";    //����JSON��ʽ���ַ���
		} else if( ! password.equals("admin")){
			json = "{suc:0, msg:'���벻��ȷ!'}";
		} else {
			this.setUsername(username);
			this.setPassword(password);
			String s = this.exec();
			json = "{suc:1, msg:'"+s+"'}";
		}
		sendMsg(json);    //����JSON��ʽ���ַ�����JS��
	}
	
	/** *//**
     * ��ͻ��˵�JS�����ַ���
     * @param content ���͵�����
     * @throws IOException
     */
    public void sendMsg(String content) throws IOException{
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(content);
    }

}

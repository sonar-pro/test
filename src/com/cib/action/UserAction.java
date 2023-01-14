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

import com.cib.model.ActionRule2;
import com.cib.service.ICommonOperationManager;
import com.cib.service.IUserManager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//@Results({ 

//@Result(name="success", location="/index.action", type="redirect"), 

//@Result(name="input", location="login.jsp", type="dispatcher") 

//}) 

public class UserAction extends ActionSupport implements Action{
	
	private List list;
	private IUserManager userManager;
	private ICommonOperationManager commonOperationManager;
	private ActionRule2 actionRule2 = new ActionRule2();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(UserAction.class);
	
	private static final long serialVersionUID = 1030294046920869257L;   
	private String username;   
	private String password;
	
	private String json;    //JSON字符串,JS与Action传递数据的载体
    public String getJson() {
        return json;
    }
    public void setJson(String json) {
        this.json = json;
    }
    public IUserManager getUserManager() {
		return userManager;
	}
	public void setUserManager(IUserManager userManager) {
		this.userManager = userManager;
	}
	
	public ICommonOperationManager getCommonOperationManager() {
		return commonOperationManager;
	}
	public void setCommonOperationManager(
			ICommonOperationManager commonOperationManager) {
		this.commonOperationManager = commonOperationManager;
	}
	// 处理用户请求的execute方法   
    //public String execute() throws Exception {
    public String exec() throws Exception {
    	log.debug("LoginAction execute start");
    	System.out.println(getUsername()+":"+getPassword());
//        if (isInvalid(getUsername()))   
//            return INPUT;   
//  
//        if (isInvalid(getPassword()))   
//            return INPUT;   
        if ((getUsername().equals("admin") || getUsername().equals("admin"))   
                && getPassword().equals("admin")) {   
            // 通过ActionContext对象访问Web应用的Session   
            ActionContext.getContext().getSession().put("user", getUsername());   
            ActionContext.getContext().getSession().put("pass", getPassword());   
            System.out.println(getUsername() + "----" + getPassword());   
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
			userManager.query(actionrule2);

		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action query ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	
	/**
	 * @function 保存个性化插页规则信息
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
			userManager.saveActionRule(actionRule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action save ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 删除个性化插页规则信息
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
			ActionRule2 actionrule2 = userManager.findByIdActionRule(advActionId);
			userManager.deleteActionRule(actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action delete ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 查询个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		log.debug("ActionRule2Action getAll ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			list  = userManager.findAllActionRule();
			request.getSession().setAttribute("ActionRule2s", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action getAll ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 更新个性化插页规则信息
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
			ActionRule2 actionrule2 = userManager.findByIdActionRule(advActionId);
			request.getSession().setAttribute("actionrule2", actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action update ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 保存更新个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String saveOrUpdate() throws Exception
	{
		log.debug("ActionRule2Action saveOrUpdate ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		ActionRule2 actionrule2 = userManager.findByIdActionRule(advActionId);
		actionrule2.setAdvActionId(Long.valueOf(advActionId));
		
		try
		{
			userManager.saveActionRule(actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action saveOrUpdate ActionRule failure", ex);
		}
		return SUCCESS;
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
		//将JSON格式的字符串构造成JSON对象
		String username = jsonObj.getString("username"); //获取JSON对象中的loginName属性的值
		String password = jsonObj.getString("password");    //获取JSON对象中的password属性的值
		//System.out.println(username+"*"+username.equals("admin"));
		if(!username.equals("admin")){
			//此时的JSON对象,有两个属性suc和msg,其中suc表示是否登录成功的状态
			json = "{suc:0, msg:'用户名不存在'}";    //构造JSON格式的字符串
		} else if( ! password.equals("admin")){
			json = "{suc:0, msg:'密码不正确!'}";
		} else {
			json = "{suc:1, msg:'登录成功!'}";
			this.setUsername(username);
			this.setPassword(password);
			this.exec();
		}
		sendMsg(json);    //发送JSON格式的字符串回JS端
	}
	
	/** *//**
     * 向客户端的JS发送字符串
     * @param content 发送的内容
     * @throws IOException
     */
    public void sendMsg(String content) throws IOException{
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(content);
    }

}

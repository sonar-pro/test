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
import com.cib.service.ILoginManager;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

//@Results({ 

//@Result(name="success", location="/index.action", type="redirect"), 

//@Result(name="input", location="login.jsp", type="dispatcher") 

//}) 
/** 
 * @author 通过默认action请求类实现带参数访问action 
 * Jun 8, 2011[8:31:01 PM] 
 * 
 */
public class DefaultAction extends ActionSupport implements Action
{
	

	private ILoginManager loginManager;
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(DefaultAction.class);
	
	private static final long serialVersionUID = 1030294046920869257L;   
	
	@Override
	public String execute() throws Exception {
		return SUCCESS;
	}
	
    public String index() {
    	System.out.println(ServletActionContext.getRequest().getContextPath());
    	System.out.println(ServletActionContext.getRequest().getRequestURI());
        return SUCCESS;   
    }
}

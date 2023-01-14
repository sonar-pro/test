package com.cib.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;

import com.cib.action.LoginAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AuthorityInterceptor extends AbstractInterceptor {

	//@Override
	//public String intercept(ActionInvocation arg0) throws Exception {
	//	// TODO Auto-generated method stub
	//	return null;
	//}
	//private static final long serialVersionUID = 1358600090729208361L;   
	private static final Log log = LogFactory.getLog(AuthorityInterceptor.class);
    //拦截Action处理的拦截方法   
    public String intercept(ActionInvocation invocation) throws Exception { 
    	System.out.println("拦截"+invocation.getAction().getClass()+"处理的拦截方法");        
        // 取得请求相关的ActionContext实例   
        ActionContext ctx=invocation.getInvocationContext();   
        Map session=ctx.getSession();
        HttpServletRequest request= (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST); 
        System.out.println("request="+request.getRequestURI());
        //取出名为user的session属性   
        String user=(String)session.get("user");
        System.out.println("拦截user="+user);
        //如果没有登陆，或者登陆所有的用户名不是admin，都返回重新登陆   
        if(user!=null && user.equals("admin")){   
            return invocation.invoke();   
        }   
        //没有登陆，将服务器提示设置成一个HttpServletRequest属性   
        ctx.put("tip","您还没有登录，请登陆系统");   
        //System.out.println("tip="+ctx.get("tip"));
        return Action.LOGIN;           
    }

}

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
    //����Action��������ط���   
    public String intercept(ActionInvocation invocation) throws Exception { 
    	System.out.println("����"+invocation.getAction().getClass()+"��������ط���");        
        // ȡ��������ص�ActionContextʵ��   
        ActionContext ctx=invocation.getInvocationContext();   
        Map session=ctx.getSession();
        HttpServletRequest request= (HttpServletRequest) ctx.get(StrutsStatics.HTTP_REQUEST); 
        System.out.println("request="+request.getRequestURI());
        //ȡ����Ϊuser��session����   
        String user=(String)session.get("user");
        System.out.println("����user="+user);
        //���û�е�½�����ߵ�½���е��û�������admin�����������µ�½   
        if(user!=null && user.equals("admin")){   
            return invocation.invoke();   
        }   
        //û�е�½������������ʾ���ó�һ��HttpServletRequest����   
        ctx.put("tip","����û�е�¼�����½ϵͳ");   
        //System.out.println("tip="+ctx.get("tip"));
        return Action.LOGIN;           
    }

}

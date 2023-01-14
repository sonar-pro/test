package com.cib.util.mail;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SpringMail {
	private Configuration cfg = new Configuration();  
	
 public static void main(String[] args) throws Exception {  
	         ApplicationContext ctx = new FileSystemXmlApplicationContext("D:/Program Files/Genuitec/ws/billsystem1.2/WebRoot/WEB-INF/applicationContext.xml");     
	         JavaMailSender sender = (JavaMailSender) ctx.getBean("mailSender");  
	         SpringMail springMail = new SpringMail();  
	         springMail.sendMail(sender);  
	   
	     }  
	   
	     private void sendMail(JavaMailSender sender)  {  
	    	 try{
		         SimpleMailMessage mail = new SimpleMailMessage();  
		         mail.setTo("314205221@qq.com"); //接收人  
		         mail.setFrom("zxfxfu@163.com"); //发送人  
		         mail.setSubject("test by amigo");  
		         //嵌入ftl模版  
		         //cfg.setClassForTemplateLoading(getClass(), "/mail");  
		         String templatePath = "D:/Program Files/Genuitec/ws/billsystem1.2/WebRoot/WEB-INF/template/"; //你测试下路径是否少'/' 
		         cfg.setDirectoryForTemplateLoading(new File(templatePath ));
		         Map root = new HashMap();  
		         root.put("username", "sucre"); //模板变量  
		         Template t = cfg.getTemplate("notify-mail.ftl");  
		         StringWriter writer = new StringWriter();  
		         t.process(root, writer);  
		         //把模版内容写入邮件中  
		         mail.setText(writer.toString());  
		         sender.send(mail);  
		         System.out.println("邮件发送成功！");  
	    	 }catch(MailException e){
	    		 e.printStackTrace();
	    		 System.out.println("邮件发送失败！");  
	    	 } catch (IOException e) {
				e.printStackTrace();
			} catch (TemplateException e) {
				e.printStackTrace();
			}
	     }  
		
}

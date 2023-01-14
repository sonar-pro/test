package com.cib.action;

/** 
 * Struts2Test 
 * 顺便的文件下载的Action 
 */  

import java.io.FileInputStream;  
import java.io.InputStream;  
import java.io.OutputStream;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
import org.apache.struts2.interceptor.ServletRequestAware;  
import org.apache.struts2.interceptor.ServletResponseAware;  
import com.opensymphony.xwork2.ActionSupport;  
/** 
 * @author Bill Tu(tujiyue/iwtxokhtd) 
 * Jun 8, 2011[9:15:15 PM] 
 * 
 */  
public class DownloadFileAction extends ActionSupport implements  
        ServletRequestAware, ServletResponseAware {  
      
    /** 
     *  
     */  
    private static final long serialVersionUID = -7448748577778248376L;  
    private HttpServletRequest request;  
    private HttpServletResponse response;  
    private String savePath;  
      
    @Override  
    public String execute() throws Exception {  
          
        String fileName=request.getParameter("fileName");  
        String fullPath=getSavePath()+"//"+fileName;  
        fileName=new String(fileName.getBytes("utf-8"),"iso-8859-1");  
        InputStream is=new FileInputStream(fullPath);  
        int len=0;  
        byte []buffers=new byte[1024];  
        response.reset();  
        response.setContentType("application/x-msdownload");  
        //response.addHeader("Content-Disposition", "attachment;filename=/""+fileName+"/"");  
        response.addHeader("Content-Disposition", "attachment;filename=\""+fileName+"\""); 
        //把文件内容通过输出流打印到页面上供下载   
        while((len=is.read(buffers))!=-1){  
            OutputStream os=response.getOutputStream();  
            os.write(buffers, 0, len);  
        }  
          
        is.close();  
          
        return SUCCESS;  
    }  
    public void setServletRequest(HttpServletRequest req) {  
        this.request=req;  
    }  
    public void setServletResponse(HttpServletResponse resp) {  
        this.response=resp;  
    }  
    @SuppressWarnings("deprecation")  
    public String getSavePath() {  
        return request.getRealPath(savePath);  
    }  
    public void setSavePath(String savePath) {  
        this.savePath = savePath;  
    }  
      
}  
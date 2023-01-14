package com.cib.action;
/** 
 * Struts2Test 
 * ʹ��Struts2�ϴ��ļ� 
 */    
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.interceptor.ServletRequestAware;  
import com.opensymphony.xwork2.ActionSupport;  
/** 
 * @author Bill Tu(tujiyue/iwtxokhtd) 
 * Jun 8, 2011[8:31:01 PM] 
 * 
 */  
public class UploadFileAction extends ActionSupport implements  
        ServletRequestAware {  
    /** 
     *  
     */  
    private static final long serialVersionUID = -1896915260152387341L;  
    private HttpServletRequest request;  
    public void setServletRequest(HttpServletRequest req) {  
        this.request=req;  
    }  
      
      
    private List<File> fileName;//�����"fileName"һ��Ҫ����е��ļ�������ͬ   
    private List<String> fileNameContentType;//��ʽͬ��"fileName"+ContentType   
    private List<String> fileNameFileName;//��ʽͬ��"fileName"+FileName   
    private String savePath;//�ļ��ϴ��󱣴��·��   
      
    public List<File> getFileName() {  
        return fileName;  
    }  
  
    public void setFileName(List<File> fileName) {  
        this.fileName = fileName;  
    }  
  
    public List<String> getFileNameContentType() {  
        return fileNameContentType;  
    }  
  
    public void setFileNameContentType(List<String> fileNameContentType) {  
        this.fileNameContentType = fileNameContentType;  
    }  
  
    public List<String> getFileNameFileName() {  
        return fileNameFileName;  
    }  
  
    public void setFileNameFileName(List<String> fileNameFileName) {  
        this.fileNameFileName = fileNameFileName;  
    }  
  
    @SuppressWarnings("deprecation")  
    public String getSavePath() {  
        return request.getRealPath(savePath);  
    }  
  
    public void setSavePath(String savePath) {  
        this.savePath = savePath;  
    }  
    @Override  
    public String execute() throws Exception {  
        File dir=new File(getSavePath());  
        if(!dir.exists()){  
            dir.mkdirs();  
        }  
        List<File> files=getFileName();  
       for(int i=0;i<files.size();i++){  
            FileOutputStream fos=new FileOutputStream(getSavePath()+"//"+getFileNameFileName().get(i));  
            FileInputStream fis=new FileInputStream(getFileName().get(i));  
            byte []buffers=new byte[1024];  
            int len=0;  
            while((len=fis.read(buffers))!=-1){  
                fos.write(buffers,0,len);  
            }  
        }  
        return SUCCESS;  
    }  
  
} 
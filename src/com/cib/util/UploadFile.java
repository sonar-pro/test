package com.cib.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UploadFile
{
	/**
	 * 上传文件到WEB服务器端.
	 * 
	 * @param request	HTTP请求
	 * @param fileKey	上传文件名所在控件的名称
	 * @param localPath	保存在WEB服务器端的文件路径
	 * 
	 * @return	保存在WEB服务器端的文件名称
	 * @throws Exception	异常.
	 */
	public  String uploadFile(HttpServletRequest request,String fileKey, String localPath) 
	throws Exception 
	{
		GetSysTime gst = null;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request; 
        // 获得文件：     
        MultipartFile file = multipartRequest.getFile("file");    //filename表单参数名 
        if (file == null) 
        { 
           throw new Exception("获取上传文件页面表单参数[file]的值为null!"); 	            
        }
        InputStream in = null;
        FileOutputStream out = null;
        try {
	        	gst = new GetSysTime();
		        in = file.getInputStream();	        
		        // filename on the client
		        String fileName = file.getOriginalFilename();
		        // 扩展名
		        String txt = fileName.substring(fileName.lastIndexOf("."));
		        String uploadFileName = fileName.substring(0, fileName.lastIndexOf(".")) 
		        				+ "_" +gst.getTodayStrByFormat("yyyyMMddHHmmssSSS") + txt;
		        out = new FileOutputStream(localPath + java.io.File.separator + uploadFileName);
		        byte[] buf = new byte[1024];
		        int byteread = 0;
		        while((byteread = in.read(buf)) > 0) 
		        {
		        	out.write(buf, 0, byteread);
		        	out.flush();
		        }
			        return uploadFileName;
	       } catch (Exception e) 
	       {
	        	throw new Exception(e);
	       } finally 
	       {
		        // 关闭流
		        if (in != null) 
		        {
		        	in.close();
		        }
		        if (out != null) 
		        {
		        	out.close();
		        }
	       }        
	}
}

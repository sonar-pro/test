package com.cib.util;

import java.io.FileOutputStream;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public class UploadFile
{
	/**
	 * �ϴ��ļ���WEB��������.
	 * 
	 * @param request	HTTP����
	 * @param fileKey	�ϴ��ļ������ڿؼ�������
	 * @param localPath	������WEB�������˵��ļ�·��
	 * 
	 * @return	������WEB�������˵��ļ�����
	 * @throws Exception	�쳣.
	 */
	public  String uploadFile(HttpServletRequest request,String fileKey, String localPath) 
	throws Exception 
	{
		GetSysTime gst = null;
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request; 
        // ����ļ���     
        MultipartFile file = multipartRequest.getFile("file");    //filename�������� 
        if (file == null) 
        { 
           throw new Exception("��ȡ�ϴ��ļ�ҳ�������[file]��ֵΪnull!"); 	            
        }
        InputStream in = null;
        FileOutputStream out = null;
        try {
	        	gst = new GetSysTime();
		        in = file.getInputStream();	        
		        // filename on the client
		        String fileName = file.getOriginalFilename();
		        // ��չ��
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
		        // �ر���
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

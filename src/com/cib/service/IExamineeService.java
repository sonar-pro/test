package com.cib.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.cib.entity.Examinee;
import com.cib.entity.Page;
import com.cib.model.TbTest;

public interface IExamineeService {

        //��̨��ҳ���Ĵ���   
    public Page total(); 
      
    //��̨��ҳ������   
    public Page firstPage(Page page) ;  
    public List<Examinee> queryByPage(Page page); 
      
    public Page lastPage(Page page);
	

}

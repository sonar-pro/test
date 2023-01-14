package com.cib.dao;

import java.util.List;

import com.cib.entity.Examinee;
import com.cib.entity.Page;
import com.cib.model.TbTest;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IExamineeDAO {

	    public List<Examinee> list(Page page);      
	    public Page total();  
	    public Page firstPage(Page page);  
	    public Page lastPage(Page page);  
	      

}

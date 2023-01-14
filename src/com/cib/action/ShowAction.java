package com.cib.action;

import java.util.List;  
  
  
import com.cib.entity.Examinee;
import com.cib.entity.Page;
import com.cib.service.IExamineeService;

import com.opensymphony.xwork2.ActionSupport;  
 
  
public class ShowAction extends ActionSupport {  
	private IExamineeService examineeService;  
    private List<Examinee> examinees ;    //用于存放考生信息的集合   
  
    private Page page;              //引入Page类型变量   
    private int pageNow;            //当前页数   
    public int getPageNow() {  
        return pageNow;  
    }  
    public void setPageNow(int pageNow) {  
        this.pageNow = pageNow;  
    }  
    public Page getPage() {  
        return page;  
    }  
    public void setPage(Page page) {  
        this.page = page;  
    }  
    public List<Examinee> getExaminees() {  
    	return examinees;  
    }  
    public void setExaminees(List<Examinee> examinees) {  
    	this.examinees = examinees;  
    }  
      
   public IExamineeService getExamineeService() {
		return examineeService;
	}
	public void setExamineeService(IExamineeService examineeService) {
		this.examineeService = examineeService;
	}
	//对第一页的处理   
    public String first(){  
        page = examineeService.total();      //获得页数的信息如当前页数  一页包含多少条记录等   
        page = examineeService.firstPage(page);       //设置当前页数为第一页   
        examinees = examineeService.queryByPage(page);     //查找第一页的数据   
    return SUCCESS;  
    }  
      
    public String pre(){  
        page = examineeService.total();     //获得页数的信息如当前页数  一页包含多少条记录等   
        if(pageNow<1){                  //页数小于1时 当前页数，任然为1   
            pageNow=1;  
        }  
        page.setPageNow(pageNow);          //设置当前的页数   
        examinees = examineeService.queryByPage(page);     //查找当前页数的数据   
        return SUCCESS;  
    }  
      
    public String next(){  
        page = examineeService.total();     //获得页数的信息如当前页数  一页包含多少条记录等   
        if(pageNow<2){                      //如果当前页数小于2下一页链接无效，下一页的第一个当前页面为第二页   
            pageNow=2;  
        }  
        if(pageNow>page.getLastPage()){  
            pageNow=page.getLastPage();          //如果当前页数大于最大的页数，是当前页数永远是最后一页   
        }  
        page.setPageNow(pageNow);  
        examinees = examineeService.queryByPage(page);        //查找当前页数的数据   
        return SUCCESS;  
    }  
      
    public String last(){  
        page = examineeService.total();          //获得页数的信息如当前页数  一页包含多少条记录等   
        page = examineeService.lastPage(page);         //设置当前页数为最大的也是   
        examinees = examineeService.queryByPage(page);   //查找最后一页的信息   
        return SUCCESS;  
    }  
      
      
}

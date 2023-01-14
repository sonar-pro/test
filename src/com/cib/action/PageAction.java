package com.cib.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cib.entity.User;
import com.cib.service.IPageService;

import com.opensymphony.xwork2.ActionSupport;

public class PageAction extends ActionSupport {

	private IPageService pageService;
    
    public IPageService getPageService() {
		return pageService;
	}

	public void setPageService(IPageService pageService) {
		this.pageService = pageService;
	}

	int pageCount = 0;
    
    int rowCount = 0;
    
    int pageSize = 10;
    
    int listSize;
    
    List<User> list = new ArrayList<User>();
    
    int pageNow = 1; //希望显示第几页
    
    public int getRowCount() {
		return rowCount;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}

    
    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }
    



	public  String create(){
         try {
        	 pageService.insertUser();
               }catch (DataAccessException dae) {
                // TODO: handle exception
                   dae.printStackTrace();
                   System.out.println("数据访问异常！！");
            } catch (Exception e) {
                // TODO: handle exception
                   e.printStackTrace();
                   System.out.println("出现异常了！");
            }
                return SUCCESS;
            }
        
    
  //分页
    public String pagination() {
        
        //pageCount = userPageService.pageCount(pageSize); 
    	rowCount = pageService.totalCount(); 
    	
    	if(rowCount%pageSize==0){
    		pageCount = rowCount/pageSize; 
    	}else{
    		pageCount = rowCount/pageSize+1; 
    	}
    	
    	
        list = pageService.pageUser(pageNow,pageSize);

        if(list.size()==0){
            
            listSize = 1;

            addActionError("数据库中没有值");
        }
        return "page";
    }
    
    
    @Override
    public String execute() throws Exception {
  
      return null;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getListSize() {
        return listSize;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }


}

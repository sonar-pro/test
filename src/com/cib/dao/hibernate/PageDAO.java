package com.cib.dao.hibernate;

import java.util.ArrayList;
import java.util.List;


import com.cib.dao.IPageDAO;
import com.cib.entity.User;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class PageDAO extends JdbcDaoSupport implements IPageDAO {
	List<User> list = new ArrayList<User>();
    
	 
    int pageCount = 0;
    public void insertUser() {
       String sql = "insert into user(username,password)values('ryan','chen')";
       getJdbcTemplate().execute(sql);
    }
    
    
    public List<User> pageUser(int pageNow,int pageSize) {
       
        //String limitF = String.valueOf((pageNow-1)*pageSize);
       
        //System.out.println("limitF = " +limitF);
        
        //String limitA = String.valueOf(pageSize);
        
        //System.out.println("limitA = " +limitA);
        
        //String sql2 = "select * from users limit"+" "+limitF+","+limitA ;
    	
    	String sql2 = "SELECT TOP "+pageSize+" * FROM Users WHERE (ID NOT IN (SELECT TOP "+pageSize*(pageNow-1)+" ID FROM Users ORDER BY ID )) ORDER BY ID ";
    	//String sql2 = "SELECT TOP "+pageSize+" * FROM Users WHERE (ID NOT IN (SELECT TOP "+pageSize*(pageNow-1)+" ID FROM Users ORDER BY ID DESC)) ORDER BY ID DESC";
        
        //System.out.println("sql2 = "+sql2);
       
        list = getJdbcTemplate().queryForList(sql2);
        
        return list;
    }
    /**
     * 分页:计算总页数
     */
//    public int pageCount(int pageSize) {
//        String sql = "select count(*) from users";
//          
//        int rowCount  = getJdbcTemplate().queryForInt(sql);
//        
//        if(rowCount%pageSize==0){
//            pageCount = rowCount/pageSize; 
//        }else{
//            pageCount = rowCount/pageSize+1; 
//        }
//       return pageCount;
//    }
    /**
     * 分页:查询总记录数
     */
    public int totalCount() {
        String sql = "select count(*) from users";
       return getJdbcTemplate().queryForInt(sql);
    }

} 
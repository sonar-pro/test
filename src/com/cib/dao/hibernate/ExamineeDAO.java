package com.cib.dao.hibernate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.cib.dao.IExamineeDAO;
import com.cib.dao.ITestDAO;
import com.cib.entity.Examinee;
import com.cib.entity.Page;
import com.cib.model.TbTest;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;

public class ExamineeDAO extends JdbcDaoSupport implements IExamineeDAO {
	public List<Examinee> list(Page page) {  
		List<Examinee> examinees = new ArrayList<Examinee>();  
		try {  
		Connection conn = getJdbcTemplate().getDataSource().getConnection();
        int pageSize = page.getPageSize();  
        int pageNow = page.getPageNow();  
        //String sql = "select * from br_users order by id limit " + (pageNow*pageSize-pageSize)+","+pageSize;  
        String sql = "SELECT TOP "+pageSize+" * FROM Users WHERE (ID NOT IN (SELECT TOP "+pageSize*(pageNow-1)+" ID FROM Users ORDER BY ID DESC)) ORDER BY ID DESC";
        System.out.println("sql="+sql);
        PreparedStatement ps = conn.prepareStatement(sql)  ;
        Examinee examinee = null;  
        ResultSet rs = null;  
            rs = ps.executeQuery();  
            while(rs.next()){  
                examinee = new Examinee();  
                String id = rs.getString("id");  
                String sex = rs.getString("sex");  
                String age = rs.getString("age"); 
                String username = rs.getString("username");  
                String password = rs.getString("password");  
                String address = rs.getString("address");  

                examinee.setId(id);  
                examinee.setSex(sex);  
                examinee.setUsername(username);  
 		        examinee.setPassword(password);  
                examinee.setAddress(address);  
                examinee.setAge(age);         
                examinees.add(examinee);  
              
            }  
  
		} catch (SQLException e) {  
            e.printStackTrace();  
        }
		return examinees;  
    }  
  
        //统计记录数和页数   
    public Page total(){  
        int totalNum = 0;  
        try {  
        	Connection conn = getJdbcTemplate().getDataSource().getConnection();
        	String sql = "select count(*) from br_users";  
        	PreparedStatement ps = conn.prepareStatement(sql) ;
        	ResultSet rs = null;  
            rs = ps.executeQuery();  
            while(rs.next()){  
                totalNum = rs.getInt(1);  
            }  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        Page page = new Page();  
        page.setPageSize(10);  
        int pageSize = page.getPageSize();  
        int lastPage = totalNum/pageSize;  
        if(totalNum%pageSize==0){  
            page.setLastPage(lastPage);   
        }  
        if(totalNum%pageSize!=0){  
            page.setLastPage(lastPage+1);  
        }                         
        page.setTotalNum(totalNum);   
        page.setPageNow(1);  
        return page;  
    }  
      
    public Page firstPage(Page page){         
        page.setPageNow(1);            
        return page;  
    }  
      
    public Page lastPage(Page page){  
        page.setPageNow(page.getLastPage());  
        return page;  
    }  
} 
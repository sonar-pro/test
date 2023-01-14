package com.cib.dao.hibernate;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.sql.DataSource;

import com.cib.dao.ITestDAO;
import com.cib.model.TbTest;

import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;

public class TestDAO implements ITestDAO {

	private JpaTemplate jpaTemplate;
	
	private JpaTransactionManager txManager;
	
	public DataSource getDataSource() {
		return dataSource;
	}


	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	private DataSource dataSource;
	/*
	 * @return List<TbTest> 寰楀埌鍒嗛〉鍚庣殑鏁版嵁
	 * @param int pageSize 姣忛〉鐨勮褰曟潯鏁�
	 * @param int pageNumber 椤靛彿
	 */
	@Override
	public List<TbTest> getPage(int pageSize, int pageNumber) {
		List<TbTest> list=new ArrayList<TbTest>();
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		EntityManager entityManager=jpaTemplate.getEntityManagerFactory().createEntityManager();
		
		Query query = entityManager.createQuery("from TbTest");
		
		query.setFirstResult(pageSize*pageNumber);
		query.setMaxResults(pageSize);
		
		list=query.getResultList();
		
//       System.out.println("绗�"+pageNumber+"椤�");
//		for(TbTest test : list){
//			System.out.println("TestDao涓細"+test.getName());
//		}
		
		return list;
	}

	
	 /*
     * @return int 鎬绘暟鎹潯鏁版暟
     */
	@Override
	public int getPageCount() {
        
		EntityManager entityManager=jpaTemplate.getEntityManagerFactory().createEntityManager();
		
		Query query = entityManager.createQuery("from TbTest");
		
		int i = query.getResultList().size();
	// System.out.println("TestDao涓�绘暟鎹潯鏁帮細"+i);
		return i;
	}

	
	
	public JpaTemplate getJpaTemplate() {
		return jpaTemplate;
	}

	public void setJpaTemplate(JpaTemplate jpaTemplate) {
		this.jpaTemplate = jpaTemplate;
	}

}

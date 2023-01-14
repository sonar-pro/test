package com.cib.dao.hibernate;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;

//import com.cib.entity.page.Page;
import com.cib.dao.UserDAO;
import com.cib.entity.User;

@Component("userDao")
public class UserDAOImpl implements UserDAO {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@SuppressWarnings("unchecked")
	public User getUserByUserIdAndUserNameExits(User user) {
		List<User> users = hibernateTemplate
				.find("from User u where u.username = '" + user.getUsername()
						+ "' and u.password='" + user.getPassword() + "'");

		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public void saveUser(User user) {
		this.hibernateTemplate.save(user);
	}

	public void delUser(User user) {
		User delUser = getUser(user);
		this.hibernateTemplate.delete(delUser);
	}

	@SuppressWarnings("unchecked")
	public List<User> finUserAll() {
		return this.hibernateTemplate.find("from User");
	}

	public User getUser(User user) {
		//return this.hibernateTemplate.get(User.class, user.getId());
		return (User)this.hibernateTemplate.get(User.class, user.getId());
	}

	public void updateUser(User user) {
		this.hibernateTemplate.update(user);
	}
	

	@SuppressWarnings("unchecked")
	public Long getUserCount() {		
		List list = this.getHibernateTemplate().find("select count(*) from User");
		return ((Long) list.iterator().next());
	}
	
	public Long getUserCount(String querySql) {		
		return (Long) getHibernateTemplate().find(querySql).iterator().next();
	}

//	@SuppressWarnings("unchecked")
//	public List<User> getUserListByPage(final Page page) {
//		return this.getHibernateTemplate().executeFind(new HibernateCallback() {
//		public Object doInHibernate(Session session)
//			throws HibernateException, SQLException {
//				/*Query query = session.createQuery("from User");				
//				//性能问题所在
//				query.setFirstResult(page.getBeginIndex()); 
//				query.setMaxResults(page.getEveryPage());				
//				return query.list();*/
//			
//				/*  .add(Restrictions.gt("id", 2)) //greater than = id > 2
//					 .add(Restrictions.lt("id", 8)) //little than = id < 8
//					 .add(Restrictions.like("title", "t_"))
//					 .createCriteria("category")
//					 .add(Restrictions.between("id", 3, 5)) //category.id >= 3 and category.id <=5
//					 
//				   .add(Expression.ge("age", new Integer(20));
//				   .addOrder( Order.asc("name") )
//				   .addOrder( Order.desc("age") )
//				   .setMaxResults(50)
//				   .list();
//				 
//				 
//				   .add( Property.forName("name").like("F%") )
//				   .addOrder( Property.forName("name").asc() )
//				   .addOrder( Property.forName("age").desc() )
//				   .setMaxResults(50)
//				   .list();
//				 * */
//			
//				/*Criteria c = session.createCriteria(User.class);
//				String sortName = page.getSortName();
//				if(StringUtils.isNotEmpty(sortName)){
//					if("asc".equals(page.getSortState())){
//						c.addOrder(org.hibernate.criterion.Order.asc(sortName));						
//					}else{
//						c.addOrder(org.hibernate.criterion.Order.desc(sortName));		
//					}					
//				}
//				c.setFirstResult(page.getBeginIndex());
//				c.setMaxResults(page.getEveryPage());
//				return c.list();*/
//				//Query query = session.createSQLQuery(page.getQuerySql()).addEntity(User.class);//原来的写法
//				//return query.list();
//				List<User> users = (List<User>)session.createSQLQuery(page.getQuerySql()).list();
//				return users;
//			}
//		});		
//	}
}

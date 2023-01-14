package com.cib.dao.hibernate;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.cib.dao.IWithDrawDAO;
import com.cib.model.WithdrawManager;

/**
 * @className WithDrawDAO
 * @function 退信ＤＡＯ实现
 * @author wqs
 * @version 1.0
 */
public class WithDrawDAO extends HibernateDaoSupport implements IWithDrawDAO
{
	private static final Log log = LogFactory.getLog(WithDrawDAO.class);
	
	/*
	 * @methodName save
	 * @functionn 保存退信信息
	 * @param WithdrawManager 退信实体
	 * @return void 
	 */
	public void save(WithdrawManager withdraw) 
	{
		log.debug("WithDrawDAO save start");
		try
		{
			getHibernateTemplate().saveOrUpdate(withdraw);
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("WithDrawDAO save failure", re);
		}
	}
	
	/*
	 * @methodName findByBillDate
	 * @functionn 根据账单期查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
	 */
	public List findByBillDate(String date) 
	{
		log.debug("WithDrawDAO findByBillDate start");
		List list = null;
		try
		{
			list = getHibernateTemplate().find("from WithdrawManager w where w.billDate =?",date);
			if (list == null || list.size() < 1)
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("WithDrawDAO findByBillDate failure", re);
		}
		return  list;
	}

	/*
	 * @methodName findByCardId
	 * @functionn 根据退信卡号查找退信信息
	 * @param id 退信卡号
	 * @return List 退信实体集合
	 */
	public List findByCardId(String id)
	{
		log.debug("WithDrawDAO findByCardId start");
		List list = null;
		try
		{
			list = getHibernateTemplate().find("from WithdrawManager w where w.cardNo =?",id);
			if (list == null || list.size() < 1)
			{
				return null;
			}
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("WithDrawDAO findByCardId failure", re);
		}
		return  list;
	}
}

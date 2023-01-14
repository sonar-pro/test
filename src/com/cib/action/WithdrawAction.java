package com.cib.action;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.cib.model.WithdrawManager;
import com.cib.service.IWithdrawManager;
import com.opensymphony.xwork2.Action;

/**
 * @className WithdrawAction
 * @function 退信action类
 * @author wqs
 * @version 1.0
 */
public class WithdrawAction implements Action
{
	//退信管理的四个属性
	private String card_no;
	private String bill_date;
	private Date export_time;
	private String option_1;
	
	private List list;
	private IWithdrawManager withdrawManage;
	private WithdrawManager withdra = new WithdrawManager();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(WithdrawAction.class);
	
	/*
	 * @methodName save
	 * @function 保存退信信息
	 * @return String 
	 * @exception Exception
	 */
	public String save() throws Exception
	{
		log.debug("WithdrawAction save start");
		String str = "";
		String card_no = "";
		String bill_date = "";
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			File file = new File(request.getParameter("file"));
			System.out.println(request.getParameter("file"));
			BufferedReader br = new BufferedReader(new FileReader(file));
			str = br.readLine();
			int i = 1;
			while (str != null)
			{
				card_no = str.substring(0, 16).trim();
				bill_date = str.substring(19, str.length()).trim();
				withdra.setCardNo(card_no);
				withdra.setBillDate(bill_date);
				withdra.setExportTime(new Date());
				withdra.setOption1("ggg");
				withdrawManage.saveWithdraw(withdra);
				System.out.println(i);
				System.out.println(str);
				str = br.readLine();
				i++;
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("WithdrawAction save failure", ex);
		}
		return SUCCESS;
	}
	
	/*
	 * @methodName findById
	 * @functionn 根据退信卡号查找退信信息
	 * @return List 退信实体集合
	 */
	public String findById() throws Exception
	{
		log.debug("WithdrawAction findById start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String cardId = request.getParameter("card_no");
		System.out.println(cardId+"CCCCC");
		try
		{
			list = withdrawManage.findByCardNo(cardId);
			request.getSession().setAttribute("WithdrawManagers", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("WithdrawAction findById failure", ex);
		}
		return SUCCESS;
	}
	
	/*
	 * @methodName findByDate
	 * @functionn 根据账单期查找退信信息
	 * @return List 退信实体集合
	 */
	public String findByDate() throws Exception
	{
		log.debug("WithdrawAction findById start");
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			String billDate = request.getParameter("bill_date");
			System.out.println(billDate+"DDDD");
			list = withdrawManage.findByBillTime(billDate);
			request.getSession().setAttribute("WithdrawManagers", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("WithdrawAction findById failure", ex);
		}
		return SUCCESS;
	}

	public String execute() throws Exception {
		return null;
	}
	
	public Date getExport_time() {
		return export_time;
	}

	public void setExport_time(Date export_time) {
		this.export_time = export_time;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getOption_1() {
		return option_1;
	}

	public void setOption_1(String option_1) {
		this.option_1 = option_1;
	}

	public String getBill_date() {
		return bill_date;
	}

	public void setBill_date(String bill_date) {
		this.bill_date = bill_date;
	}

	public WithdrawManager getWithdra() {
		return withdra;
	}

	public void setWithdra(WithdrawManager withdra) {
		this.withdra = withdra;
	}

	public IWithdrawManager getWithdrawManage() {
		return withdrawManage;
	}

	public void setWithdrawManage(IWithdrawManager withdrawManage) {
		this.withdrawManage = withdrawManage;
	}

	public String getCard_no() {
		return card_no;
	}

	public void setCard_no(String card_no) {
		this.card_no = card_no;
	}
}

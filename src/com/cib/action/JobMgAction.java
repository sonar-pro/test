package com.cib.action;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.cib.model.JobMg;
import com.cib.service.IJobMgManager;
import com.cib.util.ReadProperty;
import com.opensymphony.xwork2.Action;

/**
 * @className JobMgAction
 * @function 作业管理action
 * @author wqs
 * @version 1.0
 */
public class JobMgAction implements Action
{
	//作业管理的17个属性
	private long batch_id;
	private long job_id;
	private String card_type;
	private Date statement_date;
	private String consol_status;
	private String deal_status;
	private long prt_rule_id;
	private Date billing_month;
	private String dataload_status;
	private String streamload_status;
	private String estatement_status;
	private String esend_mode;
	private Date esend_datetime;
	private String create_author;
	private Date create_datetime;
	private String chg_author;
	private Date chg_datetime;
	
	private List list;
	private IJobMgManager jobMgManager;
	private JobMg jobMg = new JobMg();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(JobMgAction.class);
	
	/**
	 * @function 查询作业管理
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		log.debug("JobMgAction getAll start!");
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			list = jobMgManager.findAllJobMg();
			request.setAttribute("JobMgs", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("JobMgAction getAll failure",ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 调用exe文件
	 * @return String 
	 * @throws Exception
	 */
	public String ReadEXE() throws Exception
	{
		Process process = null;
		ReadProperty readProperty = null;
		Runtime runtime = null;
		String PATH = "D:\\exe\\ipmsg.exe?sagentDBName ";
		try
		{
			readProperty = new ReadProperty();
			Properties prop = readProperty.getPara();
			String sagentName = prop.getProperty("sagentName");
			String sagentPws = prop.getProperty("sagentPws");
			String sagentServerName = prop.getProperty("sagentServerName");
			String sagentDBName = prop.getProperty("sagentDBName");
			String sagentDBPsw = prop.getProperty("sagentDBPsw");
			
			process = runtime.exec(PATH);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("JobMgAction ReadEXE failure",ex);
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public long getBatch_id() {
		return batch_id;
	}
	public void setBatch_id(long batch_id) {
		this.batch_id = batch_id;
	}
	public Date getBilling_month() {
		return billing_month;
	}
	public void setBilling_month(Date billing_month) {
		this.billing_month = billing_month;
	}
	public String getCard_type() {
		return card_type;
	}
	public void setCard_type(String card_type) {
		this.card_type = card_type;
	}
	public String getChg_author() {
		return chg_author;
	}
	public void setChg_author(String chg_author) {
		this.chg_author = chg_author;
	}
	public Date getChg_datetime() {
		return chg_datetime;
	}
	public void setChg_datetime(Date chg_datetime) {
		this.chg_datetime = chg_datetime;
	}
	public String getConsol_status() {
		return consol_status;
	}
	public void setConsol_status(String consol_status) {
		this.consol_status = consol_status;
	}
	public String getCreate_author() {
		return create_author;
	}
	public void setCreate_author(String create_author) {
		this.create_author = create_author;
	}
	public Date getCreate_datetime() {
		return create_datetime;
	}
	public void setCreate_datetime(Date create_datetime) {
		this.create_datetime = create_datetime;
	}
	public String getDataload_status() {
		return dataload_status;
	}
	public void setDataload_status(String dataload_status) {
		this.dataload_status = dataload_status;
	}
	public String getDeal_status() {
		return deal_status;
	}
	public void setDeal_status(String deal_status) {
		this.deal_status = deal_status;
	}
	public Date getEsend_datetime() {
		return esend_datetime;
	}
	public void setEsend_datetime(Date esend_datetime) {
		this.esend_datetime = esend_datetime;
	}
	public String getEsend_mode() {
		return esend_mode;
	}
	public void setEsend_mode(String esend_mode) {
		this.esend_mode = esend_mode;
	}
	public String getEstatement_status() {
		return estatement_status;
	}
	public void setEstatement_status(String estatement_status) {
		this.estatement_status = estatement_status;
	}
	public long getJob_id() {
		return job_id;
	}
	public void setJob_id(long job_id) {
		this.job_id = job_id;
	}
	public long getPrt_rule_id() {
		return prt_rule_id;
	}
	public void setPrt_rule_id(long prt_rule_id) {
		this.prt_rule_id = prt_rule_id;
	}
	public Date getStatement_date() {
		return statement_date;
	}
	public void setStatement_date(Date statement_date) {
		this.statement_date = statement_date;
	}
	public String getStreamload_status() {
		return streamload_status;
	}
	public void setStreamload_status(String streamload_status) {
		this.streamload_status = streamload_status;
	}

	public JobMg getJobMg() {
		return jobMg;
	}

	public void setJobMg(JobMg jobMg) {
		this.jobMg = jobMg;
	}

	public IJobMgManager getJobMgManager() {
		return jobMgManager;
	}

	public void setJobMgManager(IJobMgManager jobMgManager) {
		this.jobMgManager = jobMgManager;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}

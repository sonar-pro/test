package com.cib.action;


import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.cib.model.TmpMsg;
import com.cib.service.ITmpmgManager;
import com.opensymphony.xwork2.Action;

/**
 * @function 模板action
 * @author wqs
 * @version 1.0
 */
public class TmpMgAction implements Action
{
	//	模板的16个属性
	private long record_id;
	private long template_id;
	private String template_name;
	private String template_fname;
	private String template_format;
	private String ca_file;
	private String vault_tmp_file;
	private String mail_tmp_file;
	private String check_tmp_file;
	private long msg_number;
	private long pic_number;
	private String tmp_desc;
	private Date crate_datetime;
	private Date chg_datetime;
	private String creat_author;
	private String chg_author;
	
	private List list ;
	private ITmpmgManager tmpmgManager;
	private TmpMsg tmpmg = new TmpMsg();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(TmpMgAction.class);
	
	/**
	 * @function 保存模板
	 * @return String 
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		log.debug("save TmpMg start");
		HttpServletRequest request  = ServletActionContext.getRequest();
//		tmpmg.setRecordId(Long.valueOf(record_id));
		tmpmg.setTemplateId(Long.valueOf(template_id));
		tmpmg.setTemplateName(template_name);
		tmpmg.setTemplateFname(template_fname);
		tmpmg.setTemplateFormat(request.getParameter("template_format"));
		tmpmg.setCaFile(ca_file);
		tmpmg.setVaultTmpFile(vault_tmp_file);
		tmpmg.setMailTmpFile(mail_tmp_file);
		tmpmg.setCheckTmpFile(check_tmp_file);
		tmpmg.setMsgNumber(Long.valueOf(msg_number));
		tmpmg.setPicNumber(Long.valueOf(pic_number));
		tmpmg.setTmpDesc(tmp_desc);
		tmpmg.setCrateDatetime(new Date());
		
		try
		{
			tmpmgManager.saveTmpMg(tmpmg);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("save TmpMg failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 删除模板
	 * @return String 
	 * @throws Exception
	 */
	public String delete() throws Exception
	{
		log.debug("delete TmpMg start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long templateId = Long.parseLong(id);
		try
		{
			TmpMsg tmpmg = tmpmgManager.findByIdTmpMg(templateId);
			tmpmgManager.deleteTmpMg(tmpmg);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("delete TmpMg failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 查询模板
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		log.debug("findAll TmpMg start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		try
		{
			list = tmpmgManager.findAllTmpMg();
			request.getSession().setAttribute("TmpMgs", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("get All TmpMg failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 更新模板
	 * @return String 
	 * @throws Exception
	 */
	public String update() throws Exception
	{
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long templateId = Long.parseLong(id);
		try
		{
			TmpMsg tmpmg = tmpmgManager.findByIdTmpMg(templateId);
			request.setAttribute("tmpmg", tmpmg);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("update TmpMg failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 保存更新模板
	 * @return String 
	 * @throws Exception
	 */
	public String saveOrUpdate()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("template_id");
		Long templateid = Long.parseLong(id);
		tmpmg = tmpmgManager.findByIdTmpMg(templateid);
		tmpmg.setTemplateId(templateid);
//		tmpmg.setRecordId(Long.parseLong(request.getParameter("record_id")));
		tmpmg.setTemplateName(request.getParameter("template_name"));
		tmpmg.setTemplateFname(request.getParameter("template_fname"));
		tmpmg.setTemplateFormat(request.getParameter("template_format"));
		tmpmg.setCaFile(request.getParameter("ca_file"));
		tmpmg.setVaultTmpFile(request.getParameter("vault_tmp_file"));
		tmpmg.setMailTmpFile(request.getParameter("mail_tmp_file"));
		tmpmg.setCheckTmpFile(request.getParameter("check_tmp_file"));
		tmpmg.setMsgNumber(Long.valueOf(request.getParameter("msg_number")));
		tmpmg.setPicNumber(Long.valueOf(request.getParameter("pic_number")));
		tmpmg.setTmpDesc(request.getParameter("tmp_desc"));
		tmpmg.setChgDatetime(new Date());
		
		try
		{
			tmpmgManager.saveTmpMg(tmpmg);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("saveOrupdate Tmpmg failure", ex);
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception 
	{
		return null;
	}

	public String getCa_file() {
		return ca_file;
	}

	public void setCa_file(String ca_file) {
		this.ca_file = ca_file;
	}

	public String getCheck_tmp_file() {
		return check_tmp_file;
	}

	public void setCheck_tmp_file(String check_tmp_file) {
		this.check_tmp_file = check_tmp_file;
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

	public Date getCrate_datetime() {
		return crate_datetime;
	}

	public void setCrate_datetime(Date crate_datetime) {
		this.crate_datetime = crate_datetime;
	}

	public String getCreat_author() {
		return creat_author;
	}

	public void setCreat_author(String creat_author) {
		this.creat_author = creat_author;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getMail_tmp_file() {
		return mail_tmp_file;
	}

	public void setMail_tmp_file(String mail_tmp_file) {
		this.mail_tmp_file = mail_tmp_file;
	}

	public long getMsg_number() {
		return msg_number;
	}

	public void setMsg_number(long msg_number) {
		this.msg_number = msg_number;
	}

	public long getPic_number() {
		return pic_number;
	}

	public void setPic_number(long pic_number) {
		this.pic_number = pic_number;
	}

	public long getRecord_id() {
		return record_id;
	}

	public void setRecord_id(long record_id) {
		this.record_id = record_id;
	}

	public String getTemplate_fname() {
		return template_fname;
	}

	public void setTemplate_fname(String template_fname) {
		this.template_fname = template_fname;
	}

	public String getTemplate_format() {
		return template_format;
	}

	public void setTemplate_format(String template_format) {
		this.template_format = template_format;
	}

	public long getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(long template_id) {
		this.template_id = template_id;
	}

	public String getTemplate_name() {
		return template_name;
	}

	public void setTemplate_name(String template_name) {
		this.template_name = template_name;
	}

	public String getTmp_desc() {
		return tmp_desc;
	}

	public void setTmp_desc(String tmp_desc) {
		this.tmp_desc = tmp_desc;
	}


	public ITmpmgManager getTmpmgManager() {
		return tmpmgManager;
	}

	public void setTmpmgManager(ITmpmgManager tmpmgManager) {
		this.tmpmgManager = tmpmgManager;
	}

	public String getVault_tmp_file() {
		return vault_tmp_file;
	}

	public void setVault_tmp_file(String vault_tmp_file) {
		this.vault_tmp_file = vault_tmp_file;
	}

	public TmpMsg getTmpmg() {
		return tmpmg;
	}

	public void setTmpmg(TmpMsg tmpmg) {
		this.tmpmg = tmpmg;
	}
}

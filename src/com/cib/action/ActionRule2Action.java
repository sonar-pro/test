package com.cib.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.cib.model.ActionRule2;
import com.cib.service.IActionRule2Manager;
import com.opensymphony.xwork2.Action;

public class ActionRule2Action implements Action
{
	//地区插页规则的九个属性
	private long adv_action_id;
	private String adv_action_name;
	private String loc_inst_id;
	private String loc_inst_name;
	private String c_city;
	private String creat_author;
	private Date crate_datetime;
	private String chg_author;
	private Date chg_datetime;
	
	private List list;
	private IActionRule2Manager actionRule2Manager;
	private ActionRule2 actionRule2 = new ActionRule2();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(ActionRule2Action.class);
	
	/**
	 * @function 保存个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		log.debug("ActionRule2Action save ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		actionRule2.setAdvActionId(Long.valueOf(adv_action_id));
		actionRule2.setAdvActionName(adv_action_name);
		actionRule2.setLocInstId(loc_inst_id);
		actionRule2.setLocInstName(loc_inst_name);
		actionRule2.setCCity(request.getParameter("id"));
//		actionRule2.setCreatAuthor(creat_author);
		actionRule2.setCrateDatetime(new Date());
//		actionRule2.setChgAuthor(chg_author);
//		actionRule2.setChgDatetime(chg_datetime);
		try
		{
			actionRule2Manager.saveActionRule(actionRule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action save ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 删除个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String delete() throws Exception
	{
		log.debug("ActionRule2Action delete ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		try
		{
			ActionRule2 actionrule2 = actionRule2Manager.findByIdActionRule(advActionId);
			actionRule2Manager.deleteActionRule(actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action delete ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 查询个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		log.debug("ActionRule2Action getAll ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			list  = actionRule2Manager.findAllActionRule();
			request.getSession().setAttribute("ActionRule2s", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action getAll ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 更新个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String update() throws Exception
	{
		log.debug("ActionRule2Action update ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		try
		{
			ActionRule2 actionrule2 = actionRule2Manager.findByIdActionRule(advActionId);
			request.getSession().setAttribute("actionrule2", actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action update ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 保存更新个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String saveOrUpdate() throws Exception
	{
		log.debug("ActionRule2Action saveOrUpdate ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		ActionRule2 actionrule2 = actionRule2Manager.findByIdActionRule(advActionId);
		actionrule2.setAdvActionId(Long.valueOf(advActionId));
		actionrule2.setAdvActionName(adv_action_name);
		actionrule2.setLocInstId(loc_inst_id);
		actionrule2.setLocInstName(loc_inst_name);
		actionrule2.setCCity(c_city);
		actionrule2.setCreatAuthor(creat_author);
		actionrule2.setCrateDatetime(crate_datetime);
		actionrule2.setChgAuthor(chg_author);
		actionrule2.setChgDatetime(chg_datetime);
		try
		{
			actionRule2Manager.saveActionRule(actionrule2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRule2Action saveOrUpdate ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception
	{
		return null;
	}

	public IActionRule2Manager getActionRule2Manager() {
		return actionRule2Manager;
	}

	public void setActionRule2Manager(IActionRule2Manager actionRule2Manager) {
		this.actionRule2Manager = actionRule2Manager;
	}

	public long getAdv_action_id() {
		return adv_action_id;
	}

	public void setAdv_action_id(long adv_action_id) {
		this.adv_action_id = adv_action_id;
	}

	public String getAdv_action_name() {
		return adv_action_name;
	}

	public void setAdv_action_name(String adv_action_name) {
		this.adv_action_name = adv_action_name;
	}

	public String getC_city() {
		return c_city;
	}

	public void setC_city(String c_city) {
		this.c_city = c_city;
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

	public String getLoc_inst_id() {
		return loc_inst_id;
	}

	public void setLoc_inst_id(String loc_inst_id) {
		this.loc_inst_id = loc_inst_id;
	}

	public String getLoc_inst_name() {
		return loc_inst_name;
	}

	public void setLoc_inst_name(String loc_inst_name) {
		this.loc_inst_name = loc_inst_name;
	}

	public ActionRule2 getActionRule2() {
		return actionRule2;
	}

	public void setActionRule2(ActionRule2 actionRule2) {
		this.actionRule2 = actionRule2;
	}
}

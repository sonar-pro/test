package com.cib.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.cib.model.ActionRule;
import com.cib.service.IActionRuleManager;
import com.opensymphony.xwork2.Action;

/**
 * @function 模板action
 * @author wqs
 * @version 1.0
 */
public class ActionRuleAction implements Action
{
	//个性化插页规则19个属性
	private long adv_action_id;
	private String adv_action_name;
	private String psn_inst_id;
	private String psn_inst_name;
	private String c_birthmonth;
	private String c_sex;
	private long c_year_max;
	private long c_year_min;
	private long c_new_point_max;
	private long c_new_point_min;
	private long c_credit_max;
	private long c_credit_min;
	private long c_leftcredit_max;
	private long c_leftcredit_min;
	private String c_card_type;
	private String creat_author;
	private Date crate_datetime;
	private String chg_author;
	private Date chg_datetime;
	
	private List list = new ArrayList();
	private IActionRuleManager actionManager;
	private ActionRule actionRule = new ActionRule();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(ActionRuleAction.class);
	
	/**
	 * @function 保存个性化插页规则信息
	 * @return String 
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		log.debug("ActionRuleAction save ActionRule start");
		actionRule.setAdvActionId(Long.valueOf(adv_action_id));
		actionRule.setAdvActionName(adv_action_name);
		actionRule.setPsnInstId(psn_inst_id);
		actionRule.setPsnInstName(psn_inst_name);
//		actionRule.setCBirthmoth(c_birthmoth);
		actionRule.setCSex(c_sex);
		actionRule.setCYearMax(Long.valueOf(c_year_max));
		actionRule.setCYearMin(Long.valueOf(c_year_min));
		actionRule.setCNewPointMax(Long.valueOf(c_new_point_max));
		actionRule.setCNewPointMin(Long.valueOf(c_new_point_min));
		actionRule.setCCreditMax(Long.valueOf(c_credit_max));
		actionRule.setCCreditMin(Long.valueOf(c_credit_min));
		actionRule.setCLeftcreditMax(Long.valueOf(c_leftcredit_max));
		actionRule.setCLeftcreditMin(Long.valueOf(c_leftcredit_min));
//		actionRule.setCCardType(c_card_type);
//		actionRule.setCreatAuthor(creat_author);
		actionRule.setCrateDatetime(new Date());
//		actionRule.setChgAuthor(chg_author);
//		actionRule.setChgDatetime(chg_datetime);
		try
		{
			actionManager.saveActionRule(actionRule);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRuleAction save ActionRule failure", ex);
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
		log.debug("ActionRuleAction delete ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		try
		{
			ActionRule actionrule = actionManager.findByIdActionRule(advActionId);
			actionManager.deleteActionRule(actionrule);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRuleAction delete ActionRule failure", ex);
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
		log.debug("ActionRuleAction getAll ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			list = actionManager.findAllActionRule();
			request.getSession().setAttribute("ActionRules", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRuleAction getAll ActionRule failure", ex);
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
		log.debug("ActionRuleAction update ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		try
		{
			ActionRule actionrule = actionManager.findByIdActionRule(advActionId);
			request.getSession().setAttribute("actionrule", actionrule);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRuleAction update ActionRule failure", ex);
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
		log.debug("ActionRuleAction saveOrUpdate ActionRule start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long advActionId = Long.parseLong(id);
		ActionRule actionrule = actionManager.findByIdActionRule(advActionId);
		
		actionrule.setAdvActionId(Long.valueOf(adv_action_id));
		actionrule.setAdvActionName(adv_action_name);
		actionrule.setPsnInstId(psn_inst_id);
		actionrule.setPsnInstName(psn_inst_name);
		actionrule.setCBirthmonth(c_birthmonth);
		actionrule.setCSex(c_sex);
		actionrule.setCYearMax(Long.valueOf(c_year_max));
		actionrule.setCYearMin(Long.valueOf(c_year_min));
		actionrule.setCNewPointMax(Long.valueOf(c_new_point_max));
		actionrule.setCNewPointMin(Long.valueOf(c_new_point_min));
		actionrule.setCCreditMax(Long.valueOf(c_credit_max));
		actionrule.setCCreditMin(Long.valueOf(c_credit_min));
		actionrule.setCLeftcreditMax(Long.valueOf(c_leftcredit_max));
		actionrule.setCLeftcreditMin(Long.valueOf(c_leftcredit_min));
		actionrule.setCCardType(c_card_type);
		actionrule.setCreatAuthor(creat_author);
		actionrule.setCrateDatetime(crate_datetime);
		actionrule.setChgAuthor(chg_author);
		actionrule.setChgDatetime(new Date());
		try
		{
			actionManager.saveActionRule(actionrule);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRuleAction saveOrUpdate ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 获取所有分行名称
	 * @return String 
	 * @throws Exception
	 */
	public String getAllBank() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			List list2=actionManager.findAllBanks();
			for (int i = 0;i<list2.size();)
			{  
				List lastList = new ArrayList();
			    int len=0;
			    while(i<list2.size()&& len<8){
				    lastList.add(list2.get(i));
				    i++;
				    len++;
			 }
				list.add(lastList);
			}
			request.getSession().setAttribute("banks", list);
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("ActionRuleAction getAllCity ActionRule failure",re);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 获取所有城市实体
	 * @return String 
	 * @throws Exception
	 */
	public String getAllCity() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String bankName = request.getParameter("id");
		System.out.println(bankName);
		try
		{
			List list2 = actionManager.findAllCitys(bankName);
			for (int i = 0;i<list2.size();)
			{  
				List lastList = new ArrayList();
			    int len=0;
			    while(i<list2.size()&& len<4){
				    lastList.add(list2.get(i));
				    i++;
				    len++;
			 }
				list.add(lastList);
			}
			request.getSession().setAttribute("citys", list);
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("ActionRuleAction getAllCity ActionRule failure", re);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 获取所有产品名称
	 * @return String 
	 * @throws Exception
	 */
	public String getAllPro() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			List list2 = actionManager.findAllPros();
			for (int i = 0;i<list2.size();)
			{  
				List lastList = new ArrayList();
			    int len=0;
			    while(i<list2.size()&& len < 4){
				    lastList.add(list2.get(i));
				    i++;
				    len++;
			 }
				list.add(lastList);
			}
			request.getSession().setAttribute("products", list);
		} catch (RuntimeException re)
		{
			re.printStackTrace();
			log.error("ActionRuleAction getAllPro ActionRule failure",re);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 获取所有卡类
	 * @return String 
	 * @throws Exception
	 */
	public String getAllCard() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String cardClass = request.getParameter("id");
		System.out.println(cardClass);
		try
		{
			List list2 = actionManager.findAllCard(cardClass);
			for (int i = 0;i<list2.size();)
			{  
				List lastList = new ArrayList();
			    int len=0;
			    while(i<list2.size()&& len < 4){
				    lastList.add(list2.get(i));
				    i++;
				    len++;
			 }
				list.add(lastList);
			}
			request.getSession().setAttribute("cards", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("ActionRuleAction getAllCard ActionRule failure", ex);
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception 
	{
		return null;
	}

	public IActionRuleManager getActionManager() {
		return actionManager;
	}

	public void setActionManager(IActionRuleManager actionManager) {
		this.actionManager = actionManager;
	}

	public ActionRule getActionRule() {
		return actionRule;
	}

	public void setActionRule(ActionRule actionRule) {
		this.actionRule = actionRule;
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

	public String getC_card_type() {
		return c_card_type;
	}

	public void setC_card_type(String c_card_type) {
		this.c_card_type = c_card_type;
	}

	public long getC_credit_max() {
		return c_credit_max;
	}

	public void setC_credit_max(long c_credit_max) {
		this.c_credit_max = c_credit_max;
	}

	public long getC_credit_min() {
		return c_credit_min;
	}

	public void setC_credit_min(long c_credit_min) {
		this.c_credit_min = c_credit_min;
	}

	public long getC_leftcredit_max() {
		return c_leftcredit_max;
	}

	public void setC_leftcredit_max(long c_leftcredit_max) {
		this.c_leftcredit_max = c_leftcredit_max;
	}

	public long getC_leftcredit_min() {
		return c_leftcredit_min;
	}

	public void setC_leftcredit_min(long c_leftcredit_min) {
		this.c_leftcredit_min = c_leftcredit_min;
	}

	public long getC_new_point_max() {
		return c_new_point_max;
	}

	public void setC_new_point_max(long c_new_point_max) {
		this.c_new_point_max = c_new_point_max;
	}

	public long getC_new_point_min() {
		return c_new_point_min;
	}

	public void setC_new_point_min(long c_new_point_min) {
		this.c_new_point_min = c_new_point_min;
	}

	public String getC_sex() {
		return c_sex;
	}

	public void setC_sex(String c_sex) {
		this.c_sex = c_sex;
	}

	public long getC_year_max() {
		return c_year_max;
	}

	public void setC_year_max(long c_year_max) {
		this.c_year_max = c_year_max;
	}

	public long getC_year_min() {
		return c_year_min;
	}

	public void setC_year_min(long c_year_min) {
		this.c_year_min = c_year_min;
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

	public String getPsn_inst_id() {
		return psn_inst_id;
	}

	public void setPsn_inst_id(String psn_inst_id) {
		this.psn_inst_id = psn_inst_id;
	}

	public String getPsn_inst_name() {
		return psn_inst_name;
	}

	public void setPsn_inst_name(String psn_inst_name) {
		this.psn_inst_name = psn_inst_name;
	}

	public String getC_birthmonth() {
		return c_birthmonth;
	}

	public void setC_birthmonth(String c_birthmonth) {
		this.c_birthmonth = c_birthmonth;
	}

}

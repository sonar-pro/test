package com.cib.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import com.cib.model.PrintRule;
import com.cib.service.IPrintRuleManager;
import com.opensymphony.xwork2.Action;

public class PrintRuleAction implements Action
{
	//打印规则的九个属性
	private long prt_rule_id;
	private String prt_rule_name;
	private long template_id;
	private long adv_action_id;
	private String use_flag;
	private String create_author;
	private Date create_datetime;
	private String chg_author;
	private Date chg_datetime;
	
	private List list;
	private IPrintRuleManager printRuleManager;
	private PrintRule printRule = new PrintRule();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(TmpMgAction.class);
	
	/**
	 * @function 保存打印规则
	 * @return String 
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		log.debug("save PrintRuleAction start");
		printRule.setPrtRuleId(Long.valueOf(prt_rule_id));
		printRule.setPrtRuleName(prt_rule_name);
		printRule.setTemplateId(Long.valueOf(template_id));
		printRule.setAdvActionId(Long.valueOf(adv_action_id));
		printRule.setUseFlag(use_flag);
		printRule.setCreateAuthor(create_author);
		printRule.setCreateDatetime(new Date());
		printRule.setChgAuthor(chg_author);
		try
		{
			printRuleManager.savePrintRule(printRule);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("save PrintRuleAction failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 删除打印规则
	 * @return String 
	 * @throws Exception
	 */
	public String delete() throws Exception
	{
		log.debug("delete PrintRuleAction start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long printRuleId = Long.parseLong(id);
		try
		{
			PrintRule printRule = printRuleManager.findByIdPrintRule(printRuleId);
			printRuleManager.deletePrintRule(printRule);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("delete PrintRuleAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 查询打印规则
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		log.debug("findAll PrintRuleAction start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		try
		{
			list = printRuleManager.findAllPrintRule();
			request.getSession().setAttribute("PrintRules", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("get All PrintRuleAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 更新打印规则
	 * @return String 
	 * @throws Exception
	 */
	public String update() throws Exception
	{
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long printRuleId = Long.parseLong(id);
		System.out.println(printRuleId);
		try
		{
			PrintRule printRule = printRuleManager.findByIdPrintRule(printRuleId);
			request.setAttribute("printRule", printRule);
			list = printRuleManager.findAllTemplet();
			request.setAttribute("templetIds", list);
			List list2 = printRuleManager.findAllActive();
			request.setAttribute("activeIds", list2);
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("update PrintRuleAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 保存更新打印规则
	 * @return String 
	 * @throws Exception
	 */
	public String saveOrUpdate()
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("prt_rule_id");
		Long printRuleId = Long.parseLong(id);
		System.out.println(printRuleId);
		printRule = printRuleManager.findByIdPrintRule(printRuleId);
		printRule.setPrtRuleId(printRuleId);
		printRule.setPrtRuleName(request.getParameter("prt_rule_name"));
		printRule.setTemplateId(Long.valueOf(request.getParameter("template_id")));
		printRule.setAdvActionId(Long.valueOf(request.getParameter("adv_action_id")));
		printRule.setUseFlag(request.getParameter("use_flag"));
		printRule.setChgAuthor(request.getParameter("chg_author"));
		printRule.setChgDatetime(new Date());
		try
		{
			printRuleManager.savePrintRule(printRule);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("saveOrupdate PrintRuleAction failure", ex);
		}
		return SUCCESS;
	}
	
	/**
	 * @function 查询模板编号和活动编号
	 * @return String 
	 * @throws Exception
	 */
	public String getAllTempletId() throws Exception
	{
		log.debug("getAllTempletId PrintRuleAction start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		try
		{
			list = printRuleManager.findAllTemplet();
			request.setAttribute("templetIds", list);
			List list2 = printRuleManager.findAllActive();
			request.setAttribute("activeIds", list2);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("getAllTempletId PrintRuleAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 根据模板编号获取模板名称
	 * @return String 
	 * @throws Exception
	 */
	public String getAllTempletName() throws Exception
	{
		log.debug("getAllTempletName PrintRuleAction start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long templetId = Long.parseLong(id);
		try
		{
			list = printRuleManager.findBytemplet(templetId);
			request.setAttribute("templetNames", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("getAllTempletName PrintRuleAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 根据活动编号获取活动名称
	 * @return String 
	 * @throws Exception
	 */
	public String getAllActiveName() throws Exception
	{
		log.debug("getAllActiveName PrintRuleAction start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long activeId = Long.parseLong(id);
		try
		{
			list = printRuleManager.findActive(activeId);
			request.setAttribute("activeNames", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("getAllActiveName PrintRuleAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 根据模板编号获取产品代码
	 * @return String 
	 * @throws Exception
	 */
	public String getAllProductId() throws Exception
	{
		log.debug("getAllProductId PrintRuleAction start");
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long productId = Long.parseLong(id);
		try
		{
			list = printRuleManager.findByProductId(productId);
			/*for (int i = 0;i<list2.size();)
			{  
				List lastList = new ArrayList();
			    int len=0;
			    while(i<list2.size()&& len<4){
				    lastList.add(list2.get(i));
				    i++;
				    len++;
			 }
				list.add(lastList);
			}*/
			request.setAttribute("productIds", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("getAllProductId PrintRuleAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception 
	{
		return null;
	}
	
	public long getAdv_action_id() {
		return adv_action_id;
	}
	public void setAdv_action_id(long adv_action_id) {
		this.adv_action_id = adv_action_id;
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
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	public PrintRule getPrintRule() {
		return printRule;
	}
	public void setPrintRule(PrintRule printRule) {
		this.printRule = printRule;
	}
	public IPrintRuleManager getPrintRuleManager() {
		return printRuleManager;
	}
	public void setPrintRuleManager(IPrintRuleManager printRuleManager) {
		this.printRuleManager = printRuleManager;
	}
	public long getPrt_rule_id() {
		return prt_rule_id;
	}
	public void setPrt_rule_id(long prt_rule_id) {
		this.prt_rule_id = prt_rule_id;
	}
	public String getPrt_rule_name() {
		return prt_rule_name;
	}
	public void setPrt_rule_name(String prt_rule_name) {
		this.prt_rule_name = prt_rule_name;
	}
	public long getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(long template_id) {
		this.template_id = template_id;
	}
	public String getUse_flag() {
		return use_flag;
	}
	public void setUse_flag(String use_flag) {
		this.use_flag = use_flag;
	}
}

package com.cib.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.cib.model.PrintInstitution;
import com.cib.service.IPrintInstManager;
import com.opensymphony.xwork2.Action;

/**
 * @className PrintInstAction
 * @function 打印服务商action
 * @author wqs
 * @version 1.0
 */
public class PrintInstAction implements Action
{
	private long institution_id;
	private String institution_name;
	private String institution_state;
	private String ftp_server;
	private String user_name;
	private String user_pws;
	
	private List list;
	private IPrintInstManager printInstManager;
	private PrintInstitution printInst = new PrintInstitution();
	private static final String SUCCESS = "success";
	private static final Log log = LogFactory.getLog(TmpMgAction.class);
	
	/**
	 * @function 保存打印服务商信息
	 * @return String 
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		printInst.setInstitutionId(Long.valueOf(institution_id));
		printInst.setInstitutionName(institution_name);
		printInst.setInstitutionState(institution_state);
		printInst.setFtpServer(ftp_server);
		printInst.setUserName(user_name);
		printInst.setUserPws(user_pws);
		try
		{
			printInstManager.savePrintInst(printInst);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("save PrintInstAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 删除打印服务商信息
	 * @return String 
	 * @throws Exception
	 */
	public String delete() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long printInstId = Long.valueOf(id);
		try
		{
			PrintInstitution printIns = printInstManager.findByIdPrintInst(printInstId);
			printInstManager.deletePrintInst(printIns);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("delete PrintInstAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 查询打印服务商信息
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest(); 
		
		try
		{
			list = printInstManager.findAllPrintInst();
			request.getSession().setAttribute("PrintInstitutions", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("get All PrintInstAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 更新打印服务商信息
	 * @return String 
	 * @throws Exception
	 */
	public String update() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long printInstId = Long.valueOf(id);
		try
		{
			PrintInstitution printIns = printInstManager.findByIdPrintInst(printInstId);
			request.getSession().setAttribute("printIns", printIns);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("update PrintInstAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 保存更新打印服务商信息
	 * @return String 
	 * @throws Exception
	 */
	public String saveOrUpdate() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long printInstId = Long.parseLong(id);
		PrintInstitution printIns = printInstManager.findByIdPrintInst(printInstId);
		printIns.setInstitutionId(printInstId);
		printIns.setInstitutionName(request.getParameter("institution_name"));
		printIns.setInstitutionState(request.getParameter("institution_state"));
		printIns.setFtpServer(request.getParameter("ftp_server"));
		printIns.setUserName(request.getParameter("user_name"));
		printIns.setUserPws(request.getParameter("user_pws"));
		try
		{
			printInstManager.savePrintInst(printIns);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("saveOrupdate PrintInstAction failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception 
	{
		return null;
	}

	public String getFtp_server() {
		return ftp_server;
	}

	public void setFtp_server(String ftp_server) {
		this.ftp_server = ftp_server;
	}

	public long getInstitution_id() {
		return institution_id;
	}

	public void setInstitution_id(long institution_id) {
		this.institution_id = institution_id;
	}

	public String getInstitution_name() {
		return institution_name;
	}

	public void setInstitution_name(String institution_name) {
		this.institution_name = institution_name;
	}

	public String getInstitution_state() {
		return institution_state;
	}

	public void setInstitution_state(String institution_state) {
		this.institution_state = institution_state;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public PrintInstitution getPrintInst() {
		return printInst;
	}

	public void setPrintInst(PrintInstitution printInst) {
		this.printInst = printInst;
	}

	public IPrintInstManager getPrintInstManager() {
		return printInstManager;
	}

	public void setPrintInstManager(IPrintInstManager printInstManager) {
		this.printInstManager = printInstManager;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pws() {
		return user_pws;
	}

	public void setUser_pws(String user_pws) {
		this.user_pws = user_pws;
	}
}

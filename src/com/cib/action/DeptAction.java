package com.cib.action;

import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;

import com.cib.model.DepartmentMg;
import com.cib.service.IDepartmentManager;
import com.opensymphony.xwork2.Action;

/**
 * @function 部门action
 * @author wqs
 * @version 1.0
 */
public class DeptAction implements Action
{
	//部门的五个属性
	private long dept_id;
	private String dept_name;
	private String dept_state;
	private Date create_date;
	private Date lately_date;
	
	private List list;
	private DepartmentMg dept = new DepartmentMg();
	private IDepartmentManager deptManager;
	private static final Log log = LogFactory.getLog(DeptAction.class);

	/**
	 * @function 保存部门信息
	 * @return String 
	 * @throws Exception
	 */
	public String save() throws Exception
	{
		log.debug("DeptAction save DepartmentMg start");
		
		dept.setDeptId(Long.valueOf(dept_id));
		dept.setDeptName(dept_name);
		dept.setDeptState(dept_state);
		dept.setCreateDate(new Date());
		try
		{
			deptManager.saveDept(dept);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("DeptAction save DepartmentMg failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 删除部门信息
	 * @return String 
	 * @throws Exception
	 */
	public String delete() throws Exception
	{
		log.debug(" DeptAction delete DepartmentMg start");
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long deptId = Long.parseLong(id);
		try
		{
			dept = deptManager.findByIdDept(deptId);
			if (dept != null)
			{
				deptManager.deleteDept(dept);
				log.debug("DeptAction delete DepartmentMg successful");
			}
			else
			{
				System.out.println("not found DepartmentMg");
			}
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("DeptAction delete DepartmentMg failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 查询部门信息
	 * @return String 
	 * @throws Exception
	 */
	public String getAll() throws Exception
	{
		log.debug("DeptAction getAll DepartmentMg start");
		HttpServletRequest request = ServletActionContext.getRequest();
		try
		{
			list = deptManager.findAllDept();
			request.getSession().setAttribute("DepartmentMgs", list);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("DeptAction getAll DepartmentMg failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 更新部门信息
	 * @return String 
	 * @throws Exception
	 */
	public String update() throws Exception
	{
		HttpServletRequest request  = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		Long deptId = Long.parseLong(id);
		try
		{
			dept = deptManager.findByIdDept(deptId);
			request.setAttribute("dept", dept);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("DeptAction update DepartmentMg failure", ex);
			throw ex;
		}
		return SUCCESS;
	}
	
	/**
	 * @function 保存更新部门信息
	 * @return String 
	 * @throws Exception
	 */
	public String saveOrUpdate() throws Exception
	{
		HttpServletRequest request = ServletActionContext.getRequest();
		
		String id = request.getParameter("dept_id");
		Long deptId = Long.parseLong(id);
		dept = deptManager.findByIdDept(deptId);
		
		dept.setDeptId(Long.parseLong(request.getParameter("dept_id")));
		dept.setDeptName(request.getParameter("dept_name"));
		dept.setDeptState(request.getParameter("dept_state"));
		dept.setLatelyDate(new Date());
		
		try
		{
			deptManager.saveDept(dept);
		} catch (Exception ex)
		{
			ex.printStackTrace();
			log.error("DeptAction saveOrUpdate DepartmentMg failure", ex);
		}
		return SUCCESS;
	}
	
	public String execute() throws Exception 
	{
		return null;
	}

	public IDepartmentManager getDeptManager() {
		return deptManager;
	}

	public void setDeptManager(IDepartmentManager deptManager) {
		this.deptManager = deptManager;
	}
	
	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public DepartmentMg getDept() {
		return dept;
	}

	public void setDept(DepartmentMg dept) {
		this.dept = dept;
	}

	public Long getDept_id() {
		return dept_id;
	}

	public void setDept_id(Long dept_id) {
		this.dept_id = dept_id;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getDept_state() {
		return dept_state;
	}

	public void setDept_state(String dept_state) {
		this.dept_state = dept_state;
	}

	public Date getLately_date() {
		return lately_date;
	}

	public void setLately_date(Date lately_date) {
		this.lately_date = lately_date;
	}
}

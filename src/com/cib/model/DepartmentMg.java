package com.cib.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门管理实体--部门管理表
 * DepartmentMg generated by MyEclipse Persistence Tools
 */

public class DepartmentMg implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 2704203178242180937L;

	private Long deptId;

	private String deptName;

	private String deptState;

	private Date createDate;

	private Date latelyDate;

	private Set userMgs = new HashSet(0);

	// Constructors

	/** default constructor */
	public DepartmentMg() {
	}

	/** minimal constructor */
	public DepartmentMg(Long deptId) {
		this.deptId = deptId;
	}

	/** full constructor */
	public DepartmentMg(Long deptId, String deptName, String deptState,
			Date createDate, Date latelyDate, Set userMgs) {
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptState = deptState;
		this.createDate = createDate;
		this.latelyDate = latelyDate;
		this.userMgs = userMgs;
	}

	// Property accessors

	public Long getDeptId() {
		return this.deptId;
	}

	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return this.deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptState() {
		return this.deptState;
	}

	public void setDeptState(String deptState) {
		this.deptState = deptState;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLatelyDate() {
		return this.latelyDate;
	}

	public void setLatelyDate(Date latelyDate) {
		this.latelyDate = latelyDate;
	}

	public Set getUserMgs() {
		return this.userMgs;
	}

	public void setUserMgs(Set userMgs) {
		this.userMgs = userMgs;
	}

}
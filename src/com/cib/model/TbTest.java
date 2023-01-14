package com.cib.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TbTest entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tb_test", catalog = "wmsite")
public class TbTest implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;

	// Constructors

	/** default constructor */
	public TbTest() {
	}

	/** full constructor */
	public TbTest(String name) {
		this.name = name;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 11)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
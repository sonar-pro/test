package com.cib.model;

/**
 * 产品代码列实体--产品代码列表
 * CardTypeDic generated by MyEclipse Persistence Tools
 */

public class CardTypeDic implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1779492542576595907L;

	private String cardCode;

	private String cardType;

	private String cardClass;

	// Constructors

	/** default constructor */
	public CardTypeDic() {
	}

	/** minimal constructor */
	public CardTypeDic(String cardCode) {
		this.cardCode = cardCode;
	}

	/** full constructor */
	public CardTypeDic(String cardCode, String cardType, String cardClass) {
		this.cardCode = cardCode;
		this.cardType = cardType;
		this.cardClass = cardClass;
	}

	// Property accessors

	public String getCardCode() {
		return this.cardCode;
	}

	public void setCardCode(String cardCode) {
		this.cardCode = cardCode;
	}

	public String getCardType() {
		return this.cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardClass() {
		return this.cardClass;
	}

	public void setCardClass(String cardClass) {
		this.cardClass = cardClass;
	}

}
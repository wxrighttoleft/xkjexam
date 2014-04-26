package com.zyexam.entity;

/**
 * Objects entity. @author MyEclipse Persistence Tools
 */

public class Objects implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 7786347981575674295L;
	private Integer OId;
	private String OName;


	// Property accessors

	public Integer getOId() {
		return this.OId;
	}

	public void setOId(Integer OId) {
		this.OId = OId;
	}

	public String getOName() {
		return this.OName;
	}

	public void setOName(String OName) {
		this.OName = OName;
	}

}
package com.zyexam.entity;


public class Subjects implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -1069214547769247611L;
	private Integer sjId;
	private String sjName;


	// Property accessors

	public Integer getSjId() {
		return this.sjId;
	}

	public void setSjId(Integer sjId) {
		this.sjId = sjId;
	}

	public String getSjName() {
		return this.sjName;
	}

	public void setSjName(String sjName) {
		this.sjName = sjName;
	}

}
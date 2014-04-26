package com.zyexam.entity;


public class TestContentQuestions implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 5884203365409840351L;
	private Integer tcqId;
	private Integer tcqTqId;
	private Integer tcqQId;


	// Property accessors

	public Integer getTcqId() {
		return this.tcqId;
	}

	public void setTcqId(Integer tcqId) {
		this.tcqId = tcqId;
	}

	public Integer getTcqTqId() {
		return this.tcqTqId;
	}

	public void setTcqTqId(Integer tcqTqId) {
		this.tcqTqId = tcqTqId;
	}

	public Integer getTcqQId() {
		return this.tcqQId;
	}

	public void setTcqQId(Integer tcqQId) {
		this.tcqQId = tcqQId;
	}

}
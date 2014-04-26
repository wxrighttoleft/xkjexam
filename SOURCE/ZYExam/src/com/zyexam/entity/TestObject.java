package com.zyexam.entity;


public class TestObject implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 7591816097146431254L;
	private Integer toId;
	private Integer toTqId;
	private Integer toUser;
	private Integer toState;


	// Property accessors

	public Integer getToId() {
		return this.toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public Integer getToTqId() {
		return this.toTqId;
	}

	public void setToTqId(Integer toTqId) {
		this.toTqId = toTqId;
	}

	public Integer getToUser() {
		return this.toUser;
	}

	public void setToUser(Integer toUser) {
		this.toUser = toUser;
	}

	public Integer getToState() {
		return this.toState;
	}

	public void setToState(Integer toState) {
		this.toState = toState;
	}

}
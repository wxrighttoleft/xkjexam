package com.zyexam.entity;



public class Questions implements java.io.Serializable {

	private static final long serialVersionUID = 1197255112324832873L;
	// Fields

	private Integer qtId;
	private String qtContent;
	private String qtOptionA;
	private String qtOptionB;
	private String qtOptionC;
	private String qtOptionD;
	private Subjects qtSubject;
	private Objects qtObject;
	private String qtResult;
	
	public Integer getQtId() {
		return qtId;
	}
	public void setQtId(Integer qtId) {
		this.qtId = qtId;
	}
	public String getQtContent() {
		return qtContent;
	}
	public void setQtContent(String qtContent) {
		this.qtContent = qtContent;
	}
	public String getQtOptionA() {
		return qtOptionA;
	}
	public void setQtOptionA(String qtOptionA) {
		this.qtOptionA = qtOptionA;
	}
	public String getQtOptionB() {
		return qtOptionB;
	}
	public void setQtOptionB(String qtOptionB) {
		this.qtOptionB = qtOptionB;
	}
	public String getQtOptionC() {
		return qtOptionC;
	}
	public void setQtOptionC(String qtOptionC) {
		this.qtOptionC = qtOptionC;
	}
	public String getQtOptionD() {
		return qtOptionD;
	}
	public void setQtOptionD(String qtOptionD) {
		this.qtOptionD = qtOptionD;
	}
	public Subjects getQtSubject() {
		return qtSubject;
	}
	public void setQtSubject(Subjects qtSubject) {
		this.qtSubject = qtSubject;
	}
	public Objects getQtObject() {
		return qtObject;
	}
	public void setQtObject(Objects qtObject) {
		this.qtObject = qtObject;
	}
	public String getQtResult() {
		return qtResult;
	}
	public void setQtResult(String qtResult) {
		this.qtResult = qtResult;
	}

	// Property accessors


}
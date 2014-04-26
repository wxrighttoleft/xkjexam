package com.zyexam.entity;


public class TestResult implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = 8211438974635850299L;
	private Integer trId;
	private SysUsers trUser;
	private Integer trResult;
	private TestQuestions testQuestions;
	private String trMark;


	// Property accessors

	public Integer getTrId() {
		return this.trId;
	}

	public void setTrId(Integer trId) {
		this.trId = trId;
	}


	public SysUsers getTrUser() {
		return trUser;
	}

	public void setTrUser(SysUsers trUser) {
		this.trUser = trUser;
	}

	public Integer getTrResult() {
		return this.trResult;
	}

	public void setTrResult(Integer trResult) {
		this.trResult = trResult;
	}

	public TestQuestions getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(TestQuestions testQuestions) {
		this.testQuestions = testQuestions;
	}

	public String getTrMark() {
		return trMark;
	}

	public void setTrMark(String trMark) {
		this.trMark = trMark;
	}
	

}
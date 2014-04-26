package com.zyexam.entity;

import java.util.Date;
import java.util.List;


public class TestQuestions implements java.io.Serializable {

	// Fields

	private static final long serialVersionUID = -2902735201428606530L;
	private Integer tqId;
	private String tqName;
	private Integer tqFullMark;
	private Integer tqContentNum;
	private Date tqStartTime;
	private Date tqEndTime;
	private List<Questions> questionsList;
	private List<SysUsers> testAnthor;

	// Property accessors

	public Integer getTqId() {
		return this.tqId;
	}

	public void setTqId(Integer tqId) {
		this.tqId = tqId;
	}

	public String getTqName() {
		return this.tqName;
	}

	public void setTqName(String tqName) {
		this.tqName = tqName;
	}

	public Integer getTqFullMark() {
		return this.tqFullMark;
	}

	public void setTqFullMark(Integer tqFullMark) {
		this.tqFullMark = tqFullMark;
	}

	public Integer getTqContentNum() {
		return this.tqContentNum;
	}

	public void setTqContentNum(Integer tqContentNum) {
		this.tqContentNum = tqContentNum;
	}

	public Date getTqStartTime() {
		return tqStartTime;
	}

	public void setTqStartTime(Date tqStartTime) {
		this.tqStartTime = tqStartTime;
	}

	public Date getTqEndTime() {
		return tqEndTime;
	}

	public void setTqEndTime(Date tqEndTime) {
		this.tqEndTime = tqEndTime;
	}

	public List<Questions> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(List<Questions> questionsList) {
		this.questionsList = questionsList;
	}

	public List<SysUsers> getTestAnthor() {
		return testAnthor;
	}

	public void setTestAnthor(List<SysUsers> testAnthor) {
		this.testAnthor = testAnthor;
	}
	
}
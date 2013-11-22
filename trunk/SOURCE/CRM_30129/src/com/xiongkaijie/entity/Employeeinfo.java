package com.xiongkaijie.entity;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Employeeinfo entity. @author MyEclipse Persistence Tools
 */

public class Employeeinfo implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8500838020734050425L;
	private Integer empid;
	private String emploginName;
	private String emploginPwd;
	private String empname;
	private Integer empsex;
	private Date empbirthday;
	private String empAddress;
	private String emptel;
	private String empmobel;
	private String empqq;
	private String empremark;

	// Constructors

	/** default constructor */
	public Employeeinfo() {
	}

	/** minimal constructor */
	public Employeeinfo(String emploginName, String emploginPwd, String empname) {
		this.emploginName = emploginName;
		this.emploginPwd = emploginPwd;
		this.empname = empname;
	}

	/** full constructor */
	public Employeeinfo(String emploginName, String emploginPwd,
			String empname, Integer empsex, Timestamp empbirthday,
			String empAddress, String emptel, String empmobel, String empqq,
			String empremark) {
		this.emploginName = emploginName;
		this.emploginPwd = emploginPwd;
		this.empname = empname;
		this.empsex = empsex;
		this.empbirthday = empbirthday;
		this.empAddress = empAddress;
		this.emptel = emptel;
		this.empmobel = empmobel;
		this.empqq = empqq;
		this.empremark = empremark;
	}

	// Property accessors

	public Integer getEmpid() {
		return this.empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getEmploginName() {
		return this.emploginName;
	}

	public void setEmploginName(String emploginName) {
		this.emploginName = emploginName;
	}

	public String getEmploginPwd() {
		return this.emploginPwd;
	}

	public void setEmploginPwd(String emploginPwd) {
		this.emploginPwd = emploginPwd;
	}

	public String getEmpname() {
		return this.empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Integer getEmpsex() {
		return this.empsex;
	}

	public void setEmpsex(Integer empsex) {
		this.empsex = empsex;
	}

	public Date getEmpbirthday() {
		return empbirthday;
	}

	public void setEmpbirthday(Date empbirthday) {
		this.empbirthday = empbirthday;
	}

	public String getEmpAddress() {
		return this.empAddress;
	}

	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}

	public String getEmptel() {
		return this.emptel;
	}

	public void setEmptel(String emptel) {
		this.emptel = emptel;
	}

	public String getEmpmobel() {
		return this.empmobel;
	}

	public void setEmpmobel(String empmobel) {
		this.empmobel = empmobel;
	}

	public String getEmpqq() {
		return this.empqq;
	}

	public void setEmpqq(String empqq) {
		this.empqq = empqq;
	}

	public String getEmpremark() {
		return this.empremark;
	}

	public void setEmpremark(String empremark) {
		this.empremark = empremark;
	}

}
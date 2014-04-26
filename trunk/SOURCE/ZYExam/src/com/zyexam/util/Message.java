package com.zyexam.util;

public class Message {
	private int id;
	private String target;
	private String message;
	private boolean ls;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isLs() {
		return ls;
	}
	public void setLs(boolean ls) {
		this.ls = ls;
	}
}

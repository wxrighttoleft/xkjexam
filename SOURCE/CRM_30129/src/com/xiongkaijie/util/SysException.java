package com.xiongkaijie.util;

public class SysException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public SysException(String s){
		super(s);
	}
	public SysException(Throwable e){
		super(e);
	}

}

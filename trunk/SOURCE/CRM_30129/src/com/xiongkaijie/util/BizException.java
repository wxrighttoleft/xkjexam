package com.xiongkaijie.util;

public class BizException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public BizException(String s){
		super(s);
	}
	public BizException(Throwable e){
		super(e);
	}

}

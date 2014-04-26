package com.zyexam.web.interceptors;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zyexam.common.Constant;

public class StuExamInterceptor extends MethodFilterInterceptor {

	private static final long serialVersionUID = 8622559182763819249L;

	@Override
	protected String doIntercept(ActionInvocation ai) throws Exception {
		// TODO 学生考试登陆拦截
		// 从session中得到存入stuAnthor的值
		String result = "";
		Object obj = ServletActionContext.getRequest().getSession().getAttribute(Constant.STU_ANTHOR);
		if(obj != null){
			result = ai.invoke();
		}else{
			result = "doError";
		}
		return result;
	}

}

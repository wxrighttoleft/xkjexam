package com.xiongkaijie.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiongkaijie.util.Constant;

public class CAPTCHAEfficacyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// 得到用户输入的验证码文本
		String captcha1 = request.getParameter("yzmText");
		// 得到Session中存放的验证码文本
		String captcha2 = request.getSession().getAttribute(Constant.SESSION_YAN).toString();
		// 比较两个验证码是否相同
		if(captcha1.equals(captcha2)){
			out.print(true);
		}else{
			out.print(false);
		}
		out.flush();
		out.close();
	}

}

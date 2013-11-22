package com.xiongkaijie.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiongkaijie.servers.EmpServer;
import com.xiongkaijie.util.Constant;
import com.xiongkaijie.util.LoginUtil;

public class LoginServlet extends HttpServlet implements Constant {


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
		PrintWriter out = response.getWriter();
		//验证验证码
		String userStr = request.getParameter("yzmText");
		String sessionStr = request.getSession().getAttribute(SESSION_YAN).toString();
		if(userStr==null || !userStr.equals(sessionStr)){
			out.print(LoginUtil.LoginError(null,null));
			out.flush();
			out.close();
			return;
		}
		// 获取到用户输入的用户名和密码
		String account = request.getParameter("account");
		String accountPwd = request.getParameter("accountPwd");
		EmpServer empServer = new EmpServer();
		if(!empServer.login(account, accountPwd)){
			out.println(LoginUtil.LoginError(null,null));
			out.flush();
			out.close();
		}
		HttpSession session = request.getSession();
		session.setAttribute(SESSION_LOGIN_AUTHOR, account);
		session.setAttribute("accountPwd", accountPwd);
		response.sendRedirect("./pages/index.jsp");
	}
}

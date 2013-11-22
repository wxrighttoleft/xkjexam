package com.xiongkaijie.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.xiongkaijie.util.Constant;

public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();
		Object obj = session.getAttribute(Constant.SESSION_LOGIN_AUTHOR);
		if(obj == null || "".equals(obj.toString())){
			PrintWriter out = response.getWriter();
			out.print("<html><head>");
			out.print("<meta http-equiv='content-type' content='text/html; charset=UTF-8'/>");
			out.print("<script type='text/javascript'>");
			out.print("alert('您没有权限访问，请先登录!');");
			out.print("location.href='/CRM_30129/logon.jsp';");
			out.print("</script>");
			out.print("</head><body></body></html>");
		}
		else{
			fc.doFilter(request, response);
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}

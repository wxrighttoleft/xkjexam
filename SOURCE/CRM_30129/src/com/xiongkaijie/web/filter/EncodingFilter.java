package com.xiongkaijie.web.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.xiongkaijie.util.BizException;
import com.xiongkaijie.util.Constant;
import com.xiongkaijie.util.LoginUtil;
import com.xiongkaijie.util.SysException;

public class EncodingFilter implements Filter,Constant {
	private String encoding = "UTF-8";
	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain fc) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding(this.encoding);
		response.setCharacterEncoding(this.encoding);
		HttpSession session = req.getSession();
		String urlPath = req.getHeader("referer");
		Object obj = session.getAttribute(SESSION_ADDRESS_USER);
		String ipAddress = req.getRemoteAddr();
		session.setAttribute(IPINFO, ipAddress);
		if(obj == null){
			session.setAttribute(SESSION_ADDRESS_USER, true);
			//  计数
			ServletContext app = session.getServletContext();
			Integer num = (Integer)app.getAttribute(SESSION_WEB_COUNT);
			if(num == null){
				num = 0;
			}
			num++;
			app.setAttribute(SESSION_WEB_COUNT, num);
		}
		try{
		fc.doFilter(req, response);
		}catch(Exception e){
			if(e instanceof SysException){
				Logger log = Logger.getLogger(this.getClass());
				log.error(e.getMessage(), e);
				PrintWriter out = response.getWriter();
				out.print(LoginUtil.LoginError(e.getMessage(),urlPath));
				out.flush();
				out.close();
			}
			if(e instanceof BizException){
				PrintWriter out = response.getWriter();
				out.print(LoginUtil.LoginError(e.getMessage(),urlPath));
				out.flush();
				out.close();
			}
		}
	}

	public void init(FilterConfig fc) throws ServletException {
		String ed = fc.getInitParameter("encoding");
		if(ed != null && "".equals(ed)){
			this.encoding = ed;
		}
	}

}

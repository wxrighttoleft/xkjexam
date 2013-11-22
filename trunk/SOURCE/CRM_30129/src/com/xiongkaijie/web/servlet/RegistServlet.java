package com.xiongkaijie.web.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xiongkaijie.entity.Employeeinfo;
import com.xiongkaijie.servers.EmpServer;
import com.xiongkaijie.util.LoginUtil;
import com.xiongkaijie.util.SysException;

public class RegistServlet extends HttpServlet {

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
		//获取参数
		Employeeinfo emp = new Employeeinfo();
		emp.setEmploginName(request.getParameter("account"));
		emp.setEmploginPwd(request.getParameter("accountPwd"));
		emp.setEmpname(request.getParameter("accountName"));
		emp.setEmpsex(Integer.valueOf(request.getParameter("sex")));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			emp.setEmpbirthday(sdf.parse(request.getParameter("birthdayYear")+"-"+request.getParameter("birthdayMonth")+"-"+request.getParameter("birthdayDay")));
		} catch (ParseException e) {
			throw new SysException(e);
		}
		emp.setEmpAddress(request.getParameter("Address"));
		emp.setEmptel(request.getParameter("Tel"));
		emp.setEmpmobel(request.getParameter("Mobel"));
		emp.setEmpqq(request.getParameter("QQ"));
		emp.setEmpremark("");
		//调用服务
		EmpServer empServer = new EmpServer();
		boolean bo = empServer.regist(emp);
		if(bo == true){
			LoginUtil.LoginError("注册成功！", "./login.jsp");
		}else{
			LoginUtil.LoginError("注册失败，请填写正确信息", "./regist.jsp");
		}
	}

}

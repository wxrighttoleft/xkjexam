package com.xiongkaijie.web.servlet.emp;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xiongkaijie.entity.EmployeeZ;
import com.xiongkaijie.pers.EmployeeDAO;
import com.xiongkaijie.util.Constant;
import com.xiongkaijie.util.PageInfo;

public class ScanServlet extends HttpServlet {

	
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
		//查询员工信息
		EmployeeDAO empDAO = new EmployeeDAO();
		PageInfo pi = (PageInfo)request.getSession().getAttribute(Constant.PAGEINFO);
		if(pi == null){
			pi = new PageInfo();
		}
		int val = Integer.valueOf(request.getParameter("fPageButton").toString());
		if(val == 1){
			if(pi.getCurrentPage() < pi.getPageCount()){
				pi.setCurrentPage(pi.getCurrentPage() + 1);
			}
		}
		else if(val == - 1){
			if(pi.getCurrentPage() > 1){
				pi.setCurrentPage(pi.getCurrentPage() - 1);
			}
		}
		List<EmployeeZ> empList = empDAO.getAllEmpInfo(null,pi);
		//将查到的员工信息反映到客户端
		HttpSession session = request.getSession();
		session.setAttribute(Constant.PAGEINFO, pi);
		session.setAttribute("empList", empList);
		response.sendRedirect("/CRM_30129/pages/emp/scan.jsp");
	}

}

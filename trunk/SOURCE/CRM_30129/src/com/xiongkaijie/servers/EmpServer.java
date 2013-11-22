package com.xiongkaijie.servers;

import com.xiongkaijie.entity.EmployeeZ;
import com.xiongkaijie.entity.Employeeinfo;
import com.xiongkaijie.pers.EmployeeDAO;
import com.xiongkaijie.util.BizException;

public class EmpServer {
	private EmployeeDAO empDAO = new EmployeeDAO();
	public EmployeeDAO getEmpDAO() {
		return empDAO;
	}
	public void setEmpDAO(EmployeeDAO empDAO) {
		this.empDAO = empDAO;
	}
	/**
	 * 员工登陆验证
	 * =_=zly
	 * @author Administrator
	 * @createDate 2013-10-31下午4:00:07
	 * @param account
	 * @param password
	 * @return
	 */
	public boolean login(String account, String password){
		boolean bo = false;
		EmployeeZ emp = null;
		emp = empDAO.getEmpByAccout(account);
		if(emp != null){
			if(emp.getEmpLoginPwd().equals(password)){
				bo = true;
			}else{
				throw new BizException("用户名或密码错误");
			}
		}else{
			throw new BizException("用户名或密码错误");
		}
		return bo;
	}
	public boolean regist(Employeeinfo emp){
		boolean bo = false;
		bo = this.empDAO.addEmployee(emp);
		return bo;
	}
}

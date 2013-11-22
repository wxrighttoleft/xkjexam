package com.xiongkaijie.pers;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.xiongkaijie.common.HibernateSessionFactory;
import com.xiongkaijie.entity.EmployeeZ;
import com.xiongkaijie.entity.Employeeinfo;
import com.xiongkaijie.util.BizException;
import com.xiongkaijie.util.IDBUtil;
import com.xiongkaijie.util.OracleDBUtil;
import com.xiongkaijie.util.PageInfo;
import com.xiongkaijie.util.SysException;

public class EmployeeDAO {
	private IDBUtil dbutil = new OracleDBUtil();
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private CallableStatement cs;
	/**
	 * 获取员工信息
	 * @param id 员工ID
	 * @return 返回员工信息
	 */
	public EmployeeZ getEmpByAccout(String id){
		EmployeeZ emp = null;
		try {
			con = this.dbutil.getConn();
			ps = con.prepareStatement("select * from employeeinfo where emploginname = ?");
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				emp = new EmployeeZ();
				emp.setId(rs.getInt(1));
				emp.setEmpLoginName(rs.getString(2));
				emp.setEmpLoginPwd(rs.getString(3));
				emp.setEmpName(rs.getString(4));
				emp.setEmpSex(rs.getInt(5));
				emp.setEmpBirthday(new java.util.Date(rs.getDate(6).getTime()));
				emp.setEmpAddress(rs.getString(7));
				emp.setEmpTel(rs.getString(8));
				emp.setEmpMobel(rs.getString(9));
				emp.setEmpQQ(rs.getString(10));
				emp.setEmpRemark(rs.getString(10));
			}
		} catch (Exception e) {
			throw new SysException(e);
		} finally {
			this.dbutil.close(con, ps, rs);
		}
		return emp;
	}
	
	public List<EmployeeZ> getAllEmpInfo(String when,PageInfo pi) {
		List<EmployeeZ> empList = new ArrayList<EmployeeZ>();
		String sql = "select * from Employeeinfo ";
		if(when != null && "".equals(when)){
			sql += when;
		}
		try {
			con = this.dbutil.getConn();
			cs = con.prepareCall("{? = call page_package.page_select_function(?,?,?,?)}");
			cs.registerOutParameter(1,oracle.jdbc.OracleTypes.CURSOR);
			cs.setString(2, sql);
			cs.setInt(3, pi.getPageSize());
			cs.setInt(4, pi.getCurrentPage());
			cs.registerOutParameter(5, oracle.jdbc.OracleTypes.INTEGER);
			cs.execute();
			pi.setPageCount(cs.getInt(5));
			rs = (ResultSet)cs.getObject(1);
			while(rs.next()){
				EmployeeZ emp = new EmployeeZ();
				emp.setId(rs.getInt(2));
				emp.setEmpLoginName(rs.getString(3));
				emp.setEmpLoginPwd(rs.getString(4));
				emp.setEmpName(rs.getString(5));
				emp.setEmpSex(rs.getInt(6));
				emp.setEmpBirthday(new java.util.Date(rs.getDate(7).getTime()));
				emp.setEmpAddress(rs.getString(8));
				emp.setEmpTel(rs.getString(9));
				emp.setEmpMobel(rs.getString(10));
				emp.setEmpQQ(rs.getString(11));
				emp.setEmpRemark(rs.getString(12));
				empList.add(emp);
			}
		} catch (Exception e) {
			throw new SysException(e);
		}
		return empList;
	}
	/**
	 * =_=zly
	 * 添加员工信息
	 * @author Administrator
	 * @createDate 2013-11-8下午2:45:40
	 * @param emp
	 * @return
	 */
	public boolean addEmployee(Employeeinfo emp){
		boolean bo = false;
		Session session = HibernateSessionFactory.getSession();
		session.beginTransaction();
		try{
		session.save(emp);
		session.beginTransaction().commit();
		bo = true;
		}catch(HibernateException hex){
			session.beginTransaction().rollback();
			throw new BizException(hex);
		}catch(Exception ex){
			session.beginTransaction().rollback();
			throw new SysException(ex);
		}
		session.close();
		return bo;
		
	}
	public void selectAll(){
		Connection conn = this.dbutil.getConn();
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			cs = conn.prepareCall("{? = call XKJ_PACKAGE.XKJ_SELECT_ALLINFO(?)}");
			cs.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
			cs.setString(2, "EMPLOYEEINFO");
			cs.execute();
			rs = (ResultSet)cs.getObject(1);
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		EmployeeDAO ed = new EmployeeDAO();
		ed.selectAll();
	}
}

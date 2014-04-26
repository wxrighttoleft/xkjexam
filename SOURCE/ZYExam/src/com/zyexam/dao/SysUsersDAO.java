package com.zyexam.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.zyexam.util.PageInfo;

public class SysUsersDAO extends HibernateDaoSupport implements IExamDAO {

	/* (non-Javadoc)
	 * 通过sql语句查询
	 * @see com.zyexam.dao.IExamDAO#select(java.lang.String, java.util.List)
	 */
	@SuppressWarnings("rawtypes")
	public List select(String sql, List<Object> paramList) {
		Session session = this.getSession();
		SQLQuery query = session.createSQLQuery(sql);
		if(paramList != null && !paramList.isEmpty()){
			for(int i = 0; i < paramList.size(); i++){
				query.setParameter(i, paramList.get(i));
			}
		}
		List l = query.list();
		return l;
	}

	/* (non-Javadoc)
	 * 通过hql语句查询数据，可分页查询
	 * @see com.zyexam.dao.IExamDAO#select(java.lang.String, java.util.List, com.zyexam.util.PageInfo)
	 */
	@SuppressWarnings("rawtypes")
	public List select(String hql, List<Object> paramList, PageInfo pi) {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		this.setParam(query, paramList);
		if(pi != null){
			String str = "select count(*) ";
			str += hql;
			Query tempQuery = session.createQuery(str);
			this.setParam(tempQuery, paramList);
			pi.setRecordCount(Integer.valueOf(tempQuery.uniqueResult().toString()));
			pi.compute();
			query.setFirstResult(pi.getStartRecord() - 1);
			query.setMaxResults(pi.getPageSize());
		}
		List l = query.list();
		return l;
	}
	/**
	 * 设置query的参数
	 * =_=zly
	 * @author Administrator
	 * @createDate 2014-3-9下午2:40:59
	 * @param query
	 * @param paramList
	 */
	private void setParam(Query query,List<Object> paramList){
		if(paramList != null && !paramList.isEmpty()){
			for(int i = 0; i < paramList.size(); i++){
				query.setParameter(i, paramList.get(i));
			}
		}
	}

	/* (non-Javadoc)
	 * 添加数据
	 * @see com.zyexam.dao.IExamDAO#add(java.lang.Object)
	 */
	public void add(Object obj) {
		Session session = this.getSession();
		session.save(obj);
	}
	

	public int update(String hql, List<Object> paramList) {
		Session session = this.getSession();
		Query query = session.createQuery(hql);
		if(paramList != null && !paramList.isEmpty()){
			for(int i = 0; i < paramList.size(); i++){
				query.setParameter(i, paramList.get(i));
			}
		}
		int num = query.executeUpdate();
		return num;
	}

	public void add(List<Object> objList) {
		Session session = this.getSession();
		for(int i = 0; i < objList.size(); i++){
			session.save(objList.get(i));
		}
	}

}

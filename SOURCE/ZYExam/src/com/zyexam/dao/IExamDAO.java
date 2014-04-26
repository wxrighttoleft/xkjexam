package com.zyexam.dao;

import java.util.List;

import com.zyexam.util.PageInfo;

public interface IExamDAO {
	/**
	 * sql语句查询
	 * =_=zly
	 * @author Administrator
	 * @createDate 2014-3-9下午1:43:47
	 * @param sql sql语句
	 * @param paramList 参数列表
	 */
	@SuppressWarnings("rawtypes")
	public List select(String sql, List<Object> paramList);
	/**
	 * hql语句查询，可分页查询
	 * =_=zly
	 * @author Administrator
	 * @createDate 2014-3-9下午1:44:08
	 * @param hql hql语句
	 * @param paramList 参数列表
	 * @param pi 分页信息
	 */
	@SuppressWarnings("rawtypes")
	public List select(String hql, List<Object> paramList,PageInfo pi);
	/**
	 * 添加数据
	 * =_=zly
	 * @author Administrator
	 * @createDate 2014-3-9下午1:44:28
	 * @param obj 数据源
	 */
	public void add(Object obj);
	public void add(List<Object> objList);
	/**
	 * 删除或修改
	 * =_=zly
	 * @author Administrator
	 * @createDate 2014-3-9下午1:46:58
	 * @param hql hql语句
	 * @param paramList 参数列表
	 */
	public int update(String hql,List<Object> paramList);
}

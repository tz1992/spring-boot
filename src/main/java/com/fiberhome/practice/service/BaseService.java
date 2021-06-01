package com.fiberhome.practice.service;

import java.util.List;
import java.util.Map;


public interface BaseService<T> {

	/**
	 * 获取单条数据
	 * @return
	 */
	public T get(String id);

	
	/**
	 * 查询数据列表，如果需要分页，请设置分页对象
	 * @return
	 */
	public List<T> findAll();
	
	/**
	 * 条件查询数据列表，
	 * @return
	 */
	public List<T> selectByParams(Map<String, Object> params);

	/**
	 * 插入数据
	 * @return
	 */
	public int insert(T entity);


	//批量查询
	List<T> selectBatch(String[] ids);




}  
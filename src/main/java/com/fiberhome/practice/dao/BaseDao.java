package com.fiberhome.practice.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {  

	/**  
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id);
	
	/**
	 * 查询数据列表，
	 * @return
	 */
	public List<T> findList(T entity);
	
	/**z
	 * 条件查询数据列表，
	 * @return
	 */
	public List<T> selectByParams(Map<String, Object> params);

	/**
	 * 条件查询记录数
	 * @return
	 */
	public int count(Map<String, Object> params);

	/**
	 * 插入数据
	 * @param entity
	 * @return
	 */
	public int insert(T entity);

	/**
	 * 更新数据
	 * @param entity
	 * @return
	 */
	public int update(T entity);

	/**
	 * 标记删除数据
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	public int deleteByMark(@Param("id") String id, @Param("DEL_FLAG_DELETE") String DEL_FLAG_DELETE);
	
	/**
	 * 物理删除数据
	 * @param id
	 * @see public int delete(T entity)
	 * @return
	 */
	public int deleteByPhysic(String id);

	/**
	 * 查询数据列表，如果需要分页，请设置分页对象
	 * @return
	 */
	public List<T> findAll();

	/**
	 * 逻辑批量删除
	 *
	 * @param ids
	 * @param DEL_FLAG_DELETE
	 * @return
	 */
	public int bathDelete(@Param("ids") String[] ids, @Param("DEL_FLAG_DELETE") String DEL_FLAG_DELETE);

	public List<T> findPart();

	public void batchImport(@Param("list") List<T> list);

	public T getByMap(Map<String, Object> map);

	public T getTemplate();

	//批量查询
	List<T> selectBatch(@Param("ids") String[] ids);


	/**
	 * 获取单条数据
	 *
	 * @param tableName
	 * @param fieldName
	 * @param key
	 * @return
	 */
	Map getByKey(@Param("tableName") String tableName, @Param("fieldName") String fieldName, @Param("key") String key);
}
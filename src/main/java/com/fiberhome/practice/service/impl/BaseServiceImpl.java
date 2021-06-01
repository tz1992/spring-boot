package com.fiberhome.practice.service.impl;



import com.fiberhome.practice.dao.BaseDao;
import com.fiberhome.practice.service.BaseService;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T> {
	protected BaseDao<T> getDao() {
		return null;
	}

	protected BaseDao<T> baseDao;

	@PostConstruct
	public void init(){
		if(baseDao==null){
			this.baseDao=getDao();
		}
	}



	@Override
	public T get(String id) {
		return this.getDao().get(id);
	}

	@Override
	public List<T> findAll() {
		return baseDao.findAll();
	}

	@Override
	public int insert(T entity) {
		return baseDao.insert(entity);
	}

	@Override
	public List<T> selectByParams(Map<String, Object> params) {
		return baseDao.selectByParams(params);
	}


	@Override
	public List<T> selectBatch(String[] ids) {
		return baseDao.selectBatch(ids);
	}




}
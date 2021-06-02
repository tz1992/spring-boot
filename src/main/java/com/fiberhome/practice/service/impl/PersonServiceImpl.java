package com.fiberhome.practice.service.impl;

import com.fiberhome.practice.dao.PersonDao;
import com.fiberhome.practice.dao.UserDao;
import com.fiberhome.practice.domain.PersonInfo;
import com.fiberhome.practice.domain.User;
import com.fiberhome.practice.service.PersonService;
import com.fiberhome.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl extends BaseServiceImpl<PersonInfo> implements PersonService {


	@Autowired
	public void setBaseDao(PersonDao dao){
		super.baseDao = dao;
	}

	@Autowired
	private PersonDao dao;

}

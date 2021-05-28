package com.fiberhome.practice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiberhome.practice.dao.UserDao;
import com.fiberhome.practice.domain.User;
import com.fiberhome.practice.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
private UserDao dao;

	@Override
	public List<User> getUser() {
		return  dao.getUser();
	}

	@Override
	public void insertUser(User user) {
		dao.insertUser(user);
		
	}

	@Override
	public User getUserById(Integer id) {
		return dao.getUserById(id);
	}

	@Override
	public User getUserByName(String name) {
		System.out.println(name);
		return dao.getUserByName(name);
	
	}

}

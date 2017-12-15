package com.fiberhome.practice.service;

import java.util.List;

import com.fiberhome.practice.domain.User;

public interface UserService {

	List<User> getUser();

	void insertUser(User user);

	User getUserById(Integer id);

	User getUserByName(String name);

}

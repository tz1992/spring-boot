package com.fiberhome.practice.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fiberhome.practice.domain.User;

public interface UserDao {
public List<User> getUser();
public void insertUser(User user);
public User getUserById(@Param("id")Integer id);
public User getUserByName(@Param("name")String name);
}

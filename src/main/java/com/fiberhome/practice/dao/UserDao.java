package com.fiberhome.practice.dao;

import java.util.List;

import com.fiberhome.practice.annocation.TestLog;
import org.apache.ibatis.annotations.Param;

import com.fiberhome.practice.domain.User;

public interface UserDao {
@TestLog(dataType = "01")
public List<User> getUser();
public void insertUser(User user);
public User getUserById(@Param("id")Integer id);
public User getUserByName(@Param("name")String name);
}

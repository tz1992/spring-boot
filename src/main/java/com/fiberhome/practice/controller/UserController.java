package com.fiberhome.practice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiberhome.practice.domain.User;
import com.fiberhome.practice.service.UserService;

import io.swagger.annotations.ApiImplicitParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUser() {
	return 	userService.getUser();
	
	}

	@ApiImplicitParam(name = "user", dataType = "User")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void insertUser(@RequestBody User user) {
		userService.insertUser(user);
	}

	@ApiImplicitParam(name = "id", dataType = "Integer")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Integer id) {
		return userService.getUserById(id);
	}
	@ApiImplicitParam(name = "name", dataType = "String")
	@RequestMapping(value = "/getUserByName/{name}", method = RequestMethod.GET)
	public User getUserByName(@PathVariable("name") String name) {
		return userService.getUserByName(name);
	}
}

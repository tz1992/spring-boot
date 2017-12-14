package com.fiberhome.practice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiberhome.practice.domain.User;

import io.swagger.annotations.ApiImplicitParam;

@RestController
@RequestMapping("/user")
public class UserController {
	public static Map<Integer, User> map = new HashMap<Integer, User>();

	static {
		for (int i = 0; i <= 10; i++) {
			User user = new User(i, "jack" + i);
			map.put(i, user);
		}
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getUser() {
		List<User> list=new ArrayList<User>();
       Iterator<Entry<Integer, User>> iterator=map.entrySet().iterator();
       while (iterator.hasNext()) {
	User user=iterator.next().getValue();
		list.add(user);
	}
       return list;
	}

	@ApiImplicitParam(name = "user", dataType = "User")
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void insertUser(@RequestBody User user) {
		map.put(user.getId(), user);
	}

	@ApiImplicitParam(name = "id", dataType = "Integer")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getUserById(@PathVariable Integer id) {
		return map.get(id);
	}
}

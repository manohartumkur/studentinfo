package com.finonyx.app.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.finonyx.app.model.User;

@Service
public class UserService {

	private static List<User> users = new ArrayList<User>();
	private static Long userCount = 3l;

	static {
		users.add(new User(1l, "manohar", new Date()));
		users.add(new User(2l, "bhargavi", new Date()));
		users.add(new User(3l, "aadvika", new Date()));
	}

	public List<User> retrieveAllUsers() {

		return users;
	}

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	public User findUser(int id) {

		for (User user : users) {

			if (user.getId() == id) {
				return user;
			}
		}

		return null;
	}

	public User deleteUserById(int id) {
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {

			User user = iterator.next();
			if (user.getId() == id) {

				iterator.remove();
				return user;
			}
		}
		return null;
	}

}

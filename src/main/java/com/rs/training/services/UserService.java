package com.rs.training.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.training.jdbc.UserDao;
import com.rs.training.model.User;
import com.rs.training.model.UserDetail;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public boolean loginUser(String username, String password) {
		
		User user = userDao.getUserFromUsername(username);
		if(user!= null && user.getPassword().equals(password)) {
			return true;
		}
		return false;
	}

	public boolean addUser(String username, String password, String confirmPassword) {
		
		User user = userDao.getUserFromUsername(username);
		if(user != null)
		{
			return false;
		}
		else
		{
			User newUser = new User(username, password, confirmPassword);
			return userDao.addUser(newUser);
		}
	}

	public boolean addUser(User user) {
		// TODO Auto-generated method stub
		return addUser(user.getUserName(), user.getPassword(), user.getConfirmPassword());
	}
	
	public boolean checkUsernameExist(String username) {
		User user = userDao.getUserFromUsername(username);
		if(user != null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public boolean addUserDetail(String userName, UserDetail userDetail) {

		return userDao.addUserDetail(userName, userDetail);
	}
	
	public UserDetail getUserDetail(String userName) {
		return userDao.getUserDetail(userName);
	}
	
}

package com.rs.training.validators;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.rs.training.model.User;
import com.rs.training.services.UserService;

@Component
public class UserValidator implements Validator {

	@Autowired
	UserService userService;
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object object, Errors errors) {

		if(object instanceof  User)
		{
			User user = (User)object;
/*			if(userService.checkUsernameExist(user.getUserName()))
			{
				errors.rejectValue("userName", "user.userName.exist");
			}*/
			if(!user.getPassword().equals(user.getConfirmPassword()))
			{
				errors.rejectValue("confirmPassword", "user.confirmPassword.match");
			}
		}
		
	}

}

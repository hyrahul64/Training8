package com.rs.training;

import java.security.acl.Permission;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserValidator userValidator;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home( Model model) {
		return "home";
	}
	
	@RequestMapping(value = "loginUser", method = RequestMethod.POST)
	public String loginUser(Locale locale, Model model, @ModelAttribute User user) {
		
		if(userService.loginUser(user.getUserName(), user.getPassword()))
		{
			model.addAttribute("userName", user.getUserName());

			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate );
			
			return "welcomUser";
		}
		else
		{
			return "home";
		}
		
	}
	
	@RequestMapping(value = "submitUser", method = RequestMethod.POST)
	public String submitUser(Locale locale, Model model,
			@Valid @ModelAttribute("user") User user,
			BindingResult results
			
			/*@RequestParam(value = "userName", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "confirmPassword", required = false) String confirmPassword*/) {
		
		
		userValidator.validate(user, results);
		if(results.hasErrors())
		{
			return "createUser";
		}
		if(userService.addUser(user))
		{
			model.addAttribute("userName", user.getUserName());

			Date date = new Date();
			DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
			String formattedDate = dateFormat.format(date);
			model.addAttribute("serverTime", formattedDate );
			logger.info("User created.");
			return "welcomUser";
		}
		else
		{
			return "createUser";
		}
	}
	
}

package com.security.controllers;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.security.model.User;
import com.security.service.UserServiceImpl;

@RestController
public class UserController {
	
	@Autowired
	private UserServiceImpl userService ;
	
	/**
	* show Register Page at browser when /register is fired
	* @return UI Page UserRegister.html
	*/
	@GetMapping("/register")
	public ModelAndView showReg() {
		ModelAndView model = new ModelAndView();
		model.setViewName("UserRegister");
		return model;
	}
	
	/**
	 * This method takes 2 inputs
	 * @param user (stores the form data as ModelAttribute)
	 * @param model (to send data to UI)
	 * @return UI Page name after saving User
	 */
	@PostMapping("/save")
	public ModelAndView saveUSer(@ModelAttribute User user, ModelAndView model) {
		Integer id = userService.saveUser(user);
		String message = "User '" + id + "' saved" ;
		model.setViewName("UserRegister");
		model.addObject("message", message);
		return model ;
	}
}

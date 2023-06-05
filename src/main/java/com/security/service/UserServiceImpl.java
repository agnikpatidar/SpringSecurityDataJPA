package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.model.User;
import com.security.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService{
	
	@Autowired
	private UserRepository repo ;
	
	@Override
	public Integer saveUser(User user) {
		return repo.save(user).getId();
	}
	
}

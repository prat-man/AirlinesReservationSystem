package com.cg.ars.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ars.user.dto.User;
import com.cg.ars.user.exception.UserException;
import com.cg.ars.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService service;
	
	@PostMapping(path="/add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody @Valid User users) throws UserException
	{
		if(service.findByUsername(users.getUsername())!=null)
		{
			throw new UserException("User with " + users.getUsername() + " already exists", "/user/add");
		}
		User newUser = service.insert(users);
		if(newUser == null)
		{
			throw new UserException("User " + users.getUsername() + " cannot be added", "/user/add");
		}
		else
		{
			return newUser;
		}
	}
	
	@PostMapping(value="/verify")
	public User verify(@RequestBody User user) throws UserException
	{
		String username = user.getUsername();
		String password = user.getPassword();
		
		User retUser = service.findByUsername(username);
		
		if (retUser != null && retUser.getPassword().equals(password)) {
			return retUser;
		}
		else {
			throw new UserException("Invalid Credentials", "/user/verify");
		}
	}
}

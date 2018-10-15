package com.cg.ars.user.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ars.user.dto.User;
import com.cg.ars.user.exception.UserException;
import com.cg.ars.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	private UserService user;
	@PostMapping(path="/add",consumes=MediaType.APPLICATION_JSON_VALUE)
	public User addUser(@RequestBody @Valid User users) throws UserException
	{
		if(user.findByUsername(users.getUsername())!=null)
		{
			throw new UserException("User with " + users.getUsername() + " already exists", "/user/add");
		}
		User newUser = user.insert(users);
		if(newUser == null)
		{
			throw new UserException("User " + users.getUsername() + " cannot be added", "/user/add");
		}
		else
		{
			return newUser;
		}
	}
	@RequestMapping(value = "/verify", method = RequestMethod.POST)
	@ResponseBody
	public boolean verify(@RequestBody Map<String, String> userAuth) throws UserException
	{
		User verifyUser = new User();
		verifyUser = user.findByUsername(userAuth.get("username"));
		if(verifyUser != null)
		{
			if(verifyUser.getPassword().equals((userAuth.get("password"))))
			{
				return true;
			}
			else
			{
				throw new UserException("Username: " + userAuth.get("username") + " has entered a wrong password", "/user/verify");
			}
		}
		else
		{
			throw new UserException("Username: " + userAuth.get("username") + " is invalid username", "/user/verify");
		}
	}
}

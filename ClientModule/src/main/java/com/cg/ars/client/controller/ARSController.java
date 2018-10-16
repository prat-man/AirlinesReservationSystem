package com.cg.ars.client.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.ars.client.dto.Airport;
import com.cg.ars.client.dto.User;

@Controller
@RequestMapping("/ars")
public class ARSController
{
	@RequestMapping(value={"", "/login"})
	public String login(HttpServletRequest request) {
	    return "/login.jsp";
	}
	
	@RequestMapping("/loginAction")
	public String loginAction(HttpServletRequest request)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8081/user/verify";
		
		Object object = restTemplate.postForObject(url, request, Object.class);
		
		if (object instanceof User) {
			// TODO: Show appropriate console based on role
			User user = (User) object;
			return "/success.jsp";
		}
		else {
			return "/failure.jsp";
		}
	}
	
	@RequestMapping("/register")
	public String register(HttpServletRequest request) {
	    return "/register.jsp";
	}
	
	@RequestMapping("/registerAction")
	public String registerAction(HttpServletRequest request)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		String url = "http://localhost:8081/user/add";
		
		Object object = restTemplate.postForObject(url, request, Object.class);
		
		if (object instanceof Boolean) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}

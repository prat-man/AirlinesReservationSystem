package com.cg.ars.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.ars.client.dto.Airport;
import com.cg.ars.client.dto.Flight;
import com.cg.ars.client.dto.User;

@Controller
@RequestMapping("/ars")
public class ARSController
{
	@RequestMapping(value={"", "/index"})
	public String login(HttpServletRequest request) {
	    return "/index.jsp";
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
	
	@PostMapping(path="/searchflight",consumes=MediaType.ALL_VALUE)
	public String searchFlight(HttpServletRequest request, Model model) throws JSONException
	{
		RestTemplate restTemplate = new RestTemplate();
		
		String url="http://localhost:8081/emp/insert";
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		JSONObject query = new JSONObject();
		query.put("fromCity",request.getParameter("fromcity"));
		query.put("toCity", request.getParameter("tocity"));
		query.put("depDate", request.getParameter("depdate"));
		
	    HttpEntity<String> search = new HttpEntity<String>(query.toString(),headers);
	    ResponseEntity<List<Flight>> flight = restTemplate.postForObject(url, search, ResponseEntity.class);
		System.out.println(flight);
		model.addAttribute("flightList", flight);
		return "/success.jsp";
		
	}
}

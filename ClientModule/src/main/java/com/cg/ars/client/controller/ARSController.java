package com.cg.ars.client.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.cg.ars.client.dto.Airport;
import com.cg.ars.client.dto.Flight;
import com.cg.ars.client.dto.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

@Controller
@RequestMapping("/ars")
public class ARSController
{
	@Autowired
	private EurekaClient eurekaClient;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value={"", "/index"})
	public String login(HttpServletRequest request) {
	    return "/index.jsp";
	}
	
	@RequestMapping("/loginAction")
	public String loginAction(HttpServletRequest request)
	{
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
		String url = "http://localhost:8081/user/add";
		
		Object object = restTemplate.postForObject(url, request, Object.class);
		
		if (object instanceof Boolean) {
			return "success";
		}
		else {
			return "failure";
		}
	}
	
	@PostMapping(path="/searchFlight")
	public String searchFlight(HttpServletRequest request, Model model)
	{
		String url = getFlightUrl() + "/flight/search";
		
		String fromCity = request.getParameter("fromCity");
		String toCity = request.getParameter("toCity");
		String depDate = request.getParameter("depDate");
		
	    @SuppressWarnings("unchecked")
		List<Flight> flightList = (List<Flight>) restTemplate.getForObject(url + "/" + fromCity + "/" + toCity + "/" + depDate, List.class);
	    
		System.out.println(flightList);
		
		model.addAttribute("flightList", flightList);
		
		return "/success.jsp";
		
	}
	
	@RequestMapping("/addAirport")
	public String addAirport(HttpServletRequest request, Model model) {
		Airport airport = new Airport();
		
		model.addAttribute("airport", airport);
		
	    return "/addairport.jsp";
	}
	
	@PostMapping(value="/addAirportAction")
    public String insertAirportAction(@ModelAttribute("airport") Airport airport)
    {
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		
		HttpEntity<Airport> entity = new HttpEntity<>(airport, headers);
		
		String url = getAirportUrl() + "/airport/add";
		
		ResponseEntity<Airport> newAirport = restTemplate.postForEntity(url, entity, Airport.class);
		
		System.out.println(newAirport.getBody());
		
		return "/success.jsp";
    }
	
	
	
	/*@PostMapping(path="/addAirportAction")
	public String addAirportAction(@ModelAttribute("airport") Airport airport, Model model)
	{
		String url = getAirportUrl() + "/airport/add";
		
		System.out.println(airport);
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		String abbreviation = request.getParameter("abbreviation");
		String airportName = request.getParameter("airportName");
		String location = request.getParameter("location");
		
		Airport airport1 = new Airport();
		airport1.setAbbreviation(airport.getAbbreviation());
		airport1.setAirportName(airport.getAirportName());
		airport1.setLocation(airport.getLocation());
		
		System.out.println("Hello"+airport1);
		
		HttpEntity<Airport> airportEntity = new HttpEntity<Airport>(airport,headers);

		Airport newAirport = restTemplate.postForObject(url, airport, Airport.class);
		
		System.out.println(newAirport);
		
		return "/success.jsp";
	}
	*/
	
	/*
	 * Utility Methods to get Microservice URLs
	 */
	public String getAirportUrl()
	{
	    Application application = eurekaClient.getApplication("airport-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return "http://" + hostname + ":" + port;
	}
	
	public String getBookingUrl()
	{
	    Application application = eurekaClient.getApplication("booking-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return "http://" + hostname + ":" + port;
	}
	
	public String getFlightUrl()
	{
	    Application application = eurekaClient.getApplication("flight-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return "http://" + hostname + ":" + port;
	}
	
	public String getUserUrl()
	{
	    Application application = eurekaClient.getApplication("user-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return "http://" + hostname + ":" + port;
	}
}

package com.cg.ars.client.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value={"", "/index"})
	public String login(HttpServletRequest request) {
	    return "/index.jsp";
	}
	
	@RequestMapping(value="/addflight")	
	public String addFlight(HttpServletRequest request,Model model) {
		Flight flight = new Flight();
		model.addAttribute(flight);
		return "/addflight.jsp";
	}
	
	@PostMapping(value="/addFlightAction")
	public String addFlightAction(@ModelAttribute("flight")Flight flight,HttpServletRequest request) {
//		String airline = request.getParameter("airline");
//		String depCity = request.getParameter("depCity");
//		String arrCity = request.getParameter("arrCity");
//		String depDate = request.getParameter("depDate");
//		String arrDate = request.getParameter("arrDate");
//		String depTime = request.getParameter("depTime");
//		String arrTime = request.getParameter("arrTime");
//		String firstSeats = request.getParameter("firstSeats");
//		String firstSeatFare = request.getParameter("firstSeatsFare");
//		String bussSeat = request.getParameter("bussSeats");
//		String businessSeatFare = request.getParameter("bussSeatsFare");
		RestTemplate restTemplate = new RestTemplate();
		String url = getFlightUrl() + "/flight/add" ;
		Object object = restTemplate.postForObject(url, flight, Flight.class);
		return "/success.jsp";
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
	
	@PostMapping(path="/searchFlight")
	public String searchFlight(HttpServletRequest request, Model model)
	{
		RestTemplate restTemplate = new RestTemplate();
		
		String url="http://localhost:8081/flight/search";
		
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
	public String addAirport(HttpServletRequest request) {
	    return "/addairport.jsp";
	}
	
	@PostMapping(path="/addAirportAction")
	public String addAirportAction(@RequestBody Airport airport)
	{
		// TODO: Error Here
		// Send and receive airport object
		
		RestTemplate restTemplate = new RestTemplate();
		
		String url = getAirportUrl() + "/airport/add";
		
		/*String abbreviation = request.getParameter("abbreviation");
		String airportName = request.getParameter("airportName");
		String location = request.getParameter("location");
		Airport airport = new Airport();
		airport.setAbbreviation(abbreviation);
		airport.setAirportName(airportName);
		airport.setLocation(location);*/
		
		Airport newAirport = restTemplate.postForObject(url, airport, Airport.class);
		
		System.out.println(newAirport);
		
		return "success.jsp";
	}
	
	
	/*
	 * Utility Methods to get Microservice URLs
	 */
	public String getAirportUrl()
	{
	    Application application = eurekaClient.getApplication("airport-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return hostname + ":" + port;
	}
	
	public String getBookingUrl()
	{
	    Application application = eurekaClient.getApplication("booking-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return hostname + ":" + port;
	}
	
	public String getFlightUrl()
	{
	    Application application = eurekaClient.getApplication("flight-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return hostname + ":" + port;
	}
	
	public String getUserUrl()
	{
	    Application application = eurekaClient.getApplication("user-service");
	    
	    InstanceInfo instanceInfo = application.getInstances().get(0);
	    
	    String hostname = instanceInfo.getHostName();
	    int port = instanceInfo.getPort();
	    
	    return hostname + ":" + port;
	}
}

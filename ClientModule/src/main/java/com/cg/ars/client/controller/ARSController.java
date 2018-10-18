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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.cg.ars.client.dto.Airport;
import com.cg.ars.client.dto.Booking;
import com.cg.ars.client.dto.Flight;

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
	
	@RequestMapping(value="adminPanel")
	public String adminPanel(HttpServletRequest request) {
	    return "/adminPanel.jsp";
	}
	
	@RequestMapping(value="/addFlight")	
	public String addFlight(HttpServletRequest request,Model model) {
		Flight flight = new Flight();
		
		model.addAttribute(flight);
		
		return "/addflight.jsp";
	}
	
	@PostMapping(value="/addFlightAction")
	public String addFlightAction(@ModelAttribute("flight") Flight flight) {
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		
		HttpEntity<Flight> entity = new HttpEntity<>(flight, headers);
		
		String url = getFlightUrl() + "/flight/add";
		
		ResponseEntity<Airport> newAirport = restTemplate.postForEntity(url, entity, Airport.class);
		
		System.out.println(newAirport.getBody());
		
		return "/success.jsp";
	}
	
	/*@RequestMapping("/loginAction")
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
	}*/
	
	@GetMapping("/searchFlight")
	public String searchFlight(HttpServletRequest request, Model model)
	{
		String url = getFlightUrl() + "/flight/search";
		
		String fromCity = request.getParameter("fromCity");
		String toCity = request.getParameter("toCity");
		String depDate = request.getParameter("depDate");
		
	    @SuppressWarnings("unchecked")
		List<Flight> flightList = (List<Flight>) restTemplate.getForObject(url + "/" + fromCity + "/" + toCity + "/" + depDate, List.class);
	    
		model.addAttribute("flightList", flightList);
    
		model.addAttribute("fromCity", fromCity);
		model.addAttribute("toCity", toCity);
		model.addAttribute("depDate", depDate);
    
		return "/searchFlight.jsp";
	}
	
	@GetMapping(path="/autocomplete/{query}")
	public @ResponseBody List<String> autocomplete(@PathVariable("query") String query, Model model ) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println(query);
		String url= getFlightUrl() + "/flight/getCityList";
		@SuppressWarnings("unchecked")
		List<String> response = restTemplate.getForObject(url + "/" + query, List.class);
		
		System.out.println(response);
		model.addAttribute("response",response);
		return response;
	}
	
	@RequestMapping("/addAirport")
	public String addAirport(HttpServletRequest request, Model model) {
		Airport airport = new Airport();
		
		model.addAttribute("airport", airport);
		
	    return "/addairport.jsp";
	}
	
	@PostMapping("/addAirportAction")
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
	
	@RequestMapping("/newBooking/{flightNo}")
	public String newBooking(@PathVariable("flightNo") String flightNo, HttpServletRequest request, Model model) {
		
		String url1 = getFlightUrl() + "/flight/searchByFlightNo/" + flightNo;
		String url2 = getBookingUrl()+ "/booking/generateBookingId/" + flightNo;
		Flight flight = restTemplate.getForObject(url1,Flight.class);
		String bookingId = restTemplate.getForObject(url2, String.class);		
		String classFare = request.getParameter("class");
		String arr[]=classFare.split("@");
		Double fare = Double.parseDouble(arr[1]);
		System.out.println(fare);
		model.addAttribute("bookingId", bookingId);
		model.addAttribute("fare", fare);
		model.addAttribute("classType", arr[0]);
		model.addAttribute("flight", flight);
		return "/newbooking.jsp";
	}
	
	@PostMapping("/payment")
	public String payment(HttpServletRequest request, Model model)
	{
	
		String name = request.getParameter("name");
		Integer noOfPassengers = Integer.parseInt(request.getParameter("noOfPassengers"));
		String bookingId = request.getParameter("bookingId");
		String flightNo = request.getParameter("flightNo");
		Double fare = Double.parseDouble(request.getParameter("fare"));
		String classType = request.getParameter("classType");
		String depCity = request.getParameter("depCity");
		String arrCity = request.getParameter("arrCity");
		
		String url1 = getFlightUrl() + "/flight/searchByFlightNo/" + flightNo;
		System.out.println(url1);
		Flight flight = restTemplate.getForObject(url1,Flight.class);
		Double totalFare = noOfPassengers*fare;
		model.addAttribute("name", name);
		model.addAttribute("classType",classType);
		model.addAttribute("noOfPassengers", noOfPassengers);
		model.addAttribute("bookingId", bookingId);
		model.addAttribute("totalfare", totalFare);
		model.addAttribute("flight",flight);
		
		return "/payment.jsp";
	}
	
	@RequestMapping("/confirmBooking")
	public String confirmBooking(HttpServletRequest request, Model model) {
		
		String url = getBookingUrl() + "/booking/add";
		System.out.println(url);
		Booking newBooking = new Booking();
		
		List<MediaType> acceptableMediaTypes = new ArrayList<MediaType>();
		acceptableMediaTypes.add(MediaType.APPLICATION_JSON);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(acceptableMediaTypes);
		
		
		newBooking.setBookingId(request.getParameter("bookingId"));
		newBooking.setClassType(request.getParameter("classType"));
		newBooking.setCreditCardInfo(request.getParameter("creditCardInfo"));
		newBooking.setDestCity(request.getParameter("destCity"));
		newBooking.setFlightNo(request.getParameter("flightNo"));
		newBooking.setNoOfPassengers(Integer.parseInt(request.getParameter("noOfPassengers")));
		newBooking.setSrcCity(request.getParameter("srcCity"));
		newBooking.setTotalFare(Double.parseDouble(request.getParameter("totalFare")));
		newBooking.setName(request.getParameter("name"));
		
		
		HttpEntity<Booking> entity = new HttpEntity<>(newBooking,headers);
		
		ResponseEntity<Booking> confirmedBooking = restTemplate.postForEntity(url, entity, Booking.class);
		model.addAttribute("confirmedBooking",confirmedBooking);
		
		return "/bookingSuccess";
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

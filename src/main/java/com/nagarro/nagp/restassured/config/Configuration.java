package com.nagarro.nagp.restassured.config;

public class Configuration {
	 // end points for all the operations

	public static final String BASE_URI = "https://restful-booker.herokuapp.com";
 	public static final String TOKEN_ENDPOINT = "/auth";
 	public static final String CREATE_BOOKING_ENDPOINT = "/booking";    
 	public static final String GET_BOOKING_ENDPOINT = "/booking/{id}";
 	public static final String GET_BOOKINGS_ENDPOINT = "/booking/"; 
 	public static final String UPDATE_BOOKING_ENDPOINT = "/booking/{id}";  
 	public static final String PARTIAL_UPDATE_BOOKING_ENDPOINT = "/booking/{id}";
 	public static final String DELETE_BOOKING_ENDPOINT = "/booking/{id}";
  
}

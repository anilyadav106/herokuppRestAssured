package com.nagarro.nagp.restassured.APIs;

import com.nagarro.nagp.restassured.Utilties.RestRequestUtils;
import com.nagarro.nagp.restassured.config.Configuration;
import com.nagarro.nagp.restassured.models.CreateBookingRequest;
import com.nagarro.nagp.restassured.models.PartialUpdateBookingRequest;
import com.nagarro.nagp.restassured.models.UpdateBookingRequest;

import io.restassured.response.Response;

public class BookingAPI {
	
	
 //static method to create a booking, accepts one argument of CreateBookingRequest class object
    public static Response createBooking(CreateBookingRequest booking) {
        return RestRequestUtils.postRequest(Configuration.CREATE_BOOKING_ENDPOINT, booking);
    }
    //static method to get a booking, accepts one argument of booking ID

    public static Response getBooking(long bookingId) {
        return RestRequestUtils.getRequest(Configuration.GET_BOOKING_ENDPOINT.replace("{id}", String.valueOf(bookingId)));
    }
    
    //static method to get all bookings 

    public static Response getBookings() {
        return RestRequestUtils.getRequest(Configuration.GET_BOOKINGS_ENDPOINT );
    }
    //static method to update a booking, accepts 3 arguments- bookingid,UpdateBookingRequest class object,token

    public static Response updateBooking(long bookingId,UpdateBookingRequest booking,String token) {
        return RestRequestUtils.updateRequest(Configuration.UPDATE_BOOKING_ENDPOINT.replace("{id}", String.valueOf(bookingId)),booking,token);
    }  
    //static method to partially update a booking, accepts 3 arguments- bookingid,PartialUpdateBookingRequest class object,token

    public static Response partialUpdateBooking(long bookingId,PartialUpdateBookingRequest booking,String token) {
        return RestRequestUtils.partialUpdateRequest(Configuration.PARTIAL_UPDATE_BOOKING_ENDPOINT.replace("{id}", String.valueOf(bookingId)),booking,token);
    }
    //static method to delete a booking, accepts 2 arguments- bookingid,token
    
    public static Response deleteBooking(long bookingId ,String token) {
        return RestRequestUtils.deleteRequest(Configuration.DELETE_BOOKING_ENDPOINT.replace("{id}", String.valueOf(bookingId)), token );
    }
}
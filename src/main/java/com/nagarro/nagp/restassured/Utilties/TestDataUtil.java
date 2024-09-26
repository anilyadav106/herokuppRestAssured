package com.nagarro.nagp.restassured.Utilties;

import java.io.FileInputStream;
 import java.io.IOException;
import java.util.Properties;

import com.nagarro.nagp.restassured.models.BookingDatesRequest;
import com.nagarro.nagp.restassured.models.CreateBookingRequest;
import com.nagarro.nagp.restassured.models.PartialUpdateBookingRequest;
import com.nagarro.nagp.restassured.models.UpdateBookingRequest;

/* This is a test data helper class
*/

public class TestDataUtil {
	/*
	 * method to return the value of a key provided in properties file
	 */	public static String getTestDataKey(String key) {
		Properties config = new Properties();

		try {
			FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\properties\\appTestData.properties");
			config.load(fis);
		} catch (IOException e) {
			System.out.println("unable to read the config properties file");
			e.printStackTrace();
		}
		return config.getProperty(key);
	}
	
	/*
	 * method to create booking request and return the constructed booking object
	 */	public static CreateBookingRequest createBookingHelper() {
		CreateBookingRequest booking = new CreateBookingRequest();

		// Set booking details
		booking.setFirstname(getTestDataKey("firstname"));
		booking.setLastname(getTestDataKey("lastname"));
		booking.setTotalprice( Integer.parseInt(getTestDataKey("totalprice"))) ;
		booking.setDepositpaid(Boolean.getBoolean(getTestDataKey("depositpaid")));
		booking.setAdditionalneeds(getTestDataKey("additionalneeds"));

		// Set booking dates
		BookingDatesRequest bookingDates = new BookingDatesRequest();
		bookingDates.setCheckin(getTestDataKey("checkin"));
		bookingDates.setCheckout(getTestDataKey("checkout"));
		booking.setBookingdates(bookingDates);
		
		
		return booking;
	}

	/*
	 * method to update booking request and return the constructed booking object
	 */			 
	public static UpdateBookingRequest updateBookingHelper() {

		UpdateBookingRequest booking = new UpdateBookingRequest();
		// Set booking details
		booking.setFirstname(getTestDataKey("upfirstname"));
		booking.setLastname(getTestDataKey("uplastname"));
		booking.setTotalprice( Integer.parseInt(getTestDataKey("uptotalprice"))) ;
		booking.setDepositpaid(Boolean.getBoolean(getTestDataKey("updepositpaid")));
		booking.setAdditionalneeds(getTestDataKey("upadditionalneeds"));

		// Set booking dates
		BookingDatesRequest bookingDates = new BookingDatesRequest();
		bookingDates.setCheckin(getTestDataKey("upcheckin"));
		bookingDates.setCheckout(getTestDataKey("upcheckout"));
		booking.setBookingdates(bookingDates);
		
		
		return booking;
	}

	/*
	 * method to partialy update booking request and return the constructed booking
	 * object
	 */	 
	public static PartialUpdateBookingRequest partialUpdateBookingHelper() {
		PartialUpdateBookingRequest booking = new PartialUpdateBookingRequest();

		// update some user details

		booking.setLastname(getTestDataKey("puplastname"));
		booking.setTotalprice( Integer.parseInt(getTestDataKey("puptotalprice")));
		booking.setDepositpaid(Boolean.getBoolean(getTestDataKey("pupdepositpaid")));

		BookingDatesRequest bookingDates = new BookingDatesRequest();
		bookingDates.setCheckin(getTestDataKey("pupcheckin"));
		bookingDates.setCheckout(getTestDataKey("pupcheckout"));
		booking.setBookingdates(bookingDates);

		
		
		return booking;
	}
}

package com.nagarro.nagp.restassured.testpackage;

 
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nagarro.nagp.restassured.APIs.BookingAPI;
import com.nagarro.nagp.restassured.TestBase.TestBase;
import com.nagarro.nagp.restassured.Utilties.RestRequestUtils;
import com.nagarro.nagp.restassured.Utilties.TestDataUtil;
import com.nagarro.nagp.restassured.Utilties.TokenManager;

import io.restassured.response.Response;

public class AllBookingTest extends TestBase {

	@Test(priority = 0, description = "To create a new booking")
	public void createBooking() {

		// Send the create booking request
		Response response = BookingAPI.createBooking(TestDataUtil.createBookingHelper());

		// Validate the response
		response.then().assertThat().statusCode(200);
		// Assert that last name is same as we wanted to update
		Assert.assertEquals(response.jsonPath().getString("booking.lastname"), TestDataUtil.getTestDataKey("lastname"));

		// Assert that first name is same as we wanted to update
		Assert.assertEquals(response.jsonPath().getString("booking.firstname"), TestDataUtil.getTestDataKey("firstname"));
	}

	 

	@Test(priority =6, description = "To create a new booking and valdiate the response schema")
	public void createBookingResponseSchemaValidation() {

		// Send the create booking request
		Response response = BookingAPI.createBooking(TestDataUtil.createBookingHelper());
 
  		// Validate the JSON schema
  
        response.then().assertThat().body(matchesJsonSchemaInClasspath("bookingSchema.json"));
	}
	@Test(priority = 1, dependsOnMethods = "createBooking", description = "To get details of a booking")
	public void getBooking() {

		// Send the create booking request

		Long bookingID = RestRequestUtils.bookingId;
		Response response = BookingAPI.getBooking(bookingID);

		// Validate the response
		response.then().statusCode(200).log().all();
	}

	@Test(priority = 5, description = "To get IDs of all the bookings")
	public void getBookings() {

		// Send the get booking request
		Response res = BookingAPI.getBookings();
		// Validate the response
		List<Integer> bookingIds = res.jsonPath().getList("bookingid");

		System.out.println("No of bookings available at the momement are :" + bookingIds.size());
		res.then().assertThat().statusCode(200);
	}

	@Test(priority = 2, dependsOnMethods = "createBooking", description = "To partially update a booking")
	public void partialUpdateBooking() {

		Long bookingID = RestRequestUtils.bookingId;

		// Send the create booking request
		Response response = BookingAPI.partialUpdateBooking(bookingID, TestDataUtil.partialUpdateBookingHelper(),
				TokenManager.getToken());

		// Validate the response
		response.then().statusCode(200).log().all();
		// assert that last name is same as we wanted to update
		Assert.assertEquals(response.jsonPath().getString("lastname"), TestDataUtil.getTestDataKey("puplastname"));
	}

	@Test(priority = 3, dependsOnMethods = "createBooking", description = "To fully update a booking")
	public void updateBooking() {
		Long bookingID = RestRequestUtils.bookingId;

		// Send the create booking request
		Response response = BookingAPI.updateBooking(bookingID, TestDataUtil.updateBookingHelper(),
				TokenManager.getToken());

		// Validate the response
		response.then().statusCode(200).log().all();
		// assert that first name is same as we wanted to update
		Assert.assertEquals(response.jsonPath().getString("firstname"), TestDataUtil.getTestDataKey("upfirstname"));
	}

	@Test(priority = 4, dependsOnMethods = "createBooking", description = "To delete new booking")
	public void deleteBooking() {

		Long bookingID = RestRequestUtils.bookingId;

		// Send the create booking request
		Response response = BookingAPI.deleteBooking(bookingID, TokenManager.getToken());

		// Validate the response
		response.then().statusCode(201).log().all();
	}
}

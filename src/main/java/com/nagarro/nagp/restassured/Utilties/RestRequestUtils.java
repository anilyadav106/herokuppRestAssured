package com.nagarro.nagp.restassured.Utilties;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.response.Response;

public class RestRequestUtils {

	private static final Logger logger = LogManager.getLogger(RestRequestUtils.class);

	public static Long bookingId;

	/*
	 * method to get the booking and returning response, accepts only 1 argument of
	 * API end point
	 */ public static Response getRequest(String endpoint) {
		logger.info("Going to hit the getRequest ");
		Response res = null;
		try {
			res = given().contentType("application/json").log().all().when().get(endpoint);
		} catch (Exception e) {
			System.out.println("Some exception occured while hitting the request-");
			e.printStackTrace();

		}
		logger.info("Returned the getRequest response");
		return res;

	}

	/*
	 * method to create the booking and returning response, accepts only 2 arguments
	 * of API end point and request body
	 */
	public static Response postRequest(String endpoint, Object body) {
		logger.info("Going to hit the postRequest ");
		Response res = null;
		try {
			res = given().contentType("application/json").body(body).log().all().when().post(endpoint);
			logger.info("Returned the postRequest response");
			System.out.println("New book id is " + res.jsonPath().getString("bookingid"));
			String bookingIdString = res.jsonPath().getString("bookingid");
			bookingId = Long.valueOf(bookingIdString);
			logger.info("Booked a new booking with ID: " + bookingId);

		} catch (Exception e) {
			System.out.println("Some exception occured while hitting the request-");
			e.printStackTrace();

		}

		return res;
	}

	/*
	 * method to update the booking and returning response, accepts only 3 argument
	 * of API end point, request body and token
	 */
	public static Response updateRequest(String endpoint, Object body, String token) {
		logger.info("Going to hit the updateRequest ");
		Response res = null;
		try {
			res = given().cookie("token", token).body(body).contentType("application/json").accept("application/json")
					.log().all().put(endpoint).prettyPeek();
			logger.info("Returned the updateRequest response");

		}

		catch (Exception e) {
			System.out.println("Some exception occured while hitting the request-");
			e.printStackTrace();

		}
		return res;

	}

	/*
	 * method to update the partial booking and returning response, accepts only 3
	 * argument of API end point, request body and token
	 */
	public static Response partialUpdateRequest(String endpoint, Object body, String token) {
		logger.info("Going to hit the partialUpdateRequest ");
		Response res = null;
		try {
			res = given().cookie("token", token).body(body).contentType("application/json").accept("application/json")
					.patch(endpoint);
			logger.info("Returned the partialUpdateRequest response");

		} catch (Exception e) {
			System.out.println("Some exception occured while hitting the request-");
			e.printStackTrace();

		}

		return res;

	}

	/*
	 * method to delete the booking and returning response, accepts only 2 argument
	 * of API end point and token
	 */
	public static Response deleteRequest(String endpoint, String token) {

		logger.info("Going to hit the deleteRequest ");
		Response res = null;
		try {
			res = given().cookie("token", token).log().all().contentType("application/json").delete(endpoint);
			logger.info("Returned the deleteRequest response");

		} catch (Exception e) {
			System.out.println("Some exception occured while hitting the request-");
			e.printStackTrace();

		}

		return res;

	}
}
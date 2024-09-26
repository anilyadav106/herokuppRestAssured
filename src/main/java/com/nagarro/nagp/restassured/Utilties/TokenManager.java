package com.nagarro.nagp.restassured.Utilties;

import com.nagarro.nagp.restassured.config.Configuration;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TokenManager {
	
	/*
	 * this method is needed only for Put and Delete requests
	 */	
 
    public static String getToken() {
    	
         Response response = RestAssured.given()
            .contentType("application/json")
            .body("{\"username\":\"admin\",\"password\":\"password123\"}")
            .post(Configuration.BASE_URI + Configuration.TOKEN_ENDPOINT);

         System.out.println("Generated token is :" + response.jsonPath().getString("token"));
        return response.jsonPath().getString("token");
    }
}
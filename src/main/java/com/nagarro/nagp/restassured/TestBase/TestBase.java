package com.nagarro.nagp.restassured.TestBase;

 
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;

import com.nagarro.nagp.restassured.config.Configuration;

import io.restassured.RestAssured;
 
public class TestBase {
	

	private static final Logger logger = LogManager.getLogger(TestBase.class);

    @BeforeTest
    public void setup() {
    	logger.info("Going to setup the base URI ");
        RestAssured.baseURI = Configuration.BASE_URI;
    	logger.info("Done setup the base URI ");

     }
    
}
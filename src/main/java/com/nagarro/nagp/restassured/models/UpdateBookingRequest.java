package com.nagarro.nagp.restassured.models;

 
public class UpdateBookingRequest {
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private BookingDatesRequest bookingdates;
	private String additionalneeds;

	// Getters and Setters

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public boolean isDepositpaid() {
		return depositpaid;
	}

	public void setDepositpaid(boolean status) {
		this.depositpaid = status;
	}

	public BookingDatesRequest getBookingdates() {
		return bookingdates;
	} 
	
	
	public void setBookingdates(BookingDatesRequest bookingdates) {
		this.bookingdates = bookingdates;
	}
	

	public String getAdditionalneeds() {
		return additionalneeds;
	}

	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}

}

   
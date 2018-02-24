package com.restaurant.model;

public class Reservation {

	private String guestname;
	private String reservationType;
	private Integer noOfGuests;
	private String guestId;

	public Reservation() {
	}

	public Reservation(String guestname, String reservationType, Integer noOfGuests, String guestId) {
		super();
		this.guestname = guestname;
		this.reservationType = reservationType;
		this.noOfGuests = noOfGuests;
		this.guestId = guestId;
	}

	public String getGuestname() {
		return guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public Integer getNoOfGuests() {
		return noOfGuests;
	}

	public void setNoOfGuests(Integer noOfGuests) {
		this.noOfGuests = noOfGuests;
	}

	public String getGuestId() {
		return guestId;
	}

	public void setGuestId(String guestId) {
		this.guestId = guestId;
	}

}

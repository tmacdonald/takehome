package com.companyname.codereview.api;

public class UserDTO {
	private final Long id;
	private final String firstName;
	private final String lastName;
	private final LocationDTO location;
	
	UserDTO(Long id, String firstName, String lastName, LocationDTO location) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
	}
	
	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public LocationDTO getLocation() {
		return location;
	}
	
	public String toString() {
		return "(firstName = " + this.firstName + ", lastName = " + this.lastName + ", location = " + this.location.getName() + ")";
	}
}

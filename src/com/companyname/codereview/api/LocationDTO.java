package com.companyname.codereview.api;

public class LocationDTO {
	private final Long id;
	private final String name;
	
	public LocationDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

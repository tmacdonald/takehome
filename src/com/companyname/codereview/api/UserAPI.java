package com.companyname.codereview.api;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.companyname.codereview.dao.Location;
import com.companyname.codereview.dao.LocationDAO;
import com.companyname.codereview.dao.User;
import com.companyname.codereview.dao.UserDAO;

public class UserAPI {
	private final UserDAO userDAO;
	private final LocationDAO locationDAO;
	
	public UserAPI(UserDAO userDAO, LocationDAO locationDAO) {
		super();
		this.userDAO = userDAO;
		this.locationDAO = locationDAO;
	}
	
	public String serializeUsers() {
		List<UserDTO> users = getUsers();
		
		String usersJSON = "[\n";
		
		for (UserDTO user : users) {
			usersJSON += "\t{\n";
			usersJSON += "\t\t\"firstName\": \"" + user.getFirstName() + "\",\n";
			usersJSON += "\t\t\"lastName\": \"" + user.getLastName() + "\",\n";
			usersJSON += "\t\t\"location\": { \"name\": \"" + user.getLocation().getName() + "\" }\n";
			usersJSON += "\t}\n";
		}
		
		usersJSON += "]";
		return usersJSON;
	}

	public List<UserDTO> getUsers() {
		List<User> users = userDAO.getUsers();
		
		List<UserDTO> userDTOs = new ArrayList<UserDTO>(users.size());
		
		for (User user : users) {
			Location location = locationDAO.getLocation(user.getLocationId());
			LocationDTO locationDTO = new LocationDTO(location.getId(), location.getName());
			
			UserDTO userDTO = new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), locationDTO);
			userDTOs.add(userDTO);
		}
		
		return userDTOs;
	}
	
	public List<UserDTO> getUsersJava8() {
		List<User> users = userDAO.getUsers();
		
		return users
				.stream()
				.map(user -> {
					Location location = locationDAO.getLocation(user.getLocationId());
					LocationDTO locationDTO = new LocationDTO(location.getId(), location.getName());
					
					return new UserDTO(user.getId(), user.getFirstName(), user.getLastName(), locationDTO);
				})
				.collect(Collectors.toList());
	}
}

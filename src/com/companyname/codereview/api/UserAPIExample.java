package com.companyname.codereview.api;

import java.util.List;

import com.companyname.codereview.dao.InMemoryLocationDAO;
import com.companyname.codereview.dao.InMemoryUserDAO;

public class UserAPIExample {

	public static void main(String[] args) {
		UserAPI userAPI = new UserAPI(
				new InMemoryUserDAO(), new InMemoryLocationDAO());
		
		String usersJSON = userAPI.serializeUsers();
		System.out.println(usersJSON);
	}
}

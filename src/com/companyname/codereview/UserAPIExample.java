package com.companyname.codereview;

import com.companyname.codereview.api.UserAPI;
import com.companyname.codereview.dao.InMemoryLocationDAO;
import com.companyname.codereview.dao.InMemoryUserDAO;

public class UserAPIExample {

	public static void main(String[] args) {
		UserAPI userAPI = new UserAPI(
				new InMemoryUserDAO(), new InMemoryLocationDAO());
		
		String usersJSON = userAPI.serializeUsers();
		System.out.println(usersJSON);
	}
	
	static class Student {
		private final String id;
		
		public static Student from(String id) {
			return new Student(id);
		}
		
		public Student(String id) {
			this.id = id;
		}
		
		public String getId() {
			return this.id;
		}
		
		public String toString() {
			return this.id;
		}
	}
}

package com.companyname.codereview.dao;

import java.util.List;
import java.util.function.Predicate;

public interface UserDAO {

	User getUser(Long id);
	List<User> getUsers();
	List<User> getUsers(Predicate<User> predicate);
}

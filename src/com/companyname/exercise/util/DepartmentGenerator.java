package com.companyname.exercise.util;

import java.security.SecureRandom;

import com.companyname.exercise.model.Company;
import com.companyname.exercise.model.Department;

public class DepartmentGenerator {
	private static SecureRandom random = new SecureRandom();
	static String[] departmentNames = {"Engineering","Sales","Marketing","Shiping","HR","Support","IT"}; 
	
	
	public static Department getRandomDepartment(Company company){
		Department aDepartment = new Department();
		aDepartment.setCompany(company);
		aDepartment.setName(departmentNames[random.nextInt(departmentNames.length-1)]);
		return aDepartment;
	}
	
	
	
	
	
}

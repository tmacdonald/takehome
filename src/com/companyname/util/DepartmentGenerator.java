package com.companyname.util;

import java.security.SecureRandom;

import com.companyname.model.Company;
import com.companyname.model.Department;

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

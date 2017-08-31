package com.companyname.exercise.util;

import java.security.SecureRandom;

import com.companyname.exercise.model.Address;
import com.companyname.exercise.model.Country;

public class AddressGenerator {
	private static SecureRandom random = new SecureRandom();
	static String[] streetTypes = {"Street","Drive","Way","Crescent","Avenue","Lane","Court","Road"}; 
	static String[] streetNames = {"Davidson","Bloomsbury","Highgate","Cherry","Chapel","Garfield",
							"Clark","Madison","Front","Eagelson","Shaw","George","Patrick",
							"Booth","Rideau","Baseline","Woodroofe","Sycamore","Willow","Heather",
							"Clinton","4th","Main","Aspen","Mill","Lake","Park","Bay","Hill"};
	
	static Address getRandomAddress(){
		Address anAddress = new Address();
		anAddress.setAddressLine1(getRandomAddressLine());
		anAddress.setCountry(new Country("US","US"));
		anAddress.setState(StateGenerator.getRandomState());
		anAddress.setZipCode(ZipGenerator.getRandomZip());
		return anAddress;
	}
	
	private static String getRandomAddressLine(){
		StringBuilder sb = new StringBuilder();
		sb.append(streetNames[random.nextInt(streetNames.length-1)]);
		sb.append(" ");
		sb.append(streetTypes[random.nextInt(streetTypes.length-1)]);
		return sb.toString();
	}
	
	
	
}

package com.companyname.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.companyname.model.Company;

public class CompanyGenerator {
	private static SecureRandom random = new SecureRandom();
	private static List<Company> companyList = new  ArrayList<Company>(50);
	
	
    static {
    	companyList.add(new Company("Walmart","General merchandisers",2300000,"walmart.com"));
    	companyList.add(new Company("State Grid","Utilities",926067,"stategrid.com"));
    	companyList.add(new Company("Sinopec Group","Petroleum refining",713288,"sinopec.com"));
    	companyList.add(new Company("China National Petroleum","Petroleum refining",1512048,"chinapetroleum.com"));
    	companyList.add(new Company("Toyota","Motor vehicles and parts",364445,"toyota.com"));
    	companyList.add(new Company("Volkswagen Group","Motor vehicles and parts",626715,"volkswagen.com"));
    	companyList.add(new Company("Royal Dutch Shell","Petroleum refining",89000,"royaldutch.com"));
    	companyList.add(new Company("Berkshire Hathaway","Insurance",367700,"berkshirehathaway.com"));
    	companyList.add(new Company("Apple","Computers and office equipment",116000,"apple.com"));
    	companyList.add(new Company("Exxon Mobil","Petroleum refining",72700,"exxonmobil.com"));
    	companyList.add(new Company("McKesson","Healthcare",64500,"mckesson.com"));
    	companyList.add(new Company("BP","Petroleum refining",74500,"bp.com"));
    	companyList.add(new Company("United Health","Healthcare",230000,"unitedhealth.com"));
    	companyList.add(new Company("CVS Health","Healthcare",204000,"cvshealth.com"));
    	companyList.add(new Company("Samsung Electronics","Electronics and electrical equipment",325000,"samsung.com"));
    	companyList.add(new Company("Glencore","Mining and crude oil production",93123,"glencore.com"));
    	companyList.add(new Company("Daimler","Motor vehicles and parts",282488,"daimler.com"));
    	companyList.add(new Company("General Motors","Motor vehicles and parts",225000,"generalmotors.com"));
    	companyList.add(new Company("AT&T","Telecommunications",268540,"att.com"));
    	companyList.add(new Company("Exor","Diversified financials",302562,"exor.com"));
    	companyList.add(new Company("Ford Motor","Automotive",201000,"ford.com"));
    	companyList.add(new Company("Industrial & Commercial Bank of China","Financial services",461749,"icbc.com"));
    	companyList.add(new Company("AmerisourceBergen","Pharmaceuticals",18500,"amerisource.com"));
    	companyList.add(new Company("China Construction Engineering","Construction",263915,"cce.com"));
    	companyList.add(new Company("AXA","Financial services",97707,"axa.com"));
    }   
    
    public static Company getRandomCompany(){
    	return companyList.get(random.nextInt(companyList.size()-1));
    }
	



}

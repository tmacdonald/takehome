package com.companyname.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.companyname.model.Company;
import com.companyname.model.Department;
import com.companyname.model.User;

public class UserGenerator {
	private static SecureRandom random = new SecureRandom();
	private static List<String> firstNames = new  ArrayList<String>(100);
	private static List<String> lastNames = new  ArrayList<String>(100);

	public static List<User> getRandomListOfUsers(int numberOfUsers){
		List<User> userList = new ArrayList<User>();
		if (numberOfUsers>0){
			for(int i=1; i<=numberOfUsers ;i++){
				userList.add(getRandomUser());
			}
		}
		return userList;
	}
	
	
    static {
        addName("Kurt","Dinan");
        addName("Ward","Cuevas");
        addName("Clayton","Ginn");
        addName("Morris","Nogueira");
        addName("Zachary","Daniell");
        addName("Calvin","Thomure");
        addName("Harold","Hollar");
        addName("Noah","Furguson");
        addName("Mohammed","Cheadle");
        addName("Rich","Harger");
        addName("Pablo","Thiele");
        addName("Thanh","Peabody");
        addName("Dwight","Colby");
        addName("Jewell","Ferris");
        addName("Garland","Thrush");
        addName("Francis","Whetzel");
        addName("Hyman","Eagle");
        addName("Quentin","Paez");
        addName("Rayford","Silva");
        addName("Eusebio","Clough");
        addName("Abram","Shirah");
        addName("Tom","Guarnieri");
        addName("Gabriel","Goupil");
        addName("Marcellus","Yamaguchi");
        addName("Williams","Vanmeter");
        addName("Chance","Gulick");
        addName("Jarod","Crofts");
        addName("Lynwood","Kliebert");
        addName("Lindsay","Buczek");
        addName("Elton","Trudel");
        addName("Marc","Hollenbeck");
        addName("Arron","Leos");
        addName("Edmond","Knoblock");
        addName("Antonio","Mancilla");
        addName("Myron","Liao");
        addName("Clinton","Angles");
        addName("Randy","Castorena");
        addName("Pedro","Slonaker");
        addName("Keenan","Dray");
        addName("Brian","Butcher");
        addName("Lyle","Huges");
        addName("Larry","Brockway");
        addName("Avery","Choi");
        addName("Wes","Hertlein");
        addName("Jamey","Cranfield");
        addName("Sebastian","Smoot");
        addName("Wallace","Shoener");
        addName("Denny","Gregorio");
        addName("Bradly","Haubrich");
        addName("Virginia","Poovey");
        addName("Cassandra","Kemp");
        addName("Alexia","Blade");
        addName("Xuan","Prioleau");
        addName("Helaine","Monier");
        addName("Deneen","Wahlstrom");
        addName("Kiana","Ralls");
        addName("Bibi","Ulrey");
        addName("Fermina","Leflore");
        addName("Amada","Tarwater");
        addName("Arielle","Gish");
        addName("Sherri","Mathew");
        addName("Lanie","Hellums");
        addName("Taryn","Selke");
        addName("Lamonica","Callender");
        addName("Ludie","Harned");
        addName("Lorretta","Fitts");
        addName("Mercy","Riss");
        addName("Veronica","Kirven");
        addName("Han","Rives");
        addName("Sade","Beaird");
        addName("Patrica","Cressey");
        addName("Odessa","Gillispie");
        addName("Codi","Key");
        addName("Ginny","Stagner");
        addName("Agnes","Burrough");
        addName("Janeen","Cedeno");
        addName("Chara","Prisbrey");
        addName("Tamera","Keesler");
        addName("Rolanda","Cowen");
        addName("Ping","Hummel");
        addName("Lolita","Seeber");
        addName("Kamala","Orosz");
        addName("Dell","Martindale");
        addName("Lelah","Purtee");
        addName("Lashonda","Alligood");
        addName("Roslyn","Snook");
        addName("Irena","Milton");
        addName("Crissy","Parvin");
        addName("Glynis","Mauzy");
        addName("Alexandria","Garofalo");
        addName("Milagros","Lairsey");
        addName("Kandra","Massingill");
        addName("Adriana","Philipps");
        addName("Valencia","Omar");
        addName("Many","Cronkhite");
        addName("Britney","Bolland");
        addName("Tiffaney","Henshaw");
        addName("Susanna","Mitchum");
        addName("Ciara","Hennessy");
    }   
    
    public static String getRandomFirstName(){
    	return firstNames.get(random.nextInt(firstNames.size()-1));
    }

    public static String getRandomLastName(){
    	return lastNames.get(random.nextInt(lastNames.size()-1));
    }
    
    public static User getRandomUser(){
    	User aUser = new User();
    	aUser.setFirstName(getRandomFirstName());
    	aUser.setLastName(getRandomLastName());
    	aUser.setCompany(CompanyGenerator.getRandomCompany());
    	aUser.setUsername(getUsername(aUser));
    	aUser.setEmailAddress(getEmailAddress(aUser));
    	return aUser;
    	
    }
    
    public static User getRandomUser(Company company, Department department){
    	User aUser = new User();
    	aUser.setFirstName(getRandomFirstName());
    	aUser.setLastName(getRandomLastName());
    	aUser.setCompany(company);
    	aUser.setDepartment(department);
    	aUser.setUsername(getUsername(aUser));
    	aUser.setEmailAddress(getEmailAddress(aUser));
    	return aUser;
    	
    }
    
    
    private static String getUsername(User aUser){
    	StringBuilder sb = new StringBuilder();
    	sb.append(aUser.getFirstName().toLowerCase().charAt(0));
    	sb.append(aUser.getLastName().toLowerCase());

    	return sb.toString();
    }
    
    private static String getEmailAddress(User aUser){
    	StringBuilder sb = new StringBuilder();
    	sb.append(aUser.getFirstName().toLowerCase().charAt(0));
    	sb.append(aUser.getLastName().toLowerCase());
    	sb.append("@");
    	sb.append(aUser.getCompany().getDomainName());
    	return sb.toString();
    }
    
    
    private static void addName(String first,String last){
    	firstNames.add(first);
    	lastNames.add(last);
    }

}

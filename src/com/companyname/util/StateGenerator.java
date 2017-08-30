package com.companyname.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import com.companyname.model.State;

public class StateGenerator {
	private static SecureRandom random = new SecureRandom();
	private static List<String> usStates = new  ArrayList<String>(50);
	
	
    static {
        usStates.add("Alabama"); 
        usStates.add("Alaska");  
        usStates.add("Arizona");  
        usStates.add("Arkansas");  
        usStates.add("California");  
        usStates.add("Colorado");  
        usStates.add("Connecticut");  
        usStates.add("Delaware");  
        usStates.add("Florida");  
        usStates.add("Georgia");  
        usStates.add("Hawaii");  
        usStates.add("Idaho");  
        usStates.add("Illinois Indiana");  
        usStates.add("Iowa");  
        usStates.add("Kansas");  
        usStates.add("Kentucky");  
        usStates.add("Louisiana");  
        usStates.add("Maine");  
        usStates.add("Maryland");  
        usStates.add("Massachusetts");  
        usStates.add("Michigan");  
        usStates.add("Minnesota");  
        usStates.add("Mississippi");  
        usStates.add("Missouri");  
        usStates.add("Montana Nebraska");  
        usStates.add("Nevada");  
        usStates.add("New Hampshire");  
        usStates.add("New Jersey");  
        usStates.add("New Mexico");  
        usStates.add("New York");  
        usStates.add("North Carolina"); 
        usStates.add("North Dakota");  
        usStates.add("Ohio");  
        usStates.add("Oklahoma");  
        usStates.add("Oregon");  
        usStates.add("Pennsylvania Rhode Island");  
        usStates.add("South Carolina");  
        usStates.add("South Dakota");  
        usStates.add("Tennessee");  
        usStates.add("Texas");  
        usStates.add("Utah");  
        usStates.add("Vermont");  
        usStates.add("Virginia");  
        usStates.add("Washington");  
        usStates.add("West Virginia");  
        usStates.add("Wisconsin");  
        usStates.add("Wyoming"); 
    }   
    
    public static String getRandomStateName(){
    	return usStates.get(random.nextInt(usStates.size()-1));
    }
	
    public static State getRandomState(){
    	State state = new State();
    	state.setName(getRandomStateName());
    	return state;
    }



}

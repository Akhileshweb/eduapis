package com.edupeep.eduapis.utils;

import java.util.Random;

public class MiscUtils {
	
	public static String genrateRandomString(){
			
		int leftLimit = 97; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 10;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	    String generatedString = buffer.toString();
	    return generatedString;
	   
	}
	
	public static void main(String[] args) {
		System.out.println(genrateRandomString());
	}

}

/**
 * 
 */
package com.companyname.util;

import java.security.SecureRandom;

/**
 * @author mattw
 *
 */
public class ZipGenerator {

	private static final char[] symbols;

    static {
        StringBuilder tmp = new StringBuilder();
    
        for (char ch = '0'; ch <= '9'; ch++) {
            tmp.append(ch);
        }
        
        symbols = tmp.toString().toCharArray();
    }   
	
	private static SecureRandom random = new SecureRandom();
	
	public static String getRandomZip(){
		char[] buf = new char[5];
		for (int i = 0; i < buf.length; i++)
		{
			buf[i] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}
	
	
	

}

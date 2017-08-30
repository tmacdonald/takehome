/**
 * 
 */
package com.companyname.util;

import java.security.SecureRandom;

/**
 * @author mattw
 *
 */
public class StringGenerator {

	private static final char[] symbols;

    static {
        StringBuilder tmp = new StringBuilder();
        tmp.append('.');
        tmp.append('=');
        tmp.append('*');
        tmp.append('&');
        tmp.append('!');
        tmp.append('@');
        tmp.append('$');
        tmp.append('+');
        tmp.append('-');
        for (char ch = '0'; ch <= '9'; ch++) {
            tmp.append(ch);
        }
        for (char ch = 'a'; ch <= 'z'; ch++) {
            tmp.append(ch);
        }
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            tmp.append(ch);
        }
        
        symbols = tmp.toString().toCharArray();
    }   
	
	private static SecureRandom random = new SecureRandom();
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i = 1; i<8; i++ )
		{
			System.out.println(generate(44));
		}

	}
	
	public static String generate(int numberOfChars){
		char[] buf = new char[numberOfChars];
		for (int i = 0; i < buf.length; i++)
		{
			buf[i] = symbols[random.nextInt(symbols.length)];
		}
		return new String(buf);
	}
	
	
	

}

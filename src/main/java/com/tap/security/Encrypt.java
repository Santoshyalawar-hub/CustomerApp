package com.tap.security;

import com.tap.secret.Secret;

public class Encrypt {
	public static String encrypt(String str) {
		String t="";
		for (int i = 0; i < str.length(); i++) 
		{
			t=t+((char)(str.charAt(i)+Secret.getKey()));
			
		}
		return t;
	}

}

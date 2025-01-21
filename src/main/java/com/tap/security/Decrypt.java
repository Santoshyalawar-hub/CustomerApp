package com.tap.security;

import com.tap.secret.Secret;

public class Decrypt {

	public static String decrypt(String str) {
		String t="";
		for (int i = 0; i < str.length(); i++) 
		{
			t=t+((char)(str.charAt(i)-Secret.getKey()));
			
		}
		return t;
	}
}

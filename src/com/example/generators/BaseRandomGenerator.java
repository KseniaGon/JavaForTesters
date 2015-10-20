package com.example.generators;

import java.util.Random;

public class BaseRandomGenerator {

	public BaseRandomGenerator() {
		super();
	}

	public static String generateRandomString(String prefix) {
		Random random = new Random();
		int i = random.nextInt(3);
		if( i==0 ) {
			return "";
		}
		return String.format("%s%d", prefix, random.nextInt());
	}

}
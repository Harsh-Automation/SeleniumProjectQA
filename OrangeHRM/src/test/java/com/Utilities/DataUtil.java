package com.Utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.github.javafaker.Faker;

public class DataUtil {

	public static Faker faker = new Faker();
	
	public static final String firstName = randomFirstName();
	public static final int empId = randomNumber();
	public static final String emailId = randomEmailID();


	public static String timestamp() {

		String smf = new SimpleDateFormat("yyyy_mm_dd_hh_mm_ss").format(new Date());
		return smf;
	}

	public static String randomFirstName() {
		return faker.name().firstName();
	}

	public static String randomMiddleName()
	{
		return faker.name().firstName();
		
	}
	public static String randomLastName() {
		return faker.name().lastName();
	}

	public static String randomEmailID() {
		return faker.internet().emailAddress();
	}

	public static Integer randomNumber() {
		int randomnumber = 0;

		randomnumber = faker.number().numberBetween(1000, 9999);
		return randomnumber;

	}

}

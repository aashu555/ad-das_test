package com.adidastest.steps;

public class PayLoad {
	public static int id=0;
public String getPayLoad(String status) {
	String payLoad="{\r\n" + 
			"  \"id\": "+id+",\r\n" + 
			"  \"category\": {\r\n" + 
			"    \"id\": 0,\r\n" + 
			"    \"name\": \"domestic\"\r\n" + 
			"  },\r\n" + 
			"  \"name\": \"cow\",\r\n" + 
			"  \"photoUrls\": [\r\n" + 
			"    \"string\"\r\n" + 
			"  ],\r\n" + 
			"  \"tags\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\": 0,\r\n" + 
			"      \"name\": \"terrestrial animal\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"status\": \""+status+"\"\r\n" + 
			"}";
	
	return payLoad;
}
}

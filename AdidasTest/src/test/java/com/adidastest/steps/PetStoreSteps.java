package com.adidastest.steps;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Step;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;



public class PetStoreSteps {
	int respID=0;
   static Response response=null;
   
   
   PayLoad payLoad;
   
	@Step
	public void userWithPreRequisites() {
		RestAssured.baseURI="https://petstore.swagger.io/v2";
	}
	
	@Step
	public void getUserRecords(String status) {
		response=given().log().all().queryParam("key", "special-key").header("Content-Type","application/json").accept("application/json").
		when().get("/pet/findByStatus?status="+status+"");
	}
	
	@Step
	public void validateResponseCode(int statusCode) {
		response.then().assertThat().statusCode(statusCode);
	}
	
	@Step
	public void addPettoStore(String status) {
		response=given().log().all().queryParam("key", "special-key").header("Content-Type","application/json").accept("application/json").
		body(payLoad.getPayLoad(status)).when().post("/pet");
		String postResponse=response.asString();
		JsonPath js=new JsonPath(postResponse);
	    respID=js.getInt("id:");
	    PayLoad.id=respID;
	}
	
	@Step
	public void updatePet(String status) {
		response=given().log().all().queryParam("key", "special-key").header("Content-Type","application/json").accept("application/json").
		body(payLoad.getPayLoad(status)).when().put("/pet");
		String postResponse=response.asString();
		JsonPath js=new JsonPath(postResponse);
	    String actualstatus=js.getString("status:");
	    assertEquals(status,actualstatus);
	}
	
	@Step
	public void deletePet() {
		response=given().log().all().queryParam("key", "special-key").header("Content-Type","application/json").accept("application/json").
		when().delete("/pet/"+PayLoad.id+"");
	}
	
	
	
	
}

package com.adidastest.stepdefinitions;

import com.adidastest.steps.PetStoreSteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreStepDefinition {
	
    @Steps
    PetStoreSteps petStoreSteps;
	
	@Given("I am an authorised user")
	public void validate_user() {		
		petStoreSteps.userWithPreRequisites();
	}
	
	@Given("user get the records of {string} pets")
	public void get_request(String status) {		
		petStoreSteps.getUserRecords(status);
	}
	
	@Given("verify response code {int}")
	public void validate_response(Integer statusCode) {		
		petStoreSteps.validateResponseCode(statusCode);
	}
	
	@Given("user add {string} pet to the store")
	public void add_pet_to_store(String status) {		
		petStoreSteps.addPettoStore(status);
		
	}
	
	@When("user update added pet status as {string}")
	public void update_pet_status(String status) {		
		petStoreSteps.updatePet(status);
		
	}
	
	@When("user delete pet from record")
	public void delete_pet() {		
		petStoreSteps.deletePet();
		
	}
	
	
	
	
}

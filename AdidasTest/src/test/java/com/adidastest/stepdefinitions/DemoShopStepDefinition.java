package com.adidastest.stepdefinitions;


import java.util.List;

import com.adidastest.steps.DemoShopSteps;
import static org.hamcrest.MatcherAssert.assertThat;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DemoShopStepDefinition {
	@Steps
	DemoShopSteps demoShopSteps;
	
	@Given("user is on home page")
	public void navigate_to_home_page() {		
		demoShopSteps.navigateToHomePage();
		
	}
	
	@When("user add products")
	public void add_products(DataTable products) {	
		List<List<String>> data=products.asLists(String.class);
		for(int i=0;i<data.size();i++) {
		demoShopSteps.addProducts(data.get(i).get(0));
		}
		
	}
	
	@When("user delete product {string}")
	public void delete_products(String product) {		
		demoShopSteps.deleteProduct(product);
		
	}
	
	@When("user fill form with below data")
	public void fill_form(DataTable values) {	
		List<List<String>> data=values.asLists(String.class);
		demoShopSteps.fillForm(data.get(0).get(0), data.get(0).get(1), data.get(0).get(2), data.get(0).get(3), data.get(0).get(4), data.get(0).get(5));
		
	}
	
	@When("verify the purchase amount")
	public void verify_purchase_amt() {
		assertThat("Purshased amount is not as expected", demoShopSteps.validatePurchaseAmount());
		
	}
}

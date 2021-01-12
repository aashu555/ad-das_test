package com.adidastest.steps;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adidastest.pages.CartPage;
import com.adidastest.pages.ProductPage;
import com.adidastest.pages.StoreHomePage;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;

@RunWith(SerenityRunner.class)
public class DemoShopSteps extends Base {
	Logger log=Logger.getLogger(DemoShopSteps.class);
	
	Base base;
	StoreHomePage storeHomePage;
	ProductPage productPage;
	CartPage cartPage;
    
	public String  expectedAmt=null;
	
	@Step
	public void navigateToHomePage() {
		open();
		base.WaitForPageToLoad(50);
		getDriver().manage().window().maximize();
		assertEquals("https://www.demoblaze.com/index.html",getDriver().getCurrentUrl());
	}
	
	@Step
	public void addProducts(String product) {
		WebDriverWait wait=new WebDriverWait(getDriver(),30);
		storeHomePage.lnk_laptops.click();
		base.WaitForPageToLoad(50);
		waitForWebElementJsToLoad(By.xpath("//a[@class='hrefch']"));
		storeHomePage.clickDesiredProduct(product);
		productPage.lnk_add_to_cart.click();
		wait.until(ExpectedConditions.alertIsPresent());
		getDriver().switchTo().alert().accept();
		productPage.clickHeaderElement("Home");
	}
	
	@Step
	public void deleteProduct(String product) {
		WebDriverWait wait=new WebDriverWait(getDriver(),30);
		productPage.clickHeaderElement("Cart");
		wait.until(ExpectedConditions.visibilityOf(cartPage.btn_place_order));
		cartPage.deleteProduct(product);
		base.WaitForPageToLoad(50);
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", cartPage.btn_place_order);
		try {
		wait.until(ExpectedConditions.visibilityOf(cartPage.btn_purchase));}
		catch(ElementNotVisibleException e) {
			((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", cartPage.btn_place_order);	
			wait.until(ExpectedConditions.visibilityOf(cartPage.btn_purchase));
		}
		String eAmt=cartPage.lbl_total_amt.getText();
		String amt[]=eAmt.split(" ");
		expectedAmt=amt[1];
		
	}
	
	@Step
	public void fillForm(String name,String country,String city,String creditCard,String month,String year) {
		cartPage.tbx_name.sendKeys(name);
		cartPage.tbx_country.sendKeys(country);
		cartPage.tbx_cityt.sendKeys(city);
		cartPage.tbx_credit_card.sendKeys(creditCard);
		cartPage.tbx_month.sendKeys(month);
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", cartPage.btn_purchase);
		cartPage.tbx_year.sendKeys(year);
		cartPage.btn_purchase.click();
	    base.takeScreenShot();
	}
	
	@Step
	public boolean validatePurchaseAmount() {
		boolean check=false;
		cartPage.getPopupText();
		log.info(CartPage.id);
		log.info(CartPage.actualAmount);
		String[] amt=CartPage.actualAmount.split(" ");
		String actualAmount=amt[1];
		if(Integer.parseInt(expectedAmt)==Integer.parseInt(actualAmount)) {
			check=true;
		}
		getDriver().close();
		return check;
	}
}

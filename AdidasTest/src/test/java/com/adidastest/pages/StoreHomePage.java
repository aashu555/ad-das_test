package com.adidastest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import com.adidastest.steps.Base;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class StoreHomePage extends Base {
	@FindBy(xpath = "//a[contains(.,'Laptops')]")
	public WebElement lnk_laptops;
	
	@FindBy(xpath = "//a[@class='hrefch']")
	public WebElement lnk_laptop_name;
	
	public void clickDesiredProduct(String product) {
		waitForWebElementJsToLoad(By.xpath("//a[contains(.,'"+product+"')]"));
		try {
		getDriver().findElement(By.xpath("//a[contains(.,'"+product+"')]")).click();}
		catch(StaleElementReferenceException e) {
			getDriver().findElement(By.xpath("//a[contains(.,'"+product+"')]")).click();	
		}
	}
	
}

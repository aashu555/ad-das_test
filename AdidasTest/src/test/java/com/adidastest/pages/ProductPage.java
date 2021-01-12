package com.adidastest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.adidastest.steps.Base;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class ProductPage extends Base {
	@FindBy(xpath = "//a[contains(@class,'btn-success')]")
	public WebElement lnk_add_to_cart;
	
	@FindBy(xpath = "//a[@class='nav-link']")
	public WebElement lnk_header;
	
	public void clickHeaderElement(String header) {
		getDriver().findElement(By.xpath("//a[@class='nav-link'][contains(.,'"+header+"')]")).click();
	}
}

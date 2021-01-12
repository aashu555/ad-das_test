package com.adidastest.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.adidastest.steps.Base;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;

public class CartPage extends Base {
	public static String id,actualAmount;
	
	@FindBy(xpath = "//button[contains(@class,'btn-success')]")
	public WebElement btn_place_order;
	
	@FindBy(xpath = "//label[@id='totalm']")
	public WebElement lbl_total_amt;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Purchase')]")
	public WebElement btn_purchase;
	
	@FindBy(xpath = "//input[@id='name']")
	public WebElement tbx_name;
	
	@FindBy(xpath = "//input[@id='country']")
	public WebElement tbx_country;
	
	@FindBy(xpath = "//input[@id='city']")
	public WebElement tbx_cityt;
	
	@FindBy(xpath = "//input[@id='card']")
	public WebElement tbx_credit_card;
	
	@FindBy(xpath = "//input[@id='month']")
	public WebElement tbx_month;
	
	@FindBy(xpath = "//input[@id='year']")
	public WebElement tbx_year;
	
	@FindBy(xpath = "//p[contains(@class,'text-muted')]/text()[following-sibling::br]")
	public WebElement lbl_popup_text;
	
	@FindBy(xpath = "//button[contains(@class,'confirm')]")
	public WebElement btn_ok;
	
	
	public void deleteProduct(String product) {
		((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", getDriver().findElement(By.xpath("//td[contains(.,'"+product+"')]//..//a[contains(.,'Delete')]")));
	}
	
	public void getPopupText() {
	  
		  List<WebElement> ls=getDriver().findElements(By.xpath("(//p[contains(@class,'text-muted')]/text()[following-sibling::br])[1]"));
		for(int i=0;i<ls.size();i++) {
			if(ls.get(i).getText().contains("Id:")) {
				 id=ls.get(i).getText();
				 System.out.println(id);
				}
			else if(ls.get(i).getText().contains("Amount:")) {
				 actualAmount=ls.get(i).getText();
				 System.out.println(actualAmount);
			}
			}
	}
}



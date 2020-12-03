package com.pageobject.generalstore;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Cart {
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice") public
	List<AndroidElement> ProductPrice_txt;
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl") public
	WebElement TotalPrice_txt;
	
	public Cart(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

}

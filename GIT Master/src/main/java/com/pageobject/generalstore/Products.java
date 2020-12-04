package com.pageobject.generalstore;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Products {

	@AndroidFindBy(id="com.androidsample.generalstore:id/productAddCart") public
	List<AndroidElement> AddtoCart_btn;
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart") public
	WebElement Cart_icon;
	
	public Products(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
}

package com.pageobject.generalstore;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class GeneralStoreHomePage {

	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry") public
	WebElement Country_dropdown;
	@AndroidFindBy(xpath="//*[@text='Belgium']") public WebElement Belgium_txt;
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField") public
	WebElement Name_txtbox;
	@AndroidFindBy(xpath="//*[@text='Female']") public WebElement Gender_chkbox;
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop") public 
	WebElement Letshop_btn;
	
	public GeneralStoreHomePage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}

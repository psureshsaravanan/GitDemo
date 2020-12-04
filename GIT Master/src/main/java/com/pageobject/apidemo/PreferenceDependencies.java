package com.pageobject.apidemo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PreferenceDependencies {

	@AndroidFindBy(id="android:id/checkbox") public WebElement Wifi_chkbox;
	@AndroidFindBy(xpath="(//android.widget.RelativeLayout)[2]") public WebElement
	WifiSetting_menu;
	@AndroidFindBy(id="android:id/edit") public WebElement WifiPassword_tbox;
	@AndroidFindBy(className="android.widget.Button") public List<WebElement> Cancel_btn;
	
	public PreferenceDependencies(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
}

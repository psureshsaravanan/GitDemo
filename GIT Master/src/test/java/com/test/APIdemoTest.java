package com.test;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pageobject.apidemo.HomePage;
import com.pageobject.apidemo.PreferenceDependencies;
import com.pageobject.apidemo.Preferences;
import com.source.DriverConfig;
import com.source.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class APIdemoTest {
	public AndroidDriver<AndroidElement> driver=null;
	@BeforeMethod
	public void set() throws IOException, InterruptedException {
		
		  if(Utils.checkIfServerIsRunnning(4723)==false) {
			  Utils.startServer();
		  Thread.sleep(4000);
		  System.out.println("Server is started successfully");
		  }else { System.out.println("Server is already running in port"); }
		 
		DriverConfig dr=new DriverConfig();
		driver=dr.setDriver("APIDemo");
	}
	@AfterMethod
	public void tearDown() {
		driver.terminateApp("io.appium.android.apis");
		System.out.println("Appication terminated successfully");
		driver.quit();
		System.out.println("Driver quitted");

		
		if(Utils.checkIfServerIsRunnning(4723)==true) {
			Utils.stopServer();
			System.out.println("Server is stopped successfully");
		}else {
			System.out.println("Server is already closed in port");
		}
		
		//	Utils.endEmualtor();
	}
		

	@Test
	public void firstCase() {
		HomePage homepage=new HomePage(driver);
		homepage.Preference_menu.click();
		Preferences prefer=new Preferences(driver);
		prefer.PreferenceDependencies_menu.click();
		PreferenceDependencies predepend=new PreferenceDependencies(driver);
		predepend.Wifi_chkbox.click();
		predepend.WifiSetting_menu.click();
		predepend.WifiPassword_tbox.sendKeys("Test");
		predepend.Cancel_btn.get(1).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		
	}

}

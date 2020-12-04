package com.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobject.generalstore.Cart;
import com.pageobject.generalstore.GeneralStoreHomePage;
import com.pageobject.generalstore.Products;
import com.source.DriverConfig;
import com.source.Utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class GeneralStoreTest {
	
	public AndroidDriver<AndroidElement> driver=null;
	@BeforeTest
	public void startEmul() throws IOException, InterruptedException {
	//	Utils.startEmulator();
	//	Thread.sleep(7000);
	}
	
	@BeforeMethod
	public void set() throws IOException, InterruptedException {
		
		if(Utils.checkIfServerIsRunnning(4723)==false) {
			Utils.startServer();
			Thread.sleep(4000);
			System.out.println("Server is started successfully");
		}else {
			System.out.println("Server is already running in port");
		}
		
		DriverConfig dr=new DriverConfig();
		driver=dr.setDriver("GeneralStoreAPP");
	}
	@AfterMethod
	public void tearDown() throws InterruptedException {
		driver.terminateApp("io.appium.android.apis");
		System.out.println("Appication terminated successfully");
		driver.quit();
		System.out.println("Driver quitted");

		
		if(Utils.checkIfServerIsRunnning(4723)==true) {
			Utils.stopServer();
			Thread.sleep(5000);
			System.out.println("Server is stopped successfully");
		}else {
			System.out.println("Server is already closed in port");
		}
			//	Utils.endEmualtor();
	}
		
		@Test
		public void addTwoItem() {
		List<AndroidElement> elements=null;
		double expectedvalue=0.0;
		GeneralStoreHomePage genHomePage=new GeneralStoreHomePage(driver);
		genHomePage.Country_dropdown.click();
		Utils.scrollToText(driver, "Belgium");
		genHomePage.Belgium_txt.click();
		genHomePage.Name_txtbox.sendKeys("Hello");
		driver.hideKeyboard();
		genHomePage.Gender_chkbox.click();
		genHomePage.Letshop_btn.click();
		Products product=new Products(driver);
		
		elements=product.AddtoCart_btn;
		for(AndroidElement e:elements) {
			e.click();
		}
		product.Cart_icon.click();
		Cart cart=new Cart(driver);
		
		//WebDriverWait wait=new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(e)));
	
			for(int i=0;i<4;i++) {
				try {
					elements=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
					for(int j=0;j<elements.size();j++) {
						expectedvalue=expectedvalue+Double.parseDouble(elements.get(j).getText().replace("$", ""));
					}
					break;
				}catch(StaleElementReferenceException e) {
					System.out.println("Exception occur stale element reference exception");
				}
			}
			

		String expected=String.format("%s", expectedvalue);
		String actual=cart.TotalPrice_txt.getText().replace("$", "").trim();

		System.out.println(" Expected is "+expected+" actual is "+actual);
		Assert.assertEquals(actual, expected);
	}
}

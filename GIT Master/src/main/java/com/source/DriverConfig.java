package com.source;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverConfig {
		//Below command used to get appactivity and app package name
			//adb shell
			//dumpsys window windows | grep -E 'mCurrentFocus|mFocusedApp'
public static	AndroidDriver<AndroidElement>  driver=null;
	public  AndroidDriver<AndroidElement> setDriver(String AppName) throws IOException{
	
		String deviceName=System.getProperty("DeviceName");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		if(String.valueOf(Utils.readYaml().get(AppName).get("Installed")).equals("false")) {
			File file=new File((String) Utils.readYaml().get(AppName).get("APKPath"));
			cap.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());	
		}else if(String.valueOf(Utils.readYaml().get(AppName).get("Installed")).equals("true")) {
			cap.setCapability("appPackage",Utils.readYaml().get(AppName).get("AppPackage"));
			cap.setCapability("appActivity", Utils.readYaml().get(AppName).get("AppActivity"));

		}
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);
		if(String.valueOf(Utils.readYaml().get(AppName).get("HybridApp")).equals("true")) {
			cap.setCapability("chromedriverExecutable", "C:\\Users\\psure\\Downloads\\chromedriver.exe");
		}
		 driver=
				new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return driver;
	}// com.facebook.lite/com.facebook.lite.MainActivity
	
	public  AndroidDriver<AndroidElement> setDriverForInstalledApp() throws IOException{
	//	File file=new File("./src/main/java/ApiDemos-debug.apk");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, Utils.loadProperty().get("Devicename"));
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"uiautomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,10);
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
		cap.setCapability("chromedriverExecutable", "C:\\Users\\psure\\Downloads\\chromedriver.exe");
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return driver;
	}
	
	public  AndroidDriver<AndroidElement> setDriverForMobileApp() throws MalformedURLException{
			File file=new File("./src/main/java/ApiDemos-debug.apk");
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		//	capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
			capabilities.setCapability(MobileCapabilityType.APP, file.getAbsolutePath());
			//capabilities.setCapability("appPackage", "io.appium.android.apis");
			//capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
			AndroidDriver<AndroidElement> driver=
					new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);;
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					return driver;
		}//io.appium.android.apis/io.appium.android.apis.ApiDemos
	
	public  AndroidDriver<AndroidElement> setDriverToOpenMobileBrowser() throws MalformedURLException{
		
		DesiredCapabilities capabilities=new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Sureshemulator");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		capabilities.setCapability("chromedriverExecutable", "C:\\Users\\psure\\Downloads\\chromedriver.exe");
		
		AndroidDriver<AndroidElement> driver=
				new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return driver;
	}//io.appium.android.apis/io.appium.android.apis.ApiDemos
	public static AndroidDriver<AndroidElement> getDriver(){
		if(driver!=null) {
			return driver;
		}
		return null;
	}
}


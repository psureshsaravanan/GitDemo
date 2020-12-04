package com.source;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Utils {
	public static AppiumDriverLocalService service=null;
	public static Properties prop=null;
	public static Map<String,Map<String,String>> yaml=null;
	public static Properties loadProperty() throws IOException {
		if(prop==null) {
			FileInputStream fis=new FileInputStream("./Config.properties");
			prop=new Properties();
			prop.load(fis);
			return prop;
		}
		return prop;
	}
	public static Map<String, Map<String, String>> readYaml() throws JsonParseException, JsonMappingException, IOException {
		if(yaml==null) {
			System.out.println("Yaml code process going on");
			ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
			 yaml = mapper.readValue(new File("./Config.yaml"), Map.class);
			return yaml;
			}
		return yaml;
			}
public static void newCOde() {
	System.out.println("New code commit check tog git");
}
public static void scrollToText(AndroidDriver<AndroidElement> driver,String textName) {
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+textName+"\"));");
}

public static void startServer() {
	if(service==null) {
		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		
		builder.withAppiumJS(new File("C:\\Users\\psure\\AppData\\Roaming\\npm\\node_modules\\appium"));
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		//builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");

		service=AppiumDriverLocalService.buildService(builder);
		service.start();	
	}else {
		System.out.println("Server is already running");
	}
	
}

public static void stopServer() {
	if(service!=null) {
		while(service.isRunning()) {
			service.stop();	
			System.out.println("Server stopping process going on....");
		}
		service=null;
	}else {
		System.out.println("Server is already closed");
	}
	
}
public static void getScreenshot(String tcName) throws IOException {
	AndroidDriver<AndroidElement> driver=DriverConfig.getDriver();
	File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("./Screenshots/"+tcName+".png"));
	
}
public static void startEmulator() throws IOException {
	Runtime.getRuntime().exec("./startEmulator.bat");
}
public static void endEmualtor() {
	String cmdstr = "adb -s Sureshemualtor emu kill";
    try {
        Runtime.getRuntime().exec(cmdstr);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void killAllNodes() throws IOException {
	String cmdString="taskkill /F /IM node.exe";
	Runtime.getRuntime().exec(cmdString);
}
public static boolean checkIfServerIsRunnning(int port) {

    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
        serverSocket = new ServerSocket(port);
        serverSocket.close();
    } catch (IOException e) {
        //If control comes here, then it means that the port is in use
        isServerRunning = true;
    } finally {
        serverSocket = null;
    }
    return isServerRunning;
}

}

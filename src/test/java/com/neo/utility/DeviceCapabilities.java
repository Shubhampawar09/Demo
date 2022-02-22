package com.neo.utility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class DeviceCapabilities {

	//public DesiredCapabilities capabilities;
	//public AppiumDriver<MobileElement> driver;
	public static ThreadLocal<AppiumDriver<MobileElement>> tlDriver = new ThreadLocal<>();
	DesiredCapabilities capabilities = new DesiredCapabilities();
	public static Properties prop;
	public AppiumDriverLocalService service;

	/*
	 * Whenever i am starting the server i am checking the wheather server is
	 * already started then it will return true true of negation is false
	 */

	public AppiumDriverLocalService startService() {
		boolean flag = checkIfServerIsRunning(4723);
		/*
		 * if it is false then we are skipping the start server and if it is true then
		 * it will go inside the block and start the server
		 */
		if (!flag) {
			service = AppiumDriverLocalService.buildDefaultService();
			service.start();
		}
		return service;

	}

	public boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serversocket;

		try {
			serversocket = new ServerSocket(port);
			serversocket.close();
		} catch (Exception e) {
			/*
			 * If control comes here, then it means that it is in use and will return true
			 */
			isServerRunning = true;
		} finally {
			serversocket = null;
		}

		return isServerRunning;

	}

	public void SetCapabilities(String deviceIndex) throws Exception {

		capabilities = new DesiredCapabilities();
		System.out.println("Opening App");
		SetProperty();

		
		if (prop.getProperty("Platform").equalsIgnoreCase("remote")) {

//			capabilities.setCapability("browserstack.user", "shubhamp_aduqcI");
//			capabilities.setCapability("browserstack.key", "xydopbAZ6FayUozdTy1c");
//			capabilities.setCapability("app", "bs://d2d3f96fc70890d41d0d3cd7167a7841bce01f5a");
//			capabilities.setCapability("device", "Google Pixel 5");
//			capabilities.setCapability("os_version", "11.0");
//			capabilities.setCapability("realMobile", "true");
//			capabilities.setCapability("name", "Neobroker"); // test name
//			capabilities.setCapability("deviceOrientation", "potrait");
//			capabilities.setCapability("browserstack.networkProfile", "4g-lte-advanced-good");
//			capabilities.setCapability("browserstack.debug", "true");
//			capabilities.setCapability("browserstack.networkLogs", "true");
//			capabilities.setCapability("browserstack.console", "verbose");
			

			JSONParser parser= new JSONParser();
			 JSONObject config = (JSONObject) parser.parse(new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\parallel.config.json"));
			 JSONArray envs=(JSONArray) config.get("environments");
			 
			 Map<String, String> envCapabilities = (Map<String, String>) envs.get(Integer.parseInt(deviceIndex));
		        Iterator it = envCapabilities.entrySet().iterator();
		        while (it.hasNext()) {
		            Map.Entry pair = (Map.Entry)it.next();
		            capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		        }
		        
		        Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
		        it = commonCapabilities.entrySet().iterator();
		        while (it.hasNext()) {
		            Map.Entry pair = (Map.Entry)it.next();
		            if(capabilities.getCapability(pair.getKey().toString()) == null){
		                capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
		            }
		        }
		        

		        String username = System.getenv("BROWSERSTACK_USERNAME");
		        if(username == null) {
		            username = (String) config.get("username");
		        }

		        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
		        if(accessKey == null) {
		            accessKey = (String) config.get("access_key");
		        }
		        
		        String app = System.getenv("BROWSERSTACK_APP_ID");
		        if(app != null && !app.isEmpty()) {
		          capabilities.setCapability("app", app);
		        }

		        //tlDriver = new AppiumDriver<MobileElement>(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
		        tlDriver.set(new AppiumDriver<MobileElement>(
						new URL("http://" + username + ":" + accessKey + "@" + config.get("server") + "/wd/hub"),
						capabilities));
		
		} else {
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("AutomationName"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, prop.getProperty("PlatformVersion"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("PlatformName"));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DeviceName"));
			capabilities.setCapability(MobileCapabilityType.APP,
					System.getProperty("user.dir") + prop.getProperty("Apk"));
			capabilities.setCapability("appPackage", prop.getProperty("AppPackage"));
			capabilities.setCapability("appActivity", prop.getProperty("AppActivity"));
			//capabilities.setCapability("noReset", "false");
			//capabilities.setCapability("autoGrantPermissions", true);
			
			tlDriver.set(new AppiumDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities));
		
		}

	}
	
	public synchronized static AppiumDriver<MobileElement> getDriver() {
		return tlDriver.get();
	}

	public Object getDevice() {
		Map<String, Object> caps = getDriver().getSessionDetails();
		System.out.println(caps.get("device"));
		return caps.get("device");
	}

	public static void SetProperty() throws Exception {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		prop = new Properties();
		prop.load(fis);

	}
	
	
	
}

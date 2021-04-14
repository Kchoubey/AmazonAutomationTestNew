package com.amazon.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.amazon.qa.util.TestUtil;
import com.amazon.qa.util.WebEventListener;

public class TestBase {
	//basic initalisation will be there
public static WebDriver driver;
public static Properties Prop;
public  static EventFiringWebDriver e_driver;
public static WebEventListener eventListener;
 
 public TestBase() {   // Constructor of class
	 try {
		 Prop = new Properties();
		 FileInputStream ip = new FileInputStream("D:\\Java Workspace\\AmazonTest\\src\\main\\java\\com\\amazon\\config\\config.properties");
		 Prop.load(ip);
	 }catch (FileNotFoundException e) {
		 e.printStackTrace();
	 }catch (IOException e) {
		 e.printStackTrace();
	 }
 }
 
 
 public static void initialization() { //method
	 String browserName = Prop.getProperty("Browser");
	 if(browserName.equals("Chrome")) {
		 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver_win32\\chromedriver.exe");  
         
		// Instantiate a ChromeDriver class.     
		 driver=new ChromeDriver();   }
	 else if(browserName.equals("firefox")) {
		 System.setProperty("webdriver.gecko.driver", "D:\\chromedriver\\chromedriver_win32\\geckodriver.exe");  
         
			// Instantiate a ChromeDriver class.     
			 driver=new FirefoxDriver();  
	 }
	 
	 //webdriverlistner
	 e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
 
	driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	 //pass the url
	 driver.get(Prop.getProperty("url"));
	

	 }
}

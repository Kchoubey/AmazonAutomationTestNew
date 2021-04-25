package com.amazon.qa.test;



import java.io.IOException;

//import org.junit.Assert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import org.junit.Test;

import com.amazom.qa.pcg.HomePage;
import com.amazom.qa.pcg.LoginPage;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;
//changes done on 25-04-2021

public class HomePageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage; // return was there in the end of homepage 

	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		homepage = new HomePage();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	@Test(priority=1)
	public void HomePageValidation() 
	{
		boolean flag = homepage.validationoflogo();
		Assert.assertTrue(flag);
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	@Test(priority=2)
	public void validationofSignIn()
	{
		 homepage.validationofSignIn();
		
	}
	
	@Test(priority=3)
	public void LoginCredU() {
		validationofSignIn();
		homepage.emailid(Prop.getProperty("Username"));
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
		homepage.Continue();
		homepage.pasword(Prop.getProperty("Password"));
		loginpage = homepage.signInSubmit();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	@Test(priority=4)
	public void vLoginOfLogo() 
	{
		boolean flag = loginpage.validationofLoginlogo(); 
	    Assert.assertTrue(flag);
	    try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
	   // TestUtil.takeScreenshotAtEndofTest();
	    //loginpage.Search(Prop.getProperty("Search"));
	}
	
	
	
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}	

package com.amazon.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.amazom.qa.pcg.HomePage;
import com.amazom.qa.pcg.LoginPage;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class LoginPageTest extends TestBase{
	
	HomePage homepage;
	LoginPage loginpage;
	String sheetName = "Sheet1";
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup(Throwable error)
	{
		initialization();
		homepage = new HomePage();
		homepage.validationofSignIn();
		homepage.emailid(Prop.getProperty("Username"));
		try {
		TestUtil.takeScreenshotAtEndOfTest();
		} catch(IOException e) {
			e.printStackTrace();
		}
		homepage.Continue();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
		homepage.pasword(Prop.getProperty("Password"));
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
		loginpage = homepage.signInSubmit();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
		
	}
	@Test(priority=1)
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
	
	@Test(priority=2)
	public void vgiftcard()
	{
	loginpage.validationofClickOnGiftCard();
	}
	
	@DataProvider
	public Object[][] getAmazonTestData()
	{
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	//@Test(priority=2 , dataProvider="getAmazonTestData")
//	@Test(priority=2)
//	public void LoginSearchItem(String ItemSearchName) 
//	{
//		loginpage.SearchItem(Prop.getProperty("Search"));
//		//loginpage.SearchItem(ItemSearchName);
//		//loginpage.SearchItem(ItemSearchName);
//		
//		try {
//			TestUtil.takeScreenshotAtEndOfTest();
//			} catch(IOException e) {
//				e.printStackTrace();
//			}
//		//TestUtil.takeScreenshotAtEndofTest();
//		
	//}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
	
}

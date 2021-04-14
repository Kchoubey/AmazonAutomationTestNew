package com.amazon.qa.test;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amazom.qa.pcg.HomePage;
import com.amazom.qa.pcg.SearchItem;
import com.amazon.qa.base.TestBase;
import com.amazon.qa.util.TestUtil;

public class SearchItemTest extends TestBase

{
	SearchItem searchitem;
	
	public SearchItemTest() {
		super();
	}
	@BeforeMethod
	public void setup() {
		initialization();
		searchitem = new SearchItem();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) {
				e.printStackTrace();
			}
	}
	
	@Test(priority=1)
	 public void ValidationOfSearchitemTest() 
	 {
	   searchitem.ValidationOfSearchitem();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) 
			{
				e.printStackTrace();
			}
		searchitem.ValidationOfSearchButton();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) 
			{
				e.printStackTrace();
			}
		
		searchitem.ValidationOfItemSearchedName();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) 
			{
				e.printStackTrace();
			}
		
		searchitem.ValidationOfClickOnBrandName();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) 
			{
				e.printStackTrace();
			}
		
		searchitem.ValidationOfSelectProduct();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) 
			{
				e.printStackTrace();
			}
		
		searchitem.ValidationOfProductCost();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) 
			{
				e.printStackTrace();
			}
		
		searchitem.ValidationOfClickOnLine();
		try {
			TestUtil.takeScreenshotAtEndOfTest();
			} catch(IOException e) 
			{
				e.printStackTrace();
			}
	 
	 }
	 
//	 @Test(priority=2)
//     public void ValidationOfSearchButtonTest()
//     {
//    	searchitem.ValidationOfSearchButton();
//	
//		try {
//			TestUtil.takeScreenshotAtEndOfTest();
//			} catch(IOException e) {
//				e.printStackTrace();
//			}
//	}
	
//	@Test(priority=3)
//	public void ValidationOfItemSearchedNameTest()
//	{
//		searchitem.ValidationOfItemSearchedName();
//		
//		
//		try {
//			TestUtil.takeScreenshotAtEndOfTest();
//			} catch(IOException e) {
//				e.printStackTrace();
//			}
//	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}

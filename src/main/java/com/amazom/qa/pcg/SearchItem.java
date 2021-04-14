package com.amazom.qa.pcg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.amazon.qa.base.TestBase;

public class SearchItem extends TestBase
{
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchItem;
	
	
	@FindBy(xpath="//div[@class='nav-search-submit nav-sprite']")
	WebElement SearchButton;
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	WebElement ItemSearchedName;
	
	
	@FindBy(xpath="(//*[contains(text(), \"Fogg\")])[6]")
	WebElement BrandName;
	
	@FindBy(xpath="//a/span[contains(text(),'Fogg Xtremo Scent For Men,')]")
	WebElement SelectProduct;
	
	
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	WebElement ProductCost;
	
	@FindBy(id="add-to-cart-button")
	WebElement AddToCart;
	
	@FindBy(id="//h1[@class='a-size-medium a-text-bold']")
	WebElement ConfirmationTitle;
	
	@FindBy(css="body")
	WebElement NewTab;
	
	@FindBy(xpath="//i[@class='hm-icon nav-sprite']")
	WebElement threelines;
	
	@FindBy(xpath="//a[@href='/gp/css/homepage.html?ref_=nav_em_ya_0_1_1_29']")
	WebElement YourAccount;
	
	@FindBy(xpath="//h2[contains(text(),'Your Orders')]")
	WebElement YourOrder;
	
	@FindBy(xpath="//span[@class='a-dropdown-prompt']")
	WebElement DropDown;
	
	@FindBy(id="Write-a-product-review_2")
	WebElement ProductReview;
	
	@FindBy(xpath="//img[@alt=\"select to rate item four star.\"]")
	WebElement Rating;
	
	@FindBy(xpath="//div[@aria-label='Add a photo or video']")
	WebElement AddPhoto;
	
	public SearchItem()
	{
		PageFactory.initElements(driver, this);   //initalization method of page factoy using initelement
	}
	
	
	public void  ValidationOfSearchitem()
    {
	SearchItem.sendKeys("Perfume");
	}
	
	public void ValidationOfSearchButton()
	{
		SearchButton.click();
	}
	
	public void ValidationOfItemSearchedName()
	{
	String ActualTitle = ItemSearchedName.getText();
		
	String ExpectedTitle = "Perfume";
	if(ActualTitle==ExpectedTitle)
		{
			System.out.println("pass");
			
		}
		else
	    System.out.println("fail");	
		}
	
	public void ValidationOfClickOnBrandName()
	{
		BrandName.click();
	}
	
	public void ValidationOfSelectProduct()
	{
		SelectProduct.click();
	}
	
	public void ValidationOfProductCost()
	{
	   String typeValue= ProductCost.getText();
	   int quantity = Integer.parseInt(typeValue);
		if (quantity > 150)
		{
			System.out.println("pass");
			AddToCart.click();
			
			NewTab.sendKeys(Keys.CONTROL +"t");
			String confirm = ConfirmationTitle.getText();
			if (confirm == "Added To Cart")
			{
				System.out.println("pass");	
			}
			else
			
				System.out.println("pass");	
		}
			
		else
			
			System.out.println("fail");	
		    driver.quit();
		}
	
	public void ValidationOfClickOnLine() 
	{
		threelines.click();
		YourAccount.click();
		YourOrder.click();
		Select drpdown = new Select(DropDown);
		drpdown.selectByVisibleText("2020");
		ProductReview.click();
		Rating.click();
		AddPhoto.click();
		
//		// creating object of Robot class
//	    Robot rb = new Robot();
//	 
//	    // copying File path to Clipboard
//	    StringSelection str = new StringSelection("D:\\Karishma Choubey\\capture.jpg");
//	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
//	 
//	     // press Contol+V for pasting
//	     rb.keyPress(KeyEvent.VK_CONTROL);
//	     rb.keyPress(KeyEvent.VK_V);
//	 
//	    // release Contol+V for pasting
//	    rb.keyRelease(KeyEvent.VK_CONTROL);
//	    rb.keyRelease(KeyEvent.VK_V);
//	 
//	    // for pressing and releasing Enter
//	    rb.keyPress(KeyEvent.VK_ENTER);
//	    rb.keyRelease(KeyEvent.VK_ENTER);
	}
	}

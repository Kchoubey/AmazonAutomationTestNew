package com.amazom.qa.pcg;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class LoginPage  extends TestBase
{
	@FindBy(id="nav-your-amazon-text")
	WebElement amazonLoginLogo;
	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchElement;
	
	@FindBy(className="icp-nav-flag icp-nav-flag-in")
	WebElement indiaflag;
	
	
	@FindBy(linkText="ref=nav_logo")
	WebElement amazonlogo;
	
	@FindBy(partialLinkText="/gp/buyagain?ie=UTF8&ref_=nav_cs_buy_again_e937cefd3e2e467da8a7d2025be37723")
	WebElement BuyAgain;
	
	@FindBy(partialLinkText="https://www.amazon.in/gift-card")
	WebElement GiftCard;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);   //initalization method of page factoy using initelement
	}
	
	public boolean validationofLoginlogo() 
	{
		return amazonLoginLogo.isDisplayed();   //as return type will be true or false thats y it is public boolean
	}

	
	public void SearchItem(String str) 
	{
		SearchElement.sendKeys(str);
		
	}
	
	public boolean FlagValidation()
	{
		return indiaflag.isDisplayed();
	}
	
	public void validationofClickOnGiftCard() {
		GiftCard.click();   //as return type will be true or false thats y it is public boolean
	}

}

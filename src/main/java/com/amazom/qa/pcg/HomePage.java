package com.amazom.qa.pcg;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.qa.base.TestBase;

public class HomePage extends TestBase{
	
	//page factory we need to define first or we can say OR
	//logo check
	@FindBy(id="nav-logo-sprites")
	WebElement amazonlogo;

	
	@FindBy(id="nav-link-accountList")
	WebElement SigninAccount;
	
	
	@FindBy(name="email")
	WebElement Email;
	
	@FindBy(id="continue")
	WebElement Continue;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(id="signInSubmit")
	WebElement SignIn;
	
	@FindBy(id="nav-your-amazon-text")
	WebElement amazonLoginLogo;
	

//initalizing of page

public HomePage() {
	PageFactory.initElements(driver, this);   //initalization method of page factoy using initelement
}
//actions

public boolean validationoflogo() {
	return amazonlogo.isDisplayed();   //as return type will be true or false thats y it is public boolean
}

public void validationofSignIn() {
	SigninAccount.click();   //as return type will be true or false thats y it is public boolean
}

public void emailid(String em) {
	Email.sendKeys(em);
}
public void Continue() {
	Continue.click();
}

public void pasword(String pd) {
	pwd.sendKeys(pd);
}
public LoginPage signInSubmit() {
	SignIn.click();
	
	return new LoginPage();
	
}

//public LoginPage() {
//	PageFactory.initElements(driver, this);   //initalization method of page factoy using initelement
//}

public boolean validationofLoginlogo() 
{
	return amazonLoginLogo.isDisplayed();   //as return type will be true or false thats y it is public boolean
}


}

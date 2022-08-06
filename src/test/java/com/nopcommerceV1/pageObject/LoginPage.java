package com.nopcommerceV1.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		
		PageFactory.initElements(rdriver, this);
	}

	
	@FindBy(id="Email")
	WebElement txtEmail;

	@FindBy(id="Password")
	WebElement txtPwd;
	
	@FindBy(xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement btnLogin;
	
	@FindBy(linkText="Logout")
	WebElement lnkLogout;
	
	
	public void setEmail(String Email) {
		txtEmail.clear();
		txtEmail.sendKeys(Email);
	}
	
	public void setPassword(String password) {
		txtPwd.clear();
		txtPwd.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
	
	public void clickLogOut() {
		lnkLogout.click();
	}
}





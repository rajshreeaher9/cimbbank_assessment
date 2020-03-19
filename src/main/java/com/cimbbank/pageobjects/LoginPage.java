package com.imdpeach.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.imdpeach.base.TestBase;
import com.imdpeach.util.TestUtil;

/**
 * 
 * @author biswanath.padhi
 *
 */
public class LoginPage extends TestBase{
	
	// Page Objects
	@FindBy(css="button[type='submit']")
	private WebElement loginButton;

	@FindBy(css="div#flash")
	private WebElement loginErrorMessage;

	@FindBy(css="input#username")
	private WebElement username;
	
	@FindBy(css="input#password")
	private WebElement password;
	
	// Constructor to initialize page objects
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Getters of Page Objects
	public WebElement getLoginButton() {
		return util.waitForElementToBeClickable(driver, loginButton);
	}
	
	public WebElement getLoginErrorMessage() {
		return util.waitForElementToBeVisible(driver, loginErrorMessage);
	}
	
	public WebElement getUsername() {
		return util.waitForElementToBeClickable(driver, username);
	}

	public WebElement getPassword() {
		return util.waitForElementToBeClickable(driver, password);
	}

	// Actions
	public SecureAreaPage clickLogin() {
		util.clickOnElement(driver, getLoginButton());
		return new SecureAreaPage(driver);
	}
	
	public String getLoginErrorMessageText() {
		return util.getMessageByExcludingChild(getLoginErrorMessage());
	}

	public void enterUsername(String username) {
		util.enterTextinElement(getUsername(), username);
	}
	
	public void enterPassword(String password) {
		util.enterTextinElement(getPassword(), password);
	}
}
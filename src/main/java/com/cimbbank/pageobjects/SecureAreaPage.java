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
public class SecureAreaPage extends TestBase{
	// Constructor to initialize page objects

	@FindBy(css="a[href*=logout]")
	private WebElement logoutButton;

	@FindBy(css="#flash")
	private WebElement successMessage;

	public WebElement getSuccessMessage() {
		return successMessage;
	}

	private TestUtil util;

	public SecureAreaPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		util = new TestUtil(driver);
	}
	
	public WebElement getLogoutButton() {
		return util.waitForElementToBeClickable(driver, logoutButton);
	}
	
	public String getLoginSuccessMessage() {
		return util.getMessageByExcludingChild(getSuccessMessage());
	}

	public void clickLogOutButton() {
		util.clickOnElement(driver, getLogoutButton());
	}
	
	public String verifyLoginSuccessMessage() {
		return successMessage.getText();
	}
}
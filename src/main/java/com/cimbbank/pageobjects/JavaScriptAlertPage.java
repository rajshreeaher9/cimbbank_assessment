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
public class JavaScriptAlertPage extends TestBase{

	@FindBy(css="button[onclick*='Alert']")
	private WebElement jsAlertButton;

	@FindBy(css="button[onclick*='Confirm']")
	private WebElement jsConfirmButton;
	
	@FindBy(css="button[onclick*='Prompt']")
	private WebElement jsPromptButton;
	
	@FindBy(css="p#result")
	private WebElement result;

	public JavaScriptAlertPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getJsAlertButton() {
		return util.waitForElementToBeClickable(driver, jsAlertButton);
	}

	public WebElement getJsConfirmButton() {
		return util.waitForElementToBeClickable(driver, jsConfirmButton);
	}

	public WebElement getJsPromptButton() {
		return util.waitForElementToBeClickable(driver, jsPromptButton);
	}
	
	public WebElement getResult() {
		return util.waitForElementToBeVisible(driver, result);
	}
	
	public String getJSAlertButtonAlertMessage() {
		return util.getAlertMessage();
	}
	
	public String getJSConfirmButtonAlertMessage() {
		return util.getAlertMessage();
	}
	
	public String getJSPromotButtonAlertMessage() {
		return util.getAlertMessage();
	}
	
	public void clickOnJSAlert() {
		util.clickOnElement(driver, jsAlertButton);
	}
	
	public void clickOnJSConfirm() {
		util.clickOnElement(driver, jsConfirmButton);
	}
	
	public void clickOnJSPrompt() {
		util.clickOnElement(driver, jsPromptButton);
	}
	
	public String getResultMessage() {
		return getResult().getText();
	}
	
}
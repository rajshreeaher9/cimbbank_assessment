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
public class IFramePage extends TestBase{
	
	// Page Objects
	@FindBy(css="body#tinymce")
	private WebElement textEditor;
	
	// Constructor to initialize page objects
	public IFramePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Getters
	public WebElement getTextEditor() {
		return util.waitForElementToBeClickable(driver, textEditor);
	}
	
	// Actions
	public void enterTextInTextEditor(String message) {
		util.enterTextinElement(getTextEditor(), message);
	}
	
	public void clearTextEditor() {
		getTextEditor().clear();
	}
	
	public String getTextFromTextEditor() {
		return getTextEditor().getText();
	}
}
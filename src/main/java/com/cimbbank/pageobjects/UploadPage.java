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
public class UploadPage extends TestBase{

	// Object Repositories
	@FindBy(css="input#file-upload")
	private WebElement chooseFileButton;

	@FindBy(css="input#file-submit")
	private WebElement UploadButton;
	
	@FindBy(css="div#content h3")
	private WebElement postUploadMessageElement;
	
	@FindBy(css="div#uploaded-files")
	private WebElement postUploadFileName;

	// Constructor to initialize page objects
	public UploadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Getters of Page Objects
	public WebElement getChooseFileButton() {
		return util.waitForElementToBeClickable(driver, chooseFileButton);
	}

	public WebElement getUploadButton() {
		return util.waitForElementToBeClickable(driver, UploadButton);
	}

	public WebElement getPostUploadMessageElement() {
		return util.waitForElementToBeVisible(driver, postUploadMessageElement);
	}

	public WebElement getPostUploadFileName() {
		return util.waitForElementToBeVisible(driver, postUploadFileName);
	}
	
	// Actions
	public void clickChooseFile() {
		util.clickOnElement(driver, chooseFileButton);
	}
	
	public void clickUpload() {
		util.clickOnElement(driver, UploadButton);
	}
	
	public void uploadFile(String fileName) {
		util.enterTextinElement(getChooseFileButton(), fileName);
	}
	
	public String getPostUploadMesageTitle() {
		return util.getText(driver, getPostUploadMessageElement());
	}
	
	public String getPostUploadMesageFileName() {
		return util.getText(driver, getPostUploadFileName());
	}
	
}
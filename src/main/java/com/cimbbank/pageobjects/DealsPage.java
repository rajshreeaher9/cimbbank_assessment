package com.cimbbank.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cimbbank.base.TestBase;
public class DealsPage extends TestBase{
	// Page Objects
		@FindBy(xpath="//*[@class='stroke-current']")
		private WebElement dropDown;
		
		@FindBy(xpath="//a[@class='btn-nav block py-2 my-3 text-sm'][contains(text(),'CIMB Deals')]")
		private WebElement deals;
		
		@FindBy(xpath="//li[5]//a[1]")
		private WebElement travelFun;
		
		@FindBy(xpath="//input[@placeholder='Try \"Shopee\"']")
		private WebElement searchTravelFun;
		
		
		
		@FindBy(xpath="//deal-item[1]//div[1]//div[1]//p[1]")
		private WebElement dorsettSubang;
		
		@FindBy(xpath="//button[@class='alp-cimbd-search-form__search-btn btn btn-light']")
		private WebElement clickSearch;
		
		@FindBy(xpath="//p[@class='detail-text-second']")
		private WebElement dorsettText;
		
		@FindBy(xpath="//p[@class='section-title pl-3']")
		private WebElement similarDeal;
		
		@FindBy(xpath="//body//deal-item[1]")
		private WebElement oneDeal;
		
		@FindBy(xpath="//body//deal-item[2]")
		private WebElement twoDeal;
		@FindBy(xpath="//body//deal-item[3]")
		private WebElement threeDeal;
		@FindBy(xpath="//body//deal-item[4]")
		private WebElement fourDeal;
		
		
		
		
		
	
		// Constructor to initialize page objects
		public DealsPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
		
		
		// Getters
		public WebElement getdropDown() {
			return util.waitForElementToBeClickable(driver, dropDown);
		}
		public WebElement getdeals() {
			return util.waitForElementToBeClickable(driver, deals);
		}
		public WebElement gettravelFun() {
			return util.waitForElementToBeClickable(driver, travelFun);
		}
		/*public By gettravelFun() {
			return util.waitForElementToBeClickable1(driver, travelFun);
			}*/
		
		
		public WebElement getsearchTravelFun() {
			return util.waitForElementToBeClickable(driver, searchTravelFun);
		}
		public WebElement getclickSearch() {
			return util.waitForElementToBeClickable(driver, clickSearch);
		}
		
		public WebElement getdorsettSubang() {
			return util.waitForElementToBeClickable(driver, dorsettSubang);
		}
		
		public WebElement getdorsettText() {
			return util.waitForElementToBeClickable(driver, dorsettText);
		}
		public WebElement getoneDeal() {
			return util.waitForElementToBeClickable(driver, oneDeal);
		}
		public WebElement getsimilarDeal() {
			return util.waitForElementToBeClickable(driver, similarDeal);
		}
		public WebElement gettwoDeal() {
			return util.waitForElementToBeClickable(driver, twoDeal);
		}
		public WebElement getthreeDeal() {
			return util.waitForElementToBeClickable(driver, threeDeal);
		}
		public WebElement getfourDeal() {
			return util.waitForElementToBeClickable(driver, fourDeal);
		}
		
		//Actions
		public void scrollToFind() {
			util.executescroll(driver, getdorsettSubang());
		}
		public void enterTextInTextEditor(String message) {
			util.enterTextinElement(getsearchTravelFun(), message);
		}
		
		
		public void searchclick() {
			util.clickOnElement(driver, getclickSearch());
		}
		
		
		public String getDorsettText1() {
			return util.getText(driver, getdorsettText());
		}
		
		
		
		
		

}

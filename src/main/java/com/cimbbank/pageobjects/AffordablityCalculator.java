package com.cimbbank.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cimbbank.base.TestBase;
public class AffordablityCalculator extends TestBase{
	// Page Objects
	@FindBy(xpath="//*[@class='stroke-current']")
	private WebElement dropDown;
	
	@FindBy(xpath="//a[contains(text(),'Tools')]")
	private WebElement tools;
	
	@FindBy(xpath="//article[@class='tool-card bg3']//a[@class='tool-link hover:no-underline pl-5 pt-5']")
	private WebElement propertycalculator;
	
	
	
	
	@FindBy(xpath="/descendant::input[@type='tel'][1]")
	private WebElement grossIncome;
	
	
	
	@FindBy(xpath="/descendant::input[@type='tel'][2]")
	private WebElement monthlyIncome;
	
	@FindBy(xpath="/descendant::input[@type='tel'][3]")
	private WebElement totalIncome;
	
	@FindBy(xpath="/descendant::input[@type='tel'][4]")
	private WebElement loanPeriod;
	@FindBy(xpath="/descendant::input[@type='tel'][5]")
	private WebElement rate;
	
	@FindBy(xpath="/descendant::h3[@class='text-white'][1]")
	private WebElement estimatedpay;
	
	@FindBy(xpath="/descendant::h3[@class='text-white'][2]")
	private WebElement maxloanamt;
	
	@FindBy(xpath="/descendant::h3[@class='title mb-2'][1]")
	private WebElement ccpaycal;
	@FindBy(xpath="/descendant::h3[@class='title mb-2'][2]")
	private WebElement autofincal;
	@FindBy(xpath="/descendant::h3[@class='title mb-2'][3]")
	private WebElement propmoncal;
	 
	 
	
	
	
	
	

	// Constructor to initialize page objects
	public AffordablityCalculator(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	// Getters
	public WebElement getdropDown() {
		return util.waitForElementToBeClickable(driver, dropDown);
	}
	public WebElement gettools() {
		return util.waitForElementToBeClickable(driver, tools);
	}
	public WebElement getpropertycalculator() {
		return util.waitForElementToBeClickable(driver, propertycalculator);
	}
	
	public WebElement getgrossIncome() {
		return util.waitForElementToBeClickable(driver, grossIncome);
	}
	public WebElement getmonthlyIncome() {
		return util.waitForElementToBeClickable(driver, monthlyIncome);
	}
	
	public WebElement gettotalIncome() {
		return util.waitForElementToBeClickable(driver, totalIncome);
	}
	
	public WebElement getloanPeriod() {
		return util.waitForElementToBeClickable(driver, loanPeriod);
	}
	public WebElement getrate() {
		return util.waitForElementToBeClickable(driver, rate);
	}
	public WebElement getestimatedpay() {
		return util.waitForElementToBeClickable(driver, estimatedpay);
	}
	public WebElement getmaxloanamt() {
		return util.waitForElementToBeClickable(driver, maxloanamt);
	}
	public WebElement getccpaycal() {
		return util.waitForElementToBeClickable(driver, ccpaycal);
	}
	public WebElement getautofincal() {
		return util.waitForElementToBeClickable(driver, autofincal);
	}
	public WebElement getpropmoncal() {
		return util.waitForElementToBeClickable(driver, propmoncal);
	}
	
	//Actions
	
	
	
	
	
	
	
	
	

}

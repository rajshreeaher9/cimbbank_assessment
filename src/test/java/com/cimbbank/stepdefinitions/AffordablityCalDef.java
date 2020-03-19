package com.cimbbank.stepdefinitions;
import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.cimbbank.base.TestBase;
import com.cimbbank.pageobjects.AffordablityCalculator;
import com.cimbbank.pageobjects.DealsPage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AffordablityCalDef extends TestBase{
	
	private Logger logger;
	private AffordablityCalculator calPage;
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	
	public AffordablityCalDef() {
		logger = LogManager.getLogger(AffordablityCalDef.class);
		logger.info("Inside Affordablity constructor");
		
		calPage = new AffordablityCalculator(driver);
	}
	
	@Given("^I am on CIMB page for calculator$")
	public void I_am_on_CIMB_page() throws Exception {
		driver.get(properties.getProperty("cimbUrl"));
	}
	@And("^I navigate to Tools page from menu$")
	public void navigate_to_Tools() throws Exception {
		Thread.sleep(2000);
		calPage.getdropDown().click();
		calPage.gettools().click();
		
	}

	@When("^I access to Property Affordability Calculator$")
	public void access_to_Property_Affordability_Calculator() throws Exception {
		 
		calPage.getpropertycalculator().click();
		Thread.sleep(4000);
		
		}
	@And("^I have inputted all necessary values as \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void inputted_all_necessary_values(String gross,String mon,String total,String period,String rate ) throws Exception {
		
		util.changeWindowFocus(driver);
		

		jse.executeScript("scroll(0, 500);");
		calPage.getgrossIncome().click();
		util.enterTextinElement(calPage.getgrossIncome(), gross);
		
		calPage.getmonthlyIncome().click();
		util.enterTextinElement(calPage.getmonthlyIncome(), mon);
		Thread.sleep(2000);
		calPage.gettotalIncome().click();
		util.enterTextinElement(calPage.gettotalIncome(), total);
		
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		calPage.getloanPeriod().click();
		util.enterTextinElement(calPage.getloanPeriod(), period);
		Thread.sleep(2000);
		calPage.getrate().click();
		util.enterTextinElement(calPage.getrate(), rate);
	}

	@Then("^I will be able to know the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void estimate_monthly_payment(String estimatedPay,String loanAmt) throws Exception {
		
		try {
			
		/*Assert.assertEquals(dealPage.getDorsettText(),util.getDorsett());		
		 Assert.assertEquals(true, dealPage.getoneDeal().isDisplayed());
		 Assert.assertEquals(true, dealPage.gettwoDeal().isDisplayed());
		 Assert.assertEquals(true, dealPage.getthreeDeal().isDisplayed());
		 Assert.assertEquals(true, dealPage.getfourDeal().isDisplayed());*/
			jse.executeScript("window.scrollBy(0,300)");
			calPage.getestimatedpay().getText();
			assertTrue(calPage.getestimatedpay().getText().contains(estimatedPay));
			
		 
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.debug(e.getMessage());
		}
	}
	@And("^I will see Credit Card Payment Calculator, Auto Financing Affordability Calculator and Property Monthly Installment Calculator at the bottom$")
	public void I_would_like_to_explore_more() throws Exception {
		 Assert.assertEquals(true, calPage.getccpaycal().isDisplayed());
		 Assert.assertEquals(true, calPage.getautofincal().isDisplayed());
		 Assert.assertEquals(true, calPage.getpropmoncal().isDisplayed());
	}
	}



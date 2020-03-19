package com.cimbbank.util;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import com.cimbbank.base.TestBase;



public class TestUtil extends TestBase {

	public static final long IMPLICIT_WAIT = 20;
	public static final long PAGELOAD_TIMEOUT = 30;

	public static JavascriptExecutor js;
	Properties prop = new Properties();
	private static Logger logger;
	private static FluentWait<WebDriver> wait;
	public static final String TESTDATA_SHEET_PATH = testDataDir + "TestData.xlsx";







	public TestUtil(WebDriver driver) {
		logger = LogManager.getLogger(TestUtil.class);
	}


	public void takeScreenshotAtEndOfTest() throws IOException {

		File scrFile = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(scrFile, new File(userDir + "/screenshots/" + "FAILED_" + getDateTime() + System.currentTimeMillis() + ".png"));

	}

	public String getDateTime() {

		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy H-mm-ss");

		Date date = new Date();

		return dateFormat.format(date);

	}

	public void changeWindowFocus(WebDriver driver) {
		Set<String> handles = driver.getWindowHandles();
		String currentHandle = driver.getWindowHandle();
		for (String handle : handles) {

			if (!handle .equals(currentHandle))
			{
				driver.switchTo().window(handle);
			}
		}
	}

	public WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {

		final long startTime = System.currentTimeMillis();

		int tries = 0;

		boolean found = false;

		wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(StaleElementReferenceException.class);

		while ((System.currentTimeMillis() - startTime) < 91000) {
			logger.info("Searching for element " + element.toString() + ". Try number " + (tries++));
			try {

				element = wait.until(ExpectedConditions.visibilityOf(element));

				found = true;

				break;

			} catch (StaleElementReferenceException e) {
				logger.error("Stale element: \n" + e.getMessage() + "\n");
			}
		}

		long endTime = System.currentTimeMillis();

		long totalTime = endTime - startTime;

		if (found) {
			logger.info("Found element "  + element.toString() + " after waiting for " + totalTime + " milliseconds.");
		} else {
			logger.error("Failed to find element "  + element.toString() + " after " + totalTime + " milliseconds.");
		}
		return element;
	}

	public String getDorsett() {
		String DorsettText = prop.getProperty("DorsettText");
		if (DorsettText != null)
			return DorsettText;
		else
			throw new RuntimeException("DorsettText not specified in the Configuration.properties file.");
	}

	public void clickOnElement(WebDriver driver, WebElement element) {

		int attempts = 0;

		while (attempts < 2) {
			try {
				logger.info("Trying to click on element " + element);
				element.click();
				break;
			} catch (StaleElementReferenceException e) {
				logger.error("**** Stale Element Exception ****" + " attempt = " + attempts + element + driver);
			} catch (NoSuchElementException e) {
				logger.error("**** Unable to click element ****" + element);
			}
			attempts++;
		}
	}

	public void enterTextinElement(WebElement element, String textToEnter) {
		try {
			logger.info("Trying to enter text in element " + element);
			element.sendKeys(textToEnter);
		} catch (StaleElementReferenceException e) {
			System.out.println("**** Stale Element Exception ****" + element);
		} catch (NoSuchElementException e) {
			logger.error("**** Unable to enter text in element **** " + element);
		}
	}


	public WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
		int attempts = 0;

		while (attempts < 2) {
			try {
				wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(5))
						.ignoring(StaleElementReferenceException.class);
				wait.until(ExpectedConditions.visibilityOf(element));

			} catch (StaleElementReferenceException e) {
				logger.error("**** Stale Element Exception ****" + " attempt = " + attempts + element + driver);
			} catch (NoSuchElementException e) {
				logger.error("**** Unable to click element ****" + element);
			}

			attempts++;
		}

		return element;
	}







	public String getText(WebDriver driver, WebElement element) {

		String message = null;

		try {

			message =  element.getText();

		} catch (Exception e){

			logger.debug("Trying to get text from element: " + element);

			logger.error("Exception occured while getting text from element");
		}

		return message;
	}
	public void executescroll(WebDriver driver, WebElement element) {

		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("javascript:window.scrollBy(250,350)");

		} catch (Exception e) {
			logger.debug("Scrolling till element found by executing the JavaScript");

			logger.error("Exception occured while scrolling through JavaScript");
		}
	}



}

package com.imdpeach.stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.imdpeach.base.TestBase;
import com.imdpeach.pageobjects.UploadPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * 
 * @author biswanath.padhi
 *
 */
public class UploadPageSteps extends TestBase {

	private Logger logger;
	private UploadPage uploadPage;
	
	public UploadPageSteps() {
		logger = LogManager.getLogger(UploadPageSteps.class);
		logger.info("Inside UploadPageSteps constructor");
		uploadPage = new UploadPage(driver);
	}

	@Given("^user on upload page$")
	public void user_on_upload_page() throws Exception {
		driver.get("http://the-internet.herokuapp.com/upload");
	}

	@When("^user upload a file named as \"([^\"]*)\" and clicks \\[Upload\\]$")
	public void user_upload_a_file_named_as_and_clicks_Upload(String fileName) throws Exception {
		
//		String fileAbsolutePath = resourcesDir + fileName;
		Path currentPath = Paths.get(System.getProperty("user.dir"));
		Path filePath = Paths.get(currentPath.toString(), "src", "main", "resources", fileName);
		
		uploadPage.uploadFile(filePath.toString());
		
		uploadPage.clickUpload();
		
	}

	@Then("^next screen should show \"([^\"]*)\" as title and filename \"([^\"]*)\"$")
	public void next_screen_should_show_as_title_and_filename(String title, String fileName2) throws Exception {
		
		assertEquals(uploadPage.getPostUploadMesageTitle(), title);
		
		assertEquals(uploadPage.getPostUploadMesageFileName(), fileName2);
	}
}

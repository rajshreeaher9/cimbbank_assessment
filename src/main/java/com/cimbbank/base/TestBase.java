package com.cimbbank.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.cimbbank.util.TestUtil;
import com.cimbbank.util.WebEventListener;


public class TestBase {
	
	public static Properties properties;
	public static final String userDir = System.getProperty("user.dir");
	public static final String resourcesDir = userDir + "//src//main//java//com//cimbbank//resources//";
	public static final String configDir = userDir + "//src//main//java//com//cimbbank//config//";
	public static final String testDataDir = userDir + "//src//main//java//com//cimbbank//testdata//";
	public static final String propertiesFileName = "config.properties";
	public static final String propertiesFilePath = configDir + propertiesFileName;
	private static String browserName;
	protected static short scenarioCount = 0;
	public static WebDriver driver;
	public static TestUtil util;
	
	public TestBase() {
		
		// To initiate the prop
		FileInputStream fis = null;
		properties = new Properties();
		try {
			fis = new FileInputStream(propertiesFilePath);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initializeDriver() {
		
		browserName = properties.getProperty("browserType");
		EventFiringWebDriver e_driver;
		WebEventListener eventListener;
		
		if (browserName.equalsIgnoreCase("chrome")) {
			
			System.setProperty("webdriver.chrome.driver", resourcesDir + "chromedriver.exe");
			
			driver = new ChromeDriver();
			
		} else if (browserName.equalsIgnoreCase("firefox")) {
			
			System.setProperty("webdriver.gecko.driver", resourcesDir + "geckodriver.exe");
			
			driver = new FirefoxDriver();
		} 
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		
		
	}
}

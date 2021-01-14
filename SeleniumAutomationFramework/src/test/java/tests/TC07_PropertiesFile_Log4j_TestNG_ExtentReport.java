package tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import demo.ApacheLog4j;
import pages.GoogleSearchPageObjects;

public class TC07_PropertiesFile_Log4j_TestNG_ExtentReport {
	
	static Properties prop = new Properties();
	WebDriver driver = null;
	static Logger logger = LogManager.getLogger(ApacheLog4j.class);
	public static String browsername = null;
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static GoogleSearchPageObjects GoogleSearchPageObjects = null;
	
	@BeforeSuite
	public void preSuitconfig() {
		System.out.println("Inside fn: preSuitconfig");
		htmlReporter = new ExtentHtmlReporter("extentReports.html");		
		extent = new ExtentReports();		//initialize ExtentReports and attach the HtmlReporter
		extent.attachReporter(htmlReporter);		
	}
	
	
	@BeforeTest
	public void preTestValidation() throws Exception {
		
		System.out.println("Inside fn: preTestValidation");
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path
		
		InputStream input = new FileInputStream(projectPath+"/src/test/java/config/config.properties");
		prop.load(input);
		String browser = prop.getProperty("browser");
		browsername = browser;
		
		if(browsername.equalsIgnoreCase("chrome")) {
			//Setting the ChromeDriver path
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();			
		}else if(browsername.equalsIgnoreCase("firefox")) {
			//Setting the ChromeDriver path
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}
		
		//Create logs
		logger.info("Browser Started");
		
		//Maximize the browser		
		driver.manage().window().maximize();
	}
	
	@Test
	public void mainTestValidation() throws Exception {
		
		System.out.println("Inside fn: mainTestValidation");
		//create a toggle
		ExtentTest test1 = extent.createTest("Google Search", "This is to verify Google Search functionality"); 
		test1.log(Status.INFO, "Test Started");
		GoogleSearchPageObjects GoogleSearchPageObjects = new GoogleSearchPageObjects(driver); //Creating an object of page class
		driver.get("https://www.google.com");
		test1.pass("Navigated to google site");
		Thread.sleep(3000);
		GoogleSearchPageObjects.setSearchText("Selenium");
		
		Thread.sleep(3000);
		GoogleSearchPageObjects.clickGoogleSearch();
		test1.pass("Enter search string");
		test1.addScreenCaptureFromPath("screenshot.png");
		System.out.println("Clicked search");
		Thread.sleep(3000);
		System.out.println("End of Execution");
	}
	
	@AfterTest
	public void postTestValidation() {
		System.out.println("Inside fn: postTestValidation");
		driver.close();
		driver.quit();
	}
	
	@AfterSuite
	public void postSuitConfig() {
		System.out.println("Inside fn: postSuitConfig");
		extent.flush();
	}
	
	
}

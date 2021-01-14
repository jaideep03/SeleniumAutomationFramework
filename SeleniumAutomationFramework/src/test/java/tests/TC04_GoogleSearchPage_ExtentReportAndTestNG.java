package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.GoogleSearchPageObjects;

public class TC04_GoogleSearchPage_ExtentReportAndTestNG {
	
	static ExtentHtmlReporter htmlReporter;
	static ExtentReports extent;
	static WebDriver driver = null;
	static GoogleSearchPageObjects GoogleSearchPageObjects = null;
	
	@BeforeSuite
	public void preSuitconfig() {
		System.out.println("Inside fn: preSuitconfig");
		htmlReporter = new ExtentHtmlReporter("extentReports.html");		
		extent = new ExtentReports();		//initialize ExtentReports and attach the HtmlReporter
		extent.attachReporter(htmlReporter);		
	}
	
	@BeforeTest
	public void preTestValidation() {		
		System.out.println("Inside fn: preTestValidation");
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path 
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe"); //Setting the ChromeDriver path
		driver = new ChromeDriver();
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

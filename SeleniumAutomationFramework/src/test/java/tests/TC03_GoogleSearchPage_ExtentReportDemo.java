package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.GoogleSearchPageObjects;

public class TC03_GoogleSearchPage_ExtentReportDemo {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception {
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentReports.html");
		
		//initialize ExtentReports and attach the HtmlReporter
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//create a toggle
		ExtentTest test1 = extent.createTest("Google Search", "This is to verify Google Search functionality");
		
		//main test code
		test1.log(Status.INFO, "Test Started");
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path 
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe"); //Setting the ChromeDriver path
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		GoogleSearchPageObjects GoogleSearchPageObjects = new GoogleSearchPageObjects(driver); //Creating an object of page class
				
		driver.get("https://www.google.com");
		test1.pass("Navigated to google site");
		
		GoogleSearchPageObjects.setSearchText("Selenium");
		test1.pass("Enter search string");
		Thread.sleep(3000);
		GoogleSearchPageObjects.clickGoogleSearch();
		test1.pass("Clicked on google search");
		System.out.println("Clicked search");		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		test1.log(Status.INFO, "Driver closed");
		extent.flush();
	}

}

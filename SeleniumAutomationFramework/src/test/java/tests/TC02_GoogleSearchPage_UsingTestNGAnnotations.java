package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.GoogleSearchPageObjects;

public class TC02_GoogleSearchPage_UsingTestNGAnnotations {
	
	static WebDriver driver = null;
	static GoogleSearchPageObjects GoogleSearchPageObjects = null;
	
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
		GoogleSearchPageObjects GoogleSearchPageObjects = new GoogleSearchPageObjects(driver); //Creating an object of page class
		driver.get("https://www.google.com");
		Thread.sleep(3000);
		GoogleSearchPageObjects.setSearchText("Selenium");
		Thread.sleep(3000);
		GoogleSearchPageObjects.clickGoogleSearch();
		System.out.println("Clicked search");		
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void postTestValidation() {
		System.out.println("Inside fn: postTestValidation");
		driver.close();
		driver.quit();
		System.out.println("End of Execution");
	}  
  
}

package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class TC13_TestNGMultipleBrowser {
	
	WebDriver driver = null;
	String projectPath = System.getProperty("user.dir"); //Fetching the Project Path
	
	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {
		System.out.println("Browser name is: "+browserName);
		System.out.println("Thread ID is: "+Thread.currentThread().getId());
		if(browserName.equalsIgnoreCase("chrome")) {
			//Setting the ChromeDriver path
			System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			//Setting the FirefoxDriver path
			System.setProperty("webdriver.gecko.driver", projectPath+"/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver(); 
		}else if(browserName.equalsIgnoreCase("ie")) {
			//Setting the IEDriver path
			System.setProperty("webdriver.ie.driver", projectPath+"/drivers/iedriver/IEdriver.exe");
			driver = new InternetExplorerDriver(); 
		}
	}
	
	@Test
	public void maintest() {
		driver.get("https://www.google.com");
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
	}
	
	
}

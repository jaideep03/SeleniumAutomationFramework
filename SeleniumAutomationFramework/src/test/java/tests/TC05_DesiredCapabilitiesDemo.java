package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import pages.GoogleSearchPageObjects;

public class TC05_DesiredCapabilitiesDemo {
	
	static WebDriver driver = null;
	
	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		
		
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path 
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe"); //Setting the ChromeDriver path
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		GoogleSearchPageObjects GoogleSearchPageObjects = new GoogleSearchPageObjects(driver); //Creating an object of page class
				
		driver.get("https://www.google.com");
		GoogleSearchPageObjects.setSearchText("Selenium");
		Thread.sleep(3000);
		GoogleSearchPageObjects.clickGoogleSearch();
		System.out.println("Clicked search");		
		Thread.sleep(3000);
		
		driver.close();
		driver.quit();
		System.out.println("END here");
		
	}
}

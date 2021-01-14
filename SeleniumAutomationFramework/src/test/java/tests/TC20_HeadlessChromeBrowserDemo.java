package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC20_HeadlessChromeBrowserDemo {
	
	public static void main(String[] args) throws Exception {
		headlessChromeBrowser();
	}
	
	public static void headlessChromeBrowser() throws Exception {
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path 
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe"); //Setting the ChromeDriver path
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		
		WebDriver driver = new ChromeDriver(options);		
		driver.get("https://www.google.com");
		System.out.println("Title is: "+driver.getTitle());
		
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.close();
		driver.quit();
	}
	
}

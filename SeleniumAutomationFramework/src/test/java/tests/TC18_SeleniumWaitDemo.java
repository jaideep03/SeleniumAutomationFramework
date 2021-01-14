package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC18_SeleniumWaitDemo {
	
	public static void main(String[] args) throws Exception {
		seleniumWaits();
	}
	
	
	public static void seleniumWaits() throws Exception {
		
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path 
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe"); //Setting the ChromeDriver path
		WebDriver  driver = new ChromeDriver();
		
		//Implicit Wait
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("A B C D");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.name("abcdg"))); 
		
		driver.findElement(By.name("abcdg")).click();
		driver.close();
		driver.quit(); 
		
	}

}

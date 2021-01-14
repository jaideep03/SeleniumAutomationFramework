package tests;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TC19_FluentWaitDemo {
	
	public static void main(String[] args) throws InterruptedException {
		fluentWait();
	}
	
	public static void fluentWait() throws InterruptedException {
		
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path 
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe"); //Setting the ChromeDriver path
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("selenium");
		Thread.sleep(3000);
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		
		
		// Waiting 30 seconds for an element to be present on the page, checking
		   // for its presence once every 5 seconds.
		   Wait<WebDriver> wait = new FluentWait(driver)
				   .withTimeout(Duration.ofSeconds(30))
				   .pollingEvery(Duration.ofSeconds(30))
                   .ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
		     public WebElement apply(WebDriver driver) {
		       return driver.findElement(By.xpath("(//h3//span)[1]"));
		     }
		   });
		
		
		Thread.sleep(3000);
		driver.close();
		driver.quit();
	}
	
}

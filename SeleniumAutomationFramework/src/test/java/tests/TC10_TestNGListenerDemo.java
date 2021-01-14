package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;


public class TC10_TestNGListenerDemo {
	
	@Test
	public void testone() {
		System.out.println("Inside fn: testone");
	}
	
	@Test
	public void testtwo() {
		System.out.println("Inside fn: testtwo");
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.id("ABC"));
	}
	
	@Test
	public void testthree() {
		System.out.println("Inside fn: testthree");
	}
	
	
}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import utils.ExcelDataProvider;
import utils.ExcelUtils;

public class TC08_ReadExcel extends ExcelDataProvider{
	
	WebDriver driver = null;
	
	@BeforeTest
	public void preTestValidation() {
		System.out.println("Inside fn: preTestValidation");
		String projectPath = System.getProperty("user.dir"); //Fetching the Project Path
		System.setProperty("webdriver.chrome.driver", projectPath+"/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@Test(dataProvider = "TestOneData")
	public void mainTestValidation(String Username, String Password) throws Exception {
		System.out.println("Inside fn: mainTestValidation");
		System.out.println(Username+"|"+Password );
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(Username);
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		Thread.sleep(2000);		
	}

}
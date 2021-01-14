package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.google.inject.Key;

public class GoogleSearchPageObjects {
	
	WebDriver driver = null;
	
	//Defining Locators
	By txt_Search = By.xpath("//input[@name='q']");
	By btn_GoogleSearch = By.xpath("//input[@name='btnK']");
	
	//Defining Constructor
	public GoogleSearchPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	
	//Defining Methods
	public void setSearchText(String text) {
		driver.findElement(txt_Search).sendKeys(text);
	}
	
	public void clickGoogleSearch() {
		driver.findElement(btn_GoogleSearch).sendKeys(Keys.RETURN);		
	}
	
}

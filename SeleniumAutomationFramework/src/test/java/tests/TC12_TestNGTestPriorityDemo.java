package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC12_TestNGTestPriorityDemo {
	
	@Test(priority = 3)
	public void testone() {
		System.out.println("Inside fn: testone");
	}
	
	@Test(priority = -11)
	public void testtwo() {
		System.out.println("Inside fn: testtwo");
	}
	
	@Test(priority = 1)
	public void testthree() {
		System.out.println("Inside fn: testthree");
	}
}

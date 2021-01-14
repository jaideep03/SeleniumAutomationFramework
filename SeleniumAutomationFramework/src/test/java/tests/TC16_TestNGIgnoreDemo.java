package tests;


import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TC16_TestNGIgnoreDemo {

	@Test
	@Ignore
	public void testOne() {
		System.out.println("This is test one");
	}
	
	@Test
	public void testTwo() {
		System.out.println("This is test two");
	}
	
	//package-info.java file is also created to ignore all the tests in this class
}

package tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TC17_TestNGRetryFailedDemo {
	
	@Test
	public void testOne() {
		System.out.println("This is test one");
	}
	
	@Test
	public void testTwo() {
		System.out.println("This is test two");
		int i=1/0;
	}
	
	@Test(retryAnalyzer = listeners.RetryAnalyzer.class)
	public void testThree() {
		System.out.println("This is test three");
		Assert.assertTrue(10<5);
	}
}

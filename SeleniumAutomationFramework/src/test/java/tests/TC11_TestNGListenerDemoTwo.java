package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;


public class TC11_TestNGListenerDemoTwo {
	
	@Test
	public void testfour() {
		System.out.println("Inside fn: testone");
	}
	
	@Test
	public void testfive() {
		System.out.println("Inside fn: testtwo");
	}
	
	@Test
	public void testsix() {
		System.out.println("Inside fn: testthree");
	}
	
	
}

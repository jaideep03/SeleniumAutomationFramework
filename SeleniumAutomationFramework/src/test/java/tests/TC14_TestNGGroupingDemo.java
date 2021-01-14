package tests;

import org.testng.annotations.Test;

public class TC14_TestNGGroupingDemo {
	
	@Test(groups = {"sanity"})
	public void testOne() {
		System.out.println("This is TestOne");
	}
	
	@Test(groups = {"sanity", "smoke"})
	public void testTwo() {
		System.out.println("This is TestTwo");
	}
	
	@Test(groups = {"sanity","regression"})
	public void testThree() {
		System.out.println("This is TestThree");
	}
	
	@Test
	public void testFour() {
		System.out.println("This is TestFour");
	}
	
	@Test(groups = {"window.regression"})
	public void testFive() {
		System.out.println("This is TestFive");
	}
	
	@Test(groups = {"window.smoke"})
	public void testSix() {
		System.out.println("This is TestSix");
	}
	
	@Test(groups = {"linux.regression"})
	public void testSeven() {
		System.out.println("This is TestSeven");
	}
}

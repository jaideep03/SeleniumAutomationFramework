package tests;

import org.testng.annotations.Test;

public class TC15_TestNGDependenciesDemo {
	
	@Test(dependsOnMethods = {"testTwo"})
	public void testOne() {
		System.out.println("This is test one");
	}
	
	@Test
	public void testTwo() {
		System.out.println("This is test two");
	}
	
	@Test(dependsOnGroups = {"sanity"})
	public void testThree() {
		System.out.println("This is test three");
	}
	
	@Test(groups = "sanity")
	public void testFour() {
		System.out.println("This is test four");
	}

}

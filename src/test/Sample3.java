package test;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample3 {

	

	@BeforeTest
	public void a() {
		System.out.println("Before teswt");
	}
	@Test(groups= {"Regression"})
	public void first() {
		System.out.println("Sample 3 first test case executed");
	}
	@Test
	public void f() {
		System.out.println("Sample 3 second test case executed");
	}
}

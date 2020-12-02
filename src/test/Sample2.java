package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Sample2 {
	@BeforeClass
	public void h() {
		System.out.println("Before calss method for sample2 class");
	}
	@BeforeGroups("Smoke")
	public void fun() {
		System.out.println("Before all groups");
	}
	@BeforeGroups("Regression")
	public void fun1() {
		System.out.println("Before Regression groups");
	}
	@Test(groups= {"Smoke"})
	public void first() {
		System.out.println("Sample 2 first test case executed");
	}
	@Test
	public void second() {
		System.out.println("Sample 2 Second test case executed");

	}
}

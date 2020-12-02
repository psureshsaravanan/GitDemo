package test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Sample1 {
	@BeforeClass
	public void fun() {
		System.out.println("Before calss method i am");
	}
	@BeforeTest
	public void g() {
		System.out.println("Before test method i am");
	}
	@Test(groups= {"Smoke"})
	public void seccond() {
		System.out.println("Sample 1 second test case executed");
	}
	@Test
	public void first() {
		System.out.println("Sample 1 first test case executed");
	}
	
}

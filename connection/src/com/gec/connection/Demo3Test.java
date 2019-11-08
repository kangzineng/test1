package com.gec.connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Demo3Test {
	
	@Test
	public void name() {
		System.out.println("aaaa");
	}
	
	@Test
	public void name2() {
		System.out.println("bbbb");
	}
	
	@Before
	public void name3() {
		System.out.println("cccc");
	}
	
	@After
	public void name4() {
		System.out.println("dddd");
	}
	
	@BeforeClass
	public static void name5() {
		System.out.println("eeee");
	}
	
	@AfterClass
	public static void name6() {
		System.out.println("ffff");
	}
	
}

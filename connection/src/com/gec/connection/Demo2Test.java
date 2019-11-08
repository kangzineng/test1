package com.gec.connection;





import java.util.Arrays;

import junit.framework.TestCase;

public class Demo2Test extends TestCase{

	public void test1() {
		int [] arr8={50,74,32,80,64};
		Arrays.sort(arr8);
		for (int i : arr8) {
			System.out.print(i+" ");
		}
	}
	

}

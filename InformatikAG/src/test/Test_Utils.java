package test;

import java.util.Arrays;

import kpp.CElement;

import org.junit.Test;

import util.CUtils;

public class Test_Utils {

	@Test
	public void test_sort() {
	
		CElement[] test = new CElement[10];
		for( int i = 0; i < 10; i++){
			test[i] = new CElement(	(int)(Math.random()*20) +1,
									(int)(Math.random()*10) +1);
		}
		
		test = CUtils.sortByEfficiency(test);
		
		System.out.println(Arrays.toString(test));
		
	}
	
}

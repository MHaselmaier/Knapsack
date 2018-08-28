package test;

import java.util.Arrays;

import kpp.Element;

import org.junit.Test;

import util.Utils;

public class Test_Utils {

	@Test
	public void test_sort() {
	
		Element[] test = new Element[10];
		for( int i = 0; i < 10; i++){
			test[i] = new Element(	(int)(Math.random()*20) +1,
									(int)(Math.random()*10) +1);
		}
		
		test = Utils.sortByEfficiency(test);
		
		System.out.println(Arrays.toString(test));
		
	}
	
}

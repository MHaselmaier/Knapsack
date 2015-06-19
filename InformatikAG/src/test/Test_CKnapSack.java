package test;

import static org.junit.Assert.*;
import kpp.CElement;
import kpp.CKnapSack;
import kpp.KPOverflowException;

import org.junit.Test;

public class Test_CKnapSack {

	@Test
	public void test_constructor() {
	
		CKnapSack ks = new CKnapSack(0);
		assertTrue(ks instanceof CKnapSack);
		
	}
	
	@Test
	public void test_capacity(){
		
		int maxCapacity = (int)(Math.random() * 100 + 1);
		System.out.println("Testing for capacity: " + maxCapacity);
		CKnapSack ks = new CKnapSack(maxCapacity);
		
		assertTrue(maxCapacity == ks.getMaxCapacity());

		// fill ks with elements until maxCapacity is reached
		
		int freeCap = maxCapacity;
		
		do
		{
			int capacity = (int)(Math.random()* freeCap + 1);
			CElement element = new CElement(capacity, 0);
			
			try {
				ks.addElement(element);
				freeCap -= capacity;
			} catch (KPOverflowException e) {
				e.printStackTrace();
				return;
			}
			
			
		} while(freeCap > 0);
		
		System.out.println(ks.toString());
		
	}

}

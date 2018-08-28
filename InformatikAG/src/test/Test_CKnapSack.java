package test;

import static org.junit.Assert.*;
import kpp.Element;
import kpp.KnapSack;
import kpp.KPOverflowException;

import org.junit.Test;

public class Test_CKnapSack {

	@Test
	public void test_constructor() {
	
		KnapSack ks = new KnapSack(0);
		assertTrue(ks instanceof KnapSack);
		
	}
	
	@Test
	public void test_capacity(){
		
		int maxCapacity = (int)(Math.random() * 100 + 1);
		System.out.println("Testing for capacity: " + maxCapacity);
		KnapSack ks = new KnapSack(maxCapacity);
		
		assertTrue(maxCapacity == ks.getMaxWeight());

		// fill ks with elements until maxCapacity is reached
		
		int freeCap = maxCapacity;
		
		do
		{
			int capacity = (int)(Math.random()* freeCap + 1);
			Element element = new Element(capacity, 0);
			
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

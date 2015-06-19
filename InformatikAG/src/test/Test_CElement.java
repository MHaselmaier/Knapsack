package test;

import static org.junit.Assert.*;
import kpp.CElement;

import org.junit.Test;

public class Test_CElement {

	@Test
	public void test_constructort() {
		CElement el = new CElement(0, 0);
		assertTrue(el instanceof CElement);
	}
	
	@Test
	public void test_print(){
		CElement el = new CElement(1,4);
		el.print();
	}

}

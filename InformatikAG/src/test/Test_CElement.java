package test;

import static org.junit.Assert.*;
import kpp.Element;

import org.junit.Test;

public class Test_CElement {

	@Test
	public void test_constructort() {
		Element el = new Element(0, 0);
		assertTrue(el instanceof Element);
	}
	
	@Test
	public void test_print(){
		Element el = new Element(1,4);
		System.out.println(el);
	}

}

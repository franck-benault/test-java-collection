package net.franckbenault.testcollection.vector;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class VectorTestCase {
	
	@Test
	public void testCreation() {
		
		//init capacity = 3
		//then add the capacity by 3
		Vector<String> v = new Vector<String>(3);
		assertEquals(v.capacity(),3);
		
		v.add("one");
		v.add("two");
		assertEquals(v.capacity(),3);
		
		v.add("three");
		v.add("four");
		assertEquals(v.capacity(),6);
		
	}

	@Test
	public void testCreation2() {
		
		//init capacity = 3
		//then add the capacity by 2
		Vector<String> v = new Vector<String>(3, 2);
		assertEquals(v.capacity(),3);
		
		v.add("one");
		v.add("two");
		assertEquals(v.capacity(),3);
		
		v.add("three");
		v.add("four");
		assertEquals(v.capacity(),5);
	}
	
	@Test
	public void testLoop() {
		

		Vector<String> v = new Vector<String>(3, 2);
		v.add("one");
		v.add("two");
		v.add("three");
		v.add("four");

		for(String s : v) {
			System.out.println(s);
		}
		
	}
}

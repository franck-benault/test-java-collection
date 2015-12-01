package net.franckbenault.testcollection.vector;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class VectorTestCase {
	
	@Test
	public void test01Creation() {
		
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
		
		v.remove("four");
		v.remove("one");
		assertEquals(v.capacity(),6);
		
	}

	@Test
	public void test02Creation() {
		
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
	public void test03Loop() {
		

		Vector<String> v = new Vector<String>(3, 2);
		v.add("one");
		v.add("two");
		v.add("three");
		v.add("four");

		for(String s : v) {
			System.out.println(s);
		}
		
	}
	
	@Test
	public void test04AddElementRemoveElement() {
		
		//addElement and RemoveElement can be changed to add and remove
		Vector<String> v = new Vector<String>(3, 2);
		v.addElement("one");
		v.addElement("two");
		v.addElement("three");
		v.addElement("four");

		assertEquals(v.size(),4);
		
		v.removeElement("one");
		assertEquals(v.size(),3);
	}
		

}

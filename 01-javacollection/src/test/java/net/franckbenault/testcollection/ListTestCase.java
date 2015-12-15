package net.franckbenault.testcollection;

import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class ListTestCase {

	
	@Test
	public void testEmptyList() {
		
		List<String> strings = Collections.emptyList();
		
		assertTrue(strings.isEmpty());

	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testEmptyList_UnsupportedOperationException() {
		
		List<String> strings = Collections.emptyList();
		
		assertTrue(strings.isEmpty());
		
		strings.add("foo");
	}
}

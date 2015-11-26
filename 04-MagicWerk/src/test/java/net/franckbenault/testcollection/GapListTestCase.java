package net.franckbenault.testcollection;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.magicwerk.brownies.collections.GapList;

public class GapListTestCase {

	@Test
	public void testCreate() {
		// GapList replaces all ArrayList, LinkedList, ArrayDeque
		List<String> list = GapList.create("a", "b");
		
		assertNotNull(list);
		assertEquals(list.size(),2);
	}

}

package net.franckbenault.testcollection;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import jlibs.core.lang.RuntimeUtil;

public class ListMemoryTestCase {
	
	private int mb = 1024*1024;
	private static int MAX = 5_000_000;
	
	@Before
	public void before() {
		RuntimeUtil.gc();
	}
	
	private void showMemory() {
        
         
        //Getting the runtime reference from system
        Runtime runtime = Runtime.getRuntime();
         
        System.out.println("##### Heap utilization statistics [MB] #####");
         
        //Print used memory
        System.out.println("Used Memory:"
            + (runtime.totalMemory() - runtime.freeMemory()) / mb);
 
        //Print free memory
        System.out.println("Free Memory:"
            + runtime.freeMemory() / mb);
         
        //Print total available memory
        System.out.println("Total Memory:" + runtime.totalMemory() / mb);
 
        //Print Maximum available memory
        System.out.println("Max Memory:" + runtime.maxMemory() / mb);
    }

	@Test
	public void test01ListOfString() {
		System.out.println("01 list of String begin (no size, no encoding)");
		showMemory();
		List<String> bigList = new ArrayList<String>();
		
		
		for(int i=1 ; i<MAX ; i++) {
			bigList.add("S"+i);
		}
		
		System.out.println("01 list of String end (no size, no encoding)");
		showMemory();
	}

	
	@Test
	public void test02ListOfStringWithSize() {
		System.out.println("02 list of String begin (with size, no encoding)");
		showMemory();
		List<String> bigList = new ArrayList<String>(MAX);
		
		
		for(int i=1 ; i<MAX ; i++) {
			bigList.add("S"+i);
		}
		
		System.out.println("02 list of String end (with size, no encoding)");
		showMemory();
	}

	
	@Test
	public void test03ListOfStringWithSizeWithBytesEncoding() {
		System.out.println("03 list of String begin (with size, with bytes encoding)");
		showMemory();
		List<Object> bigList = new ArrayList<Object>(MAX);
		
		
		for(int i=1 ; i<MAX ; i++) {
			bigList.add(ConvertByteUtils.convert("S"+i));
		}
		
		System.out.println("03 list of String end (with size, with bytes encoding)");
		showMemory();
	}

}

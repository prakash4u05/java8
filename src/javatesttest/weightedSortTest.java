package javatesttest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import javatest.WeightedSort;

public class weightedSortTest {
	
	@Test
	public void basictest()
	{
		char c ='3';
		System.out.println(c-48);
		assertEquals("2000 103 123 4444 99",WeightedSort.weightSort1("99 4444 123 103 2000"));
	}

}

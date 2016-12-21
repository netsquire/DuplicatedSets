package sets;

import static org.junit.Assert.*;
import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class StorageTest {

	static Storage sets = new Storage();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {				
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {		
		sets = new Storage();		
		sets.insertSet("1,2,3");
		sets.insertSet("1,2,3");
		sets.insertSet("2,1,3");
		sets.insertSet("1,2,3,4");
		sets.insertSet("1,2,3,4,5");		
	}

	@After
	public void tearDown() throws Exception {
		sets = null;
	}
	
	@Test
	public void testInsertSet1() {		
		HashSet<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);
		assert(sets.get(integerSet) == 3);		
	}

	@Test
	public void testInsertSet2() {		
		HashSet<Integer> integerSet = new HashSet<Integer>();
		integerSet.add(1);
		integerSet.add(2);
		integerSet.add(3);		
		integerSet.add(4);
		integerSet.add(5);		
		assert(sets.get(integerSet) == 1);
	}

	@Test
	public void testStatistics() {		
		sets = new Storage();		
		sets.insertSet("1,2,3");
		sets.insertSet("1,2,3");
		sets.insertSet("2,1,3");		
		sets.insertSet("1,2,3,4");
		sets.insertSet("1,2,3,4");
		sets.insertSet("1,2,3,4");		
		sets.insertSet("1,2,3,4,5");
		sets.insertSet("1,2,3,4,5");		
		sets.insertSet("1,2,3,4,5,6");
		
		System.out.println("all sets: \n" + sets.dumpSets() + "=================\n");
		System.out.println("Totals: " + sets.totals());
		System.out.println("Number of non duplicated: " + sets.numberNonDuplicates());
		System.out.println("non duplicated: " + sets.getNonDuplicates());
		System.out.println("duplicated: " + sets.getDuplicates() + " -> " + sets.numberDuplicates() + " times.");
		System.out.println("Mostly duplicated: " + sets.getMostDuplicates() + " -> " + sets.getMaxDuplicates() + " times.");
	}
	
}

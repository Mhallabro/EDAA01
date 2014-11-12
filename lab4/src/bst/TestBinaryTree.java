package bst;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBinaryTree {
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	BinarySearchTree<Integer> empty;
	BinarySearchTree<Integer> full; 
	BinarySearchTree<Integer> straight;
	
	@Before
	public void setupTree() {
		empty = new BinarySearchTree<Integer>(); 
		full = new BinarySearchTree<Integer>(); 
		straight = new BinarySearchTree<Integer>();
		
	    System.setOut(new PrintStream(outContent));
	    
		full.add(3);
		full.add(1);
		full.add(4);
		
		straight.add(3);
		straight.add(2);
		straight.add(1);
	}
	
	@After
	public void cleanUp() {
		empty = null;
		full = null;
		straight = null;
		System.setOut(null);
	}
	
	@Test
	public void testAdd() {
		assertFalse(full.add(1));
	}
	
	@Test
	public void testHeight() {
		assertEquals(0, empty.height());
		assertEquals(2, full.height());
		assertEquals(3, straight.height());
	}

	@Test
	public void testSize() {
		assertEquals(0, empty.size());
		assertEquals(3, full.size());
		assertEquals(3, straight.size());
	}
	
	@Test
	public void testPrintTree() {
	    full.printTree();
	    assertEquals("1 3 4 ", outContent.toString());
	}

}

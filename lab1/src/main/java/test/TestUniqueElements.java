package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import set.UniqueElements;

public class TestUniqueElements {
    private int[] a;

    @Before
    public void setUp() throws Exception {
        a = new int[]{7, 5, 3, 5, 2, 2, 7};
    }

    @After
    public void tearDown() throws Exception {
        a = null;
    }

    @Test
    public void testUniqueElements() {
        int[] expectedArray = {2, 3, 5, 7};
        assertArrayEquals("Array not sorted correctly", expectedArray, UniqueElements.uniqueElements(a));
    }

}

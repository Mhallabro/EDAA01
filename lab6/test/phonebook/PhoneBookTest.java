package phonebook;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PhoneBookTest {

    private PhoneBook phoneBook;

    @Before
    public void setUp() throws Exception {
        this.phoneBook = new PhoneBook();
    }

    @Test
    public void testPut() throws Exception {
        assertEquals(0, phoneBook.size());
        phoneBook.put("Bob", "001");
        assertEquals(1, phoneBook.size());
        assertEquals(1, phoneBook.findNumber("Bob").size());
        phoneBook.put("Bob", "011");
        assertEquals(1, phoneBook.size());
        assertEquals(2, phoneBook.findNumber("Bob").size());
        phoneBook.put("Aaron", "002");
        assertEquals(2, phoneBook.size());
        assertEquals(1, phoneBook.findNumber("Aaron").size());
    }


    @Test
    public void testRemove() throws Exception {
        phoneBook.put("Bob", "011");
        phoneBook.put("Bob", "001");
        phoneBook.put("Aaron", "002");
        assertEquals(2, phoneBook.size());

        phoneBook.remove("Aaron");
        assertEquals(1, phoneBook.size());
        phoneBook.remove("Bob");
        assertEquals(0, phoneBook.size());
    }

    @Test
    public void testFindNumber() throws Exception {
        phoneBook.put("Bob", "001");
        assertEquals(1, phoneBook.size());
        assertEquals(1, phoneBook.findNumber("Bob").size());
        assertEquals("001", phoneBook.findNumber("Bob").get(0));
    }

    @Test
    public void testFindNames() throws Exception {
        phoneBook.put("Bob", "001");
        phoneBook.put("Aaron", "001");
        assertEquals(2, phoneBook.findNames("001").size());
        assertTrue(phoneBook.findNames("001").contains("Bob"));
        assertTrue(phoneBook.findNames("001").contains("Aaron"));
    }

    @Test
    public void testNames() throws Exception {
        phoneBook.put("Bob", "001");
        phoneBook.put("Aaron", "001");
        assertEquals(2, phoneBook.names().size());
        assertTrue(phoneBook.names().contains("Bob"));
        assertTrue(phoneBook.names().contains("Aaron"));
    }

    @Test
    public void testSize() throws Exception {
        assertEquals(0, phoneBook.size());
        phoneBook.put("Bob", "001");
        assertEquals(1, phoneBook.size());
    }
}
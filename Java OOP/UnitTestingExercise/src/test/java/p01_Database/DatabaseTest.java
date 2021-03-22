package p01_Database;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final Integer[] TEST_ARR = {2, 4, 6};
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
       this.database = new Database(TEST_ARR);
    }

    //constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testArrayCapacityIs16integers() throws OperationNotSupportedException {
        Integer[] arr = new Integer[17];
        new Database(arr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testDatabaseCannotBeEmpty() throws OperationNotSupportedException {
        new Database();
    }

    @Test()
    public void testDatabaseInitializeCorrectly() {
        Integer[] elements = database.getElements();
        assertEquals(TEST_ARR.length, elements.length);
        for (int i = 0; i < TEST_ARR.length; i++) {
            assertEquals(TEST_ARR[i], elements[i]);
        }
    }

    //add
    @Test(expected = OperationNotSupportedException.class)
    public void testCannotAddNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddsElementToDatabase() throws OperationNotSupportedException {
        database.add(1);
        Integer[] elements = database.getElements();
        int element = elements[elements.length - 1];
        assertEquals(TEST_ARR.length + 1, elements.length);
        assertEquals(1, element);
    }

    //remove
    @Test
    public void testRemovesLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] elements = database.getElements();
        int expected = TEST_ARR[TEST_ARR.length - 2];
        int actual = elements[elements.length - 1];
        assertEquals(TEST_ARR.length - 1, elements.length);
        assertEquals(expected, actual);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowsExceptionOnEmptyArr() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
    }
}
package p05_CustomLinkedList;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> list;
    private static final int[] TEST_ARRAY = {3, 5, 4, 2};
    private static final int TEST_ELEMENT = 1;

    @Before
    public void setUp() {
        this.list = new CustomLinkedList<>();
        for (int i : TEST_ARRAY) {
            list.add(i);
        }

    }

    //get
    @Test(expected = IllegalArgumentException.class)
    public void testGetFailsForInvalidIndex() {
        list.get(TEST_ARRAY.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFailsForNegativeIndex() {
        list.get(-1);
    }

    @Test
    public void testGetReturnsCorrectValue() {
        for (int i = 0; i < TEST_ARRAY.length; i++) {
            assertEquals(TEST_ARRAY[i], (int) list.get(i));
        }
    }

    //set
    @Test(expected = IllegalArgumentException.class)
    public void testSetFailsForInvalidIndex() {
        list.set(TEST_ARRAY.length, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFailsForNegativeIndex() {
        list.set(-1, 1);
    }

    @Test
    public void testSetsElementValueCorrectly() {
        list.set(1, TEST_ELEMENT);
        assertEquals(TEST_ELEMENT, (int) list.get(1));
    }

    //add
    @Test
    public void testAddsElementCorrectly() {
        list.add(TEST_ELEMENT);
        assertEquals(TEST_ELEMENT, (int) list.get(TEST_ARRAY.length));
    }

    //removeAt
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtFailsForInvalidIndex() {
        list.removeAt(TEST_ARRAY.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtForNegativeIndex() {
        list.removeAt(-1);
    }

    @Test
    public void testRemoveAtDeletesCorrectly() {
        int removedElement = list.removeAt(0);
        assertEquals(TEST_ARRAY[0], removedElement);
        assertEquals(TEST_ARRAY[1], (int) list.get(0));
    }

    //remove
    @Test
    public void testRemovesCorrectly() {
        for (int i = 0; i < TEST_ARRAY.length - 1; i++) {
            int removedElementIndex = list.remove(TEST_ARRAY[i]);
            assertEquals(0, removedElementIndex);
            assertEquals(TEST_ARRAY[i + 1], (int) list.get(0));
        }
    }

    @Test
    public void testRemoveReturnsCorrectValueForNonExistingElement(){
        int removedElementIndex = list.remove(TEST_ELEMENT);
        assertEquals(-1,removedElementIndex);
    }

    //indexOf
    @Test
    public void testIndexOfReturnsValueCorrectly() {
        for (int i = 0; i < TEST_ARRAY.length - 1; i++) {
            int elementIndex = list.indexOf(TEST_ARRAY[i]);
            assertEquals(i, elementIndex);
        }
    }

    @Test
    public void testIndexOfReturnsCorrectValueForNonExistingElement() {
        int elementIndex = list.indexOf(TEST_ELEMENT);
        assertEquals(-1,elementIndex);
    }

    //contains
    @Test
    public void testContainsReturnsTrueForExistingElements() {
        for (int i = 0; i < TEST_ARRAY.length - 1; i++) {
            boolean contains = list.contains(TEST_ARRAY[i]);
            assertTrue(contains);
        }
    }

    @Test
    public void testContainsReturnsFalseForNonExistingElements() {
        boolean contains = list.contains(TEST_ELEMENT);
        assertFalse(contains);
    }
}
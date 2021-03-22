package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static final String[] TEST_ARR = {
            "First",
            "Second",
            "Third"
    };
    private ListIterator iterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        this.iterator = new ListIterator(TEST_ARR);
    }

    //constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testIteratorCannotBeCreatedWithoutElements() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    //move
    @Test
    public void testMoveReturnsNextIndex(){
        boolean move = iterator.move();
        assertTrue(move);
    }
    @Test
    public void testMoveReturnsFalseWhenNextIndexIsOutsideOfBounds(){
        for (int i = 0; i < 3; i++) {
            iterator.move();
        }
        boolean move = iterator.move();
        assertFalse(move);
    }

    //hasNext
    @Test
    public void testHasNextReturnsNextIndex(){
        boolean hasNext = iterator.hasNext();
        assertTrue(hasNext);
    }
    @Test
    public void testHasNextReturnsFalseWhenNextIndexIsOutsideOfBounds(){
        for (int i = 0; i < 3; i++) {
            iterator.move();
        }
        boolean hasNext = iterator.hasNext();
        assertFalse(hasNext);
    }

    //print
    @Test
    public void testPrintReturnsTheCorrectElement(){
        int index = 0;
        while (iterator.hasNext()){
            String element = iterator.print();
            assertEquals(element,TEST_ARR[index++]);
            iterator.move();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintFailsForEmptyCollection() throws OperationNotSupportedException {
        iterator = new ListIterator();
        iterator.print();
    }
}
package p03_IteratorTest;

import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class IteratorTest {

    private ListIterator listIterator;

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorFailsGettingNull() throws OperationNotSupportedException {
        listIterator = new ListIterator( null);
    }

    @Test
    public void testConstructorInitializedCorrectly() throws OperationNotSupportedException {
        listIterator = new ListIterator("first_string", "second_string", "third_string");
        assertNotNull(listIterator);
    }

    @Test
    public void testMoveReturnsTrueWhenNextElementExists() throws OperationNotSupportedException {
        listIterator = new ListIterator("first_string", "second_string", "third_string");
        assertTrue(listIterator.move());
        assertTrue(listIterator.move());
    }

    @Test
    public void testMoveReturnsFalseWhenNextElementNotExists() throws OperationNotSupportedException {
        listIterator = new ListIterator("firs_string");
        assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextReturnsTrueWhenNextElementExists() throws OperationNotSupportedException {
        listIterator = new ListIterator("first_string", "second_string", "third_string");
        assertTrue(listIterator.hasNext());
    }

    @Test
    public void testHasNextReturnsFalseWhenNextElementNotExists() throws OperationNotSupportedException {
        listIterator = new ListIterator("first_string");
        assertFalse(listIterator.hasNext());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testPrintReturnsExceptionWhenNoElements() throws OperationNotSupportedException {
        listIterator = new ListIterator( null);
        listIterator.print();
    }

    @Test
    public void testPrintReturnsCurrentElement() throws OperationNotSupportedException {
        listIterator = new ListIterator("first_string", "second_string", "third_string");
        assertEquals("first_string", listIterator.print());
        listIterator.move();
        assertEquals("second_string", listIterator.print());
        listIterator.move();
        assertEquals("third_string", listIterator.print());
    }




}

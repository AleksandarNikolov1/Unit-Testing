package p01_Database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final int BOUND = 16;
    private Database db;
    private static final Integer[] ELEMENTS = new Integer[]{1, 2, 3, 4};

    @Before
    public void setUp() throws OperationNotSupportedException {
        db = new Database(ELEMENTS);
    }

    @Test
    public void testDbIsInitializedProperlyWithElementsLessThanSixteen() {
        assertNotNull(db);
        assertEquals(ELEMENTS.length, db.getElements().length);
        assertArrayEquals(ELEMENTS, db.getElements());
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testDbThrowsExceptionIfCapacityDifferentThanSixteen() throws OperationNotSupportedException {
        db = new Database(new Integer[BOUND + 1]);
    }

    @Test
    public void testAddOperationShouldAddElementAtNextFreeCell() throws OperationNotSupportedException {
        Integer addedElement = 5;
        db.add(addedElement);
        assertEquals(ELEMENTS.length + 1, db.getElements().length);
        assertEquals(addedElement, db.getElements()[db.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddOperationWithNullElement() throws OperationNotSupportedException {
        Integer addedElement = null;
        db.add(addedElement);
    }

    @Test
    public void testRemoveOperationShouldRemoveLastElementOnly() throws OperationNotSupportedException {
        db.remove();
        assertEquals(ELEMENTS.length - 1, db.getElements().length);

        for (Integer element : db.getElements()) {
            assertNotNull(element);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveOperationFromEmptyDatabase() throws OperationNotSupportedException {
        db = new Database();
        db.remove();
    }
}

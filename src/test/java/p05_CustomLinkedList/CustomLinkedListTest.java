package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {

    private static final int LAST_INDEX = 2;

    private CustomLinkedList<String> customLinkedList;

    @Before
    public void setUp(){
        customLinkedList = new CustomLinkedList<>();
        customLinkedList.add("test1");
        customLinkedList.add("test2");
        customLinkedList.add("test3");
    }

    @Test
    public void testGetElementForValidIndex(){
        String expected = "test2";
        String actual = customLinkedList.get(1);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFailsForInvalidIndexLessThanZero(){
        customLinkedList.get(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetFailsForInvalidIndexGreaterThanListSize(){
        customLinkedList.get(LAST_INDEX + 1);
    }

    @Test
    public void testSetElementForValidIndex(){
        String expected = "test4";
        customLinkedList.set(LAST_INDEX - 1, expected);
        String actual = customLinkedList.get(LAST_INDEX -1);
        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFailsForInvalidIndexLessThanZero() {
        customLinkedList.set(-1, "test4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetFailsForInvalidIndexGreaterThanListSize() {
        customLinkedList.set(LAST_INDEX + 1, "test4");
    }

    @Test
    public void testAddForGivenItemLikeLastElementOfTheList(){
        String actual = "test4";
        customLinkedList.add(actual);
        String expected = customLinkedList.get(LAST_INDEX + 1);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveAtForValidIndex(){
        String expected = "test2";
        String nextElement = "test3";
        String actual = customLinkedList.removeAt(1);

        assertEquals(expected, actual);
        assertEquals(customLinkedList.get(1), nextElement);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveAtForInvalidIndexLessThanZero() {
        customLinkedList.removeAt(-1);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveAtForInvalidIndexGreaterThanListCount() {
        customLinkedList.removeAt(LAST_INDEX + 1);
    }

    @Test
    public void testRemoveAndReturnsIndexOfExistingElement(){
        int expected = 1;
        int actual = customLinkedList.remove("test2");

        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveReturnsNegativeIndexForNoExistingElement(){
        int expected = -1;
        int actual = customLinkedList.remove("I don't exist");

        assertEquals(actual, expected);
    }

    @Test
    public void testIndexOfReturnsIndexOfExistingElement(){
        int expected = customLinkedList.indexOf(customLinkedList.get(LAST_INDEX));

        assertEquals(expected, LAST_INDEX);
    }

    @Test
    public void testIndexOfReturnsNegativeIndexForNoExistingElement(){
        int expected = -1;
        int actual = customLinkedList.indexOf("I don't exist");

        assertEquals(expected, actual);
    }

    @Test
    public void testContainsReturnsTrueForExistingElement(){
        assertTrue(customLinkedList.contains("test1"));
    }

    @Test
    public void testContainsReturnFalseForNoExistingElement(){
        assertFalse(customLinkedList.contains("I don't exist"));
    }
}


package p04_BubbleSortTest;

import org.junit.Test;
import static org.junit.Assert.*;

public class BubbleSortTest {

    @Test
    public void testSort() {
        // Подготвяне на входни данни за сортиране
        int[] arr = {5, 3, 8, 1, 2};

        // Извикване на метода за сортиране
        Bubble.sort(arr);

        // Проверка дали масивът е сортиран правилно
        assertArrayEquals(new int[]{1, 2, 3, 5, 8}, arr);
    }

    @Test
    public void testSortWithEmptyArray() {
        // Подготвяне на празен масив
        int[] arr = {};

        // Извикване на метода за сортиране
        Bubble.sort(arr);

        // Проверка дали празният масив остава празен
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    public void testSortWithAlreadySortedArray() {
        // Подготвяне на вече сортиран масив
        int[] arr = {1, 2, 3, 4, 5};

        // Извикване на метода за сортиране
        Bubble.sort(arr);

        // Проверка дали вече сортираният масив остава непроменен
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    public void testSortWithSingleElementArray() {
        // Подготвяне на масив с един елемент
        int[] arr = {42};

        // Извикване на метода за сортиране
        Bubble.sort(arr);

        // Проверка дали масивът с един елемент остава непроменен
        assertArrayEquals(new int[]{42}, arr);
    }
}

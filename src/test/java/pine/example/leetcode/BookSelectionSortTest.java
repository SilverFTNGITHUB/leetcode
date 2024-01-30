package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class BookSelectionSortTest {
    @Test
    void selectionSortOri(){
        BookSelectionSort bookSelectionSort = new BookSelectionSort();
        int[] arr = {4,3,1,5,1,7,5,0,0};
        bookSelectionSort.selectionSortOri(arr);
        System.out.println(Arrays.toString(arr));
    }

}
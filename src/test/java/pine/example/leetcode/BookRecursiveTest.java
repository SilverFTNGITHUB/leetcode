package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookRecursiveTest {
    @Test
    void sumTest(){
        int[] arr = {1,2,3,4,5};
        BookRecursive bookRecursive = new BookRecursive();
        System.out.println(bookRecursive.sum(arr));
    }

    @Test
    void findBiggestTest(){
        int[] arr = {3,12,3,4,31,34,5};
        BookRecursive bookRecursive = new BookRecursive();
        System.out.println(bookRecursive.findBiggest(arr));
    }
}
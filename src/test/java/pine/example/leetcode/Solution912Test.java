package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution912Test {
    @Test
    void sortArrayTest() {
        Solution912 s912 = new Solution912();
        int[] nums = {3, 2, 5, 4, 1};
        //int[] nums = {1,3,2};
        System.out.println(Arrays.toString(s912.sortArray(nums)));
    }

    @Test
    void divideArrayTest() {
        Solution912 s912 = new Solution912();
        int[] nums = {1,2};
        System.out.println("new pivotId = " + s912.divideArray(nums, 0, 1, 1));
        System.out.println(Arrays.toString(nums));
    }

}
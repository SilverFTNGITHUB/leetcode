package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution26Test {
    @Test
    void removeDuplicatesTest(){
        Solution26 s26 = new Solution26();
        int[] nums = {1,1,2};
        int length = s26.removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, length)));

    }

}
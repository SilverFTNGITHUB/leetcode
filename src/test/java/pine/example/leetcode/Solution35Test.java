package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution35Test {
    @Test
    void searchInsertTest(){
        Solution35 s35 = new Solution35();
        int nums[] = {};
        int target = 1;
        int insertId = s35.searchInsert(nums, target);
        System.out.println(insertId);

    }

}
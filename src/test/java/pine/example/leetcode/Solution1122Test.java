package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Solution1122Test {

    @Test
    void relativeSortArrayTest(){
        int arr1[] = {2,3,1,3,2,4,6,7,9,2,19};
        int arr2[] = {2,1,4,3,9,6};
        Solution1122 s1122 = new Solution1122();
        System.out.println(Arrays.toString(s1122.relativeSortArray(arr1, arr2)));
    }

}
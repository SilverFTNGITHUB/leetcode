package pine.example.leetcode.mergeSortedArray88;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    @Test
    void mergeYTTest() {
        Solution s = new Solution();
        int nums1[] = {1,3,5,5,0,0,0,0};
        int m = 4;
        int nums2[] = {2,3,4,6};
        int n = 4;


        s.mergeYT(nums1,m,nums2,n);
        System.out.println("mergeYT "+Arrays.toString(nums1));
    }

    @Test
    void merge3Test() {
        Solution s = new Solution();
        int nums1[] = {1,3,5,5,0,0,0,0};
        int m = 4;
        int nums2[] = {2,3,4,6};
        int n = 4;


        s.merge3(nums1,m,nums2,n);
        System.out.println("merge3 "+Arrays.toString(nums1));
    }
}
package pine.example.leetcode.mergeSortedArray88;

import java.util.Arrays;

class Solution {
    /**
     * Two Pointers YT standard answer
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void mergeYT(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int i = m + n - 1;
        int looptimes = 0;
        while (p2 >= 0) {
            if (p1 >= 0 && nums1[p1] > nums2[p2]) {
                // 这里p2并没有改变
                // 所以虽然只有一层循环
                // 但这里的代码块也会在同一种p2下运行多次
                // 所以虽然只有一层循环，但并不是只循环n次！
                nums1[i] = nums1[p1];
                i--;
                p1--;
                looptimes++;
            } else {
                nums1[i] = nums2[p2];
                i--;
                p2--;
                looptimes++;
            }
        }
        System.out.println(looptimes);

    }

    /**
     * try-3 after (kinda) understand 2 pointers
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int updateEnd = m + n - 1;
        while (p2 >= 0) {
            // p2>=0 => nums2中还有要处理的
//            if(p1 < 0) {
//                // nums1 > all rest nums2, put rest nums2 into nums1 (before updateEnd)
//                nums1[updateEnd] = nums2[p2];
//                updateEnd--;
//                p2--;
//            } else if (nums2[p2] > nums1[p1]) {
//                nums1[updateEnd] = nums2[p2];
//                updateEnd--;
//                p2--;
//            } //两种情况处理相同，合并
            if (p1 < 0 || nums2[p2] > nums1[p1]) {
                nums1[updateEnd] = nums2[p2];
                updateEnd--;
                p2--;
            } else {
                nums1[updateEnd] = nums1[p1];
                updateEnd--;
                p1--;
                // ! May p1<0 : need to put rest nums2 into nums1 (before updateEnd)
            }
        }
    }


    /**
     * try-2 after watch YT 20240126
     * (not really) Two Pointers
     * Two Pointers的重点是只有一个循环
     * 但是我大致测试了一下
     * 实际上这种双循环的写法和TwoPointers的循环数是一样的
     * 只是看起来有两层循环更冗余，实际上并没有？
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int updateEnd = m + n - 1;
        int looptimes = 0;
        while (p1 >= 0) {
            //nums1
            while (p2 >= 0) {
                //nums2
                if (nums2[p2] >= nums1[p1]) {
                    //put nums2[p2] to updateEnd
                    nums1[updateEnd] = nums2[p2];
                    updateEnd--;
                    p2--;
                    looptimes++;
                } else {
                    //nums1[i] > all rest nums2
                    // put nums1[p1] to updateEnd
                    nums1[updateEnd] = nums1[p1];
                    updateEnd--;
                    // p2 no --
                    looptimes++;
                    break;
                }
            }
            p1--;
        }
        //if(p1 < 0 && p2 >= 0) {
        if (p2 >= 0) {
            //rest nums2 > all nums1
            for (int i = 0; i <= p2; i++) {
                nums1[i] = nums2[i];
                looptimes++;
            }
        }
        System.out.println(looptimes);
    }

    /**
     * try-1 20240125
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int last1 = 0;
        int updateM = m;
        boolean ok = false;//all rest nums2 (num2[>=bigger2index]) bigger than nums1
        int bigger2index = 0;
        if (m == 0) {
            ok = true;
        }
        for (int i = 0; i < n; i++) {
            //nums2
            for (int j = last1; j < updateM; j++) {
                //nums1
                if (nums2[i] <= nums1[j]) {
                    //insert nums2[i] before nums1[j]
                    // (1) push back nums1 for 1 interval (from [j])
                    for (int k = updateM - 1; k >= j; k--) {
                        nums1[k + 1] = nums1[k];
                    }
                    // (2) insert nums2[i] into interval (nums1[j])
                    nums1[j] = nums2[i];
                    // ! index change
                    System.out.println(Arrays.toString(nums1));
                    j++;
                    updateM++;
                    last1 = j;
                    break;
                } else if (j == updateM - 1) {
                    //nums2[i] > all rest nums1
                    bigger2index = i;
                    ok = true;
                    break;
                }
            }
            if (ok) {
                break;

            }
        }
        if (ok) {
            //put rest nums[2] into nums[1] end
            for (int i = bigger2index; i < n; i++) {
                //nums[2]
                nums1[updateM] = nums2[i];
                updateM++;
            }
        }
    }
}
package pine.example.leetcode;

/**
 * 35. Search Insert Position
 */
public class Solution35 {

    /**
     * third try
     * optimized writing logic
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        // Edge case: nums.length == 0, no required solution.
        // Will fail.
        int high = nums.length - 1;// high of guess space
        int low = 0;// low of guess space
        // guess space include high and low
        int middle = (high + low) / 2;// (middle) guess
        while (low <= high) {
            // still got guess space
            //update middle
            middle = (high + low) / 2;
            if (nums[middle] == target) {
                // target exist, find
                return middle;
            } else if (nums[middle] < target) {
                //move low
                low = middle + 1;//+1: already know [middle] is not target
            } else if (nums[middle] > target) {
                // move high
                high = middle - 1;
            }
        }
        //low > high && no target find
        //no more meaningful search space
        //target not exist
        if (nums[middle] < target) {
            return middle + 1;
        } else {
            return middle;
        }
    }

    /**
     * first try
     * 20240127
     * writing after reading binary search in book
     * !!! INFINITE LOOP (when [1,3] 0)
     */
    public int searchInsert1(int[] nums, int target) {
        // high, low: form guess space
        int high = nums.length - 1;
        int low = 0;
        // middle: the guess number
        int middle = (high + low) / 2;
        while (true) {
            middle = (high + low) / 2;//round down
            if (nums[middle] == target) {
                //find, target exist
                return middle;
            } else if (middle == low && middle == high) {
                // no more move space
                // can't find, target does not exist
                if (nums[middle] < target) {
                    return middle + 1;
                } else {
                    return middle;
                }
            } else if (nums[middle] > target) {
                // too big, move high
                high = middle - 1;//middle - 1: cause already know middle is not
            } else if (nums[middle] < target) {
                // too small, move low
                low = middle + 1;
            }
            // if not exist, high == low == middle, nums[middle] != target
        }

    }

    /**
     * second try
     * 20240127
     * debug [1,3] 0, problem is about edge case
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert2(int[] nums, int target) {
        // high, low: form guess space
        int high = nums.length - 1;
        int low = 0;
        // middle: the guess number
        int middle = (high + low) / 2;
        while (true) {
            if (nums[middle] == target) {
                //find, target exist
                return middle;
            } else if (nums[middle] > target) {
                // too big, move high
                high = middle - 1;//middle - 1: cause already know middle is not
            } else if (nums[middle] < target) {
                // too small, move low
                low = middle + 1;
            }
            // got new guess space
            if (low > high) {
                // no more legal guess space
                // target not exist
                if (nums[middle] < target) {
                    return middle + 1;
                } else {
                    return middle;
                }
            }
            // yes more legal guess space
            // new middle
            middle = (high + low) / 2;//round down
        }
    }
}

package pine.example.leetcode;

public class Solution26 {

    /**
     * second try 20240130
     * O(n)
     * after read solution in discussion
     * actually, move dupilicates out of the bound of distinct-length
     * Fast-Slow Pointers
     *
     * WHY faster?
     * BECAUSE use fast-slow pointers, single loop
     * BECAUSE use swap single ele, instead of move multiple eles
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int distincts = 0;//slow pointer
        int probe = 0;//fast pointer
        // ~ distincts: no duplicates
        // distincts ~ probe: trashed duplicates
        // probe ~: unmoved
        while (probe < nums.length - 1) {
            // O(n)
            if (nums[probe] != nums[probe + 1]) {
                // probe+1 is new distinct
                // move [probe+1] to distincts section
                nums[distincts + 1] = nums[probe + 1];
                // enlarge distincts section
                distincts++;
            }
            probe++;
        }
        return distincts + 1;
    }

    /**
     * first try 20240130
     * can only figure out in O(n^2) way
     *
     * @param nums
     * @return
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int noDup = nums.length - 1;
        int end = nums.length - 1;
        while (noDup > 0) {
            //O(n)
            while (noDup > 0 && nums[noDup - 1] != nums[noDup]) {
                //O(n)
                noDup--;
            }
            // noDup stop
            if (noDup <= 0) {
                break;
            }
            // ..., A, A([noDup]), B, ...
            int dupStart = noDup - 1;
            while (dupStart > 0 && nums[dupStart - 1] == nums[dupStart]) {
                //O(n)
                dupStart--;
            }
            // dupStart stop
            // ..., C, A([dupStart]), A, A([noDup]), B, ...
            for (int i = noDup; i <= end; i++) {
                //O(n)
                // move {[noDup], ...} to dupStart
                nums[i - noDup + dupStart] = nums[i];
            }
            //update noDup, end
            end = dupStart + end - noDup;
            noDup = end;
        }
        return end + 1;
    }
}

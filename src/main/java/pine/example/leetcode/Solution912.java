package pine.example.leetcode;

import java.util.Arrays;

/**
 *
 */
public class Solution912 {
    /**
     * second try 20240129
     * quicksort
     * use swap to divide, no new arr[]
     *
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        return quickSort(nums, 0, nums.length - 1);
    }

    /**
     * help function for sortArray
     * quicksort nums ( only [] from start to end)
     * use swap to divide, no new arr[]
     * UNOPTIMIZED pivot chose
     *
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int[] quickSort(int[] nums, int start, int end) {
        // f(x) => sort input array
        // base case => input array.length = 0 || 1
        // rec case =>
        // (1) choose a pivot
        // (2) divide input arr to {<= pivot}, {>= pivot}
        // (3) return [f({<= pivot}), pivot, f({>= pivot})]
        if (end <= start) {
            // 1- base case
            return nums;
        } else {
            // 2- rec case
            // (1) choose a pivot
            int pivotId = start; // OPTIMIZE
            // (2) divide input arr to {<= pivot}, {>= pivot}
            pivotId = divideArray(nums, start, end, pivotId);
            // (3) sort
            quickSort(nums, start, pivotId - 1);// sort {<= pivot}
            quickSort(nums, pivotId + 1, end);// sort {>= pivot}
            // (4) return
            return nums;
        }
    }

    /**
     * divide arr(from start to end) to {<= pivot}, {pivot}, {>= pivot}
     * reference - [book] DS and AA in JAVA
     * premise: end > start, picotId in end~start
     * @param nums
     * @param start
     * @param end
     * @param pivotId
     * @return new pivotId after divide
     */
    public int divideArray(int[] nums, int start, int end, int pivotId) {
        //move pivot to end
        //divide arr to {<= pivot}, {>= pivot}
        //move pivot back
        // 1- move pivot to end
        int pivot = nums[pivotId];
        nums[pivotId] = nums[end];
        nums[end] = pivot;
        // 2 - divide arr
        int smallerEnd = start;
        int biggerStart = end - 1;
        // < smallerEnd, [] smaller than pivot
        // > biggerStart, [] bigger than pivot
        while (true) {//<=: pretend smallerEnd == biggerStart at first place
            //still got undivided arr
            while (nums[smallerEnd] < pivot) {
                smallerEnd++;//move smallerEnd ->
                // pivot at end SO will not move over stack
                // WHY allow smallerEnd move to pivotId
                // TO pretend all other arrs < pivot, which cause problem in the final swap
            }
            while (biggerStart >= start && nums[biggerStart] > pivot) {
                biggerStart--;//move biggerStart <-
            }
            //both stop, smallerEnd -> [ >= p] && biggerStart -> [ <= p]
            //swap this 2 []
            if (smallerEnd < biggerStart) {
                int smallerEndEle = nums[smallerEnd];
                nums[smallerEnd] = nums[biggerStart];
                nums[biggerStart] = smallerEndEle;
            } else {
                break;
            }
        }
        // now, smallerEnd at first [ >= p] (may be pivotId itself),
        // biggerStart at last [ <= p] (may be -1 out of stack)

        // 3- move pivot back
        // swap [smallerEnd] [p]([last])
        nums[end] = nums[smallerEnd];
        nums[smallerEnd] = pivot;
        return smallerEnd;
    }

//    /**
//     * divide arr(from start to end) to {<= pivot}, {pivot}, {>= pivot}
//     * reference - [book] DS and AA in JAVA
//     * premise: end > start, picotId in end~start
//     * @param nums
//     * @param start
//     * @param end
//     * @param pivotId
//     * @return new pivotId after divide
//     */
//    public int divideArray(int[] nums, int start, int end, int pivotId) {
//        //move pivot to end
//        //divide arr to {<= pivot}, {>= pivot}
//        //move pivot back
//        // 1- move pivot to end
//        int pivot = nums[pivotId];
//        nums[pivotId] = nums[end];
//        nums[end] = pivot;
//        // 2 - divide arr
//        int smallerEnd = start;
//        int biggerStart = end - 1;
//        // < smallerEnd, [] smaller than pivot
//        // > biggerStart, [] bigger than pivot
//        while (smallerEnd <= biggerStart) {//<=: pretend smallerEnd == biggerStart at first place
//            //still got undivided arr
//            while (nums[smallerEnd] < pivot) {
//                smallerEnd++;//move smallerEnd ->
//            }
//            while (nums[biggerStart] > pivot) {
//                biggerStart--;//move biggerStart <-
//            }
//            //both stop, smallerEnd -> [ >= p] && biggerStart -> [ <= p]
//            //swap this 2 []
//            if (smallerEnd < biggerStart) {
//                int smallerEndEle = nums[smallerEnd];
//                nums[smallerEnd] = nums[biggerStart];
//                nums[biggerStart] = smallerEndEle;
//            }
//        }
//        // 3- move pivot back
//        // now, smallerEnd at first [ >= p], biggerStart at last [ <= p]
//        // swap [smallerEnd] [p]([last])
//        nums[end] = nums[smallerEnd];
//        nums[smallerEnd] = pivot;
//        return smallerEnd;
//    }

    /**
     * first try 20240129
     * quick sort
     * Memory Limit Exceed, create too many arr for divide
     *
     * @param nums
     * @return
     */
    public int[] sortArray1(int[] nums) {
        // f(x) => output is sorted input
        // base case input.length = 0 or 1
        // rec: unsorted input
        // 1- choose pivot
        // 2- devide input [ele < pivot] pivot [ele > pivot]
        // 3- return f([]) + pivot + f([]), output sorted input
        if (nums.length == 0 || nums.length == 1) {
            // base case
            return nums;
        } else {
            // recursive case
            // 1- divided into unsort small, pivot, unsort big
            int[] smallArrayRaw = new int[nums.length];
            int smallLength = 0;
            int[] bigArrayRaw = new int[nums.length];
            int bigLength = 0;
            int pivot = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] < pivot) {
                    smallArrayRaw[smallLength] = nums[i];
                    smallLength++;
                } else {
                    bigArrayRaw[bigLength] = nums[i];
                    bigLength++;
                }
            }

            // sort small and big
            int[] smallArray = Arrays.copyOf(smallArrayRaw, smallLength);
            System.arraycopy(
                    sortArray(smallArray), 0,
                    nums, 0, smallLength);
            nums[smallLength] = pivot;
            int[] bigArray = Arrays.copyOf(bigArrayRaw, bigLength);
            System.arraycopy(
                    sortArray(bigArray), 0,
                    nums, smallLength + 1, bigLength);

            return nums;
        }
    }

}

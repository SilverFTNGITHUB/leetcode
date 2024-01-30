package pine.example.leetcode;

import java.util.Arrays;

/**
 * Grokking Algorithm
 * exercise 4
 */
public class BookRecursive {
    /**
     * 4.1
     * Use recursive to do sum
     */
    int sum(int[] arr) {
        return sum(arr, arr.length - 1);
    }

    /**
     * 4.2
     * Use recursive to calculate array length
     *
     * @param arr
     * @return
     */
    int arrLength(int[] arr) {
        //太神经了，java搞得很麻烦（因为每次都要copy和new []做对比），不写了
        return 0;
    }

    /**
     * 4.3
     * Use recursive to find max in arr
     */
    int findBiggest(int[] arr) {
        return findBiggest(arr, arr.length - 1);

    }

    /**
     * help function for findBiggest
     *
     * @param arr
     * @param i
     * @return
     */
    private int findBiggest(int[] arr, int i) {
//        if (i < 0) {
//            //base case A
//            return null;
//        }
        if (i == 0) {
            // base case B
            return arr[0];
        } else {
            //rec
            return Math.max(arr[i], findBiggest(arr, i - 1));
        }
    }


    /**
     * help function for sum()
     */
    private int sum(int[] arr, int i) {
        if (i < 0) {
            //base case A
            return 0;
        } else if (i == 0) {
            // base case B
            return arr[0];
        } else {
            // recursive
            return arr[i] + sum(arr, i - 1);
        }
    }


}

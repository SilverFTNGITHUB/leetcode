package pine.example.leetcode;

public class Solution1122 {
    /**
     * first try
     * saw this question randomly
     * alter arr1
     * use selection sort
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int unsort = 0;
        for(int i = 0; i < arr2.length; i++) {
            // arr2
            for(int j = unsort; j < arr1.length; j++) {
                // arr1
                if(arr1[j] == arr2[i]) {
                    // find target
                    // 令target与unsort交换位置
                    // (也可以把target挤进去，但别的都要往后推一个 耗时)
                    int oriUnsort = arr1[unsort];
                    arr1[unsort] = arr1[j];
                    arr1[j] = oriUnsort;
                    unsort++;
                }
            }
        }
        // unsort前的已按照arr2 sort完
        // unsort后（）包括 的需要按ascend排列
        // selection sort
        int start = unsort;
        while(start < arr1.length) {
            // from start to arr1.length - 1, find smallest
            // put [smallest] to [start]
            // start ++
            // 1- find smallest
            int smallest = arr1[start];
            int smallestId = start;
            for(int i = start; i < arr1.length; i++) {
                if(arr1[i] < smallest) {
                    smallest = arr1[i];
                    smallestId = i;
                }
            }
            // 2- put [smallest] to [start]
            int oriStart = arr1[start];
            arr1[start] = smallest;
            arr1[smallestId] = oriStart;
            // 3- start++
            start++;

        }
        return arr1;
    }
}

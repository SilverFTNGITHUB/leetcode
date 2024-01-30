package pine.example.leetcode;

public class BookSelectionSort {
    /**
     * alter input array
     * If use selection sort, input array will (unavoidable) altered
     * @param arr
     */
    void selectionSortOri(int[] arr) {
        int unsort = 0;
        while(unsort < arr.length) {
            // still got some unsort
            // find smallest in unsort ~ arr.length - 1
            // swap smallest with [unsort]
            // unsort++
            // 1- find smallest in unsort ~ arr.length - 1
            int smallest = arr[unsort];
            int smallestId = unsort;
            for(int i = unsort; i < arr.length; i++) {
                if(arr[i] < smallest) {
                    smallest = arr[i];
                    smallestId = i;
                }
            }
            // 2- swap smallest with [unsort]
            int oriUnsort = arr[unsort];
            arr[unsort] = smallest;
            arr[smallestId] = oriUnsort;
            // 3- unsort++
            unsort++;
        }
    }

//    /**
//     * ABORTED
//     * return sorted array
//     * CANT ACHIEVE no change on input arr
//     * @param arr
//     * @return
//     */
//    int[] selectionSortNew(int[] arr) {
//        int[] retArr = new int[arr.length];
//        int retArrEnd = 0;
//        for(int i = 0; i < arr.length; i++) {
//            // find smallest in i ~ arr.length-1
//            // put it in retArrEnd
//            // delete it from ori arr <= cant avoid, therefore cant avoid alter ori arr
//            // 1- find smallest in i ~ arr.length-1
//            int smallest = arr[i];
//            //int smallestId = i;
//            for(int j = i; j < arr.length; j++) {
//                if(arr[j] < smallest) {
//                    smallest = arr[j];
//                    //smallestId = j;
//                }
//            }
//            // 2- put it in retArrEnd
//            retArr[retArrEnd] = smallest;
//            retArrEnd++;
//            // 3- delete(or swap with [i])
//        }
//        return retArr;
//    }
}

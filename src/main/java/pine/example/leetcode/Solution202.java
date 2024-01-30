package pine.example.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution202 {
    /**
     * second try20240130
     * use different method to get each position in int
     * This method is actually slower LOL
     * @param n
     * @return
     */
    public boolean isHappy(int n) {
        List<Integer> oldResults = new ArrayList<>();
        int result = n;
        while (result != 1) {
            if (oldResults.contains(result)) {
                // OPTIMIZE, result内只要含有相同个数的各种数字即开始循环，不需要全等
                // repeat
                return false;
            } else {
                // new result
                oldResults.add(result);
                int sum = 0;
                while (result > 0) {
                    int pos = result % 10;// get one position in result
                    sum = sum + pos * pos;
                    result = result / 10;
                }
                result = sum;
                System.out.println(result);
            }
        }
        //result == 1
        return true;
    }

    /**
     * first try 20240130
     * X-worst case O(n^2)-X No it's not. May be worse
     * debug: n^2 is NOT sqare n !!!!!!!!
     *
     * @param n
     * @return
     */
    public boolean isHappy1(int n) {
        List<Integer> oldResults = new ArrayList<>();
        int result = n;
        while (result != 1) {
            if (oldResults.contains(result)) {
                // OPTIMIZE, result内只要含有相同个数的各种数字即开始循环，不需要全等
                // repeat
                return false;
            } else {
                // new result
                oldResults.add(result);
                String resultStr = Integer.toString(result);
                int sum = 0;
                for (int i = 0; i < resultStr.length(); i++) {
                    sum = sum + (resultStr.charAt(i) - '0') * (resultStr.charAt(i) - '0');
                }
                result = sum;
                //System.out.println(result);
            }
        }
        //result == 1
        return true;
    }
}

package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution205Test {
    @Test
    void isIsomorphicTest(){
        Solution205 s205 = new Solution205();
        String s = "badc";
        String t = "bada";
        System.out.println(s205.isIsomorphic(s, t));
    }

}
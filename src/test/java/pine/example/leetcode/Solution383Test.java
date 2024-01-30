package pine.example.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Solution383Test {
    @Test
    void canConstructTest() {
        Solution383 s383 = new Solution383();
        String ransomNote = "aab";
        String magazine = "baa";
        System.out.println(s383.canConstruct(ransomNote, magazine));
    }

}
package pine.example.leetcode;

import java.util.HashMap;

public class Solution205 {
    /**
     * second try
     * use java HashMap
     * WHY time spend worse than first try (although both O(n))
     * BECAUSE use java HashMap。
     * 自带的hashMap使用简单但是效率可能没有量题定做的那么好。
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        // char in s -> char in t
        HashMap<Integer, Integer> sMapT = new HashMap<>();
        // char in t -> char in s
        HashMap<Integer, Integer> tMapS = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            // s -> t
            if(sMapT.get((int) s.charAt(i)) == null) {
                // no map yet
                // add map
                sMapT.put((int) s.charAt(i), (int)t.charAt(i));
            } else {
                // map existed
                if(sMapT.get((int) s.charAt(i)) != (int)t.charAt(i)) {
                    // same s map to different t
                    return false;
                }
            }
            // t -> s
            if(tMapS.get((int) t.charAt(i)) == null) {
                // no map yet
                // add map
                tMapS.put((int) t.charAt(i), (int)s.charAt(i));
            } else {
                // map existed
                if(tMapS.get((int) t.charAt(i)) != (int)s.charAt(i)) {
                    // same t map to different s
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * first try 20240130
     * O(n)
     * self implement hash table
     * (update - 1) FIX BUG no 2 char in s map to same char in t
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic1(String s, String t) {
        int[] asciiMap = new int[256];// 256: length of ascii set
        // in JAVA, new int[] will set each ele as 0
        for (int i = 0; i < s.length(); i++) {
            if (asciiMap[s.charAt(i)] == 0) {
                // no map rule yet, add map rule
                // hash func: hashFunc(char) = (int)char
                // asciiMap: key:char in s => value: (char in t) + 1
                // +1: avoid 0 ambiguity
                asciiMap[s.charAt(i)] = t.charAt(i) + 1;
            } else if (asciiMap[s.charAt(i)] != t.charAt(i) + 1) {
                return false;
            }
        }
        //no 2 char in s map to same char in t
        //O(1), length fix
        for (int i = 0; i < asciiMap.length - 1; i++) {
            for (int j = i + 1; j < asciiMap.length; j++) {
                if (asciiMap[i] != 0 && asciiMap[i] == asciiMap[j]) {
                    return false;// map to same char in t
                }
            }
        }
        return true;
    }
}

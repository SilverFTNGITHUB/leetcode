package pine.example.leetcode;

public class Solution383 {
    /**
     * second try 20240130
     * reduce O(space) by reduce new arr from 2 to 1
     * somehow also reduce O(t) ???
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] leftovers = new int[26];//letter left in magazine after construct
        for (int i = 0; i < magazine.length(); i++) {
            leftovers[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            leftovers[ransomNote.charAt(i) - 'a']--;
        }
        for(int i = 0; i < 26; i++) {
            if(leftovers[i] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * first try 20240130
     * O(n)
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct1(String ransomNote, String magazine) {
        int[] noteLetters = new int[26];
        int[] magazineLetters = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            noteLetters[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            magazineLetters[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(noteLetters[i] > magazineLetters[i]) {
                return false;
            }
        }
        return true;
    }
}

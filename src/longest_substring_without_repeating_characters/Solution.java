package longest_substring_without_repeating_characters;

import java.util.HashSet;

class Solution {
    public static int lengthOfLongestSubstring(String s) {
        var letters = new HashSet<Character>();
        var substring = "";
        int longest = 0;
        int current = 0;
        int j = 0;
        while (j < s.length()) {
            for (int i = j; i < s.length(); i++) {
                var letter = s.charAt(i);
                if (letters.contains(letter)) {
                    longest = Math.max(longest, current);
                    letters.clear();
                    current = 0;
                    j++;
                    break;
                } else {
                    letters.add(letter);
                    current++;
                }
            }
        }
        System.out.println(longest);
        return longest;
    }

    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
        lengthOfLongestSubstring("bbbbb");
        lengthOfLongestSubstring("pwwkew");
    }
}

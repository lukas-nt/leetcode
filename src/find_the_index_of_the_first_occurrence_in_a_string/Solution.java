package find_the_index_of_the_first_occurrence_in_a_string;

class Solution {

    public static int strStr(String haystack, String needle) {
        for (int i = 0; i < haystack.length(); i++) {
            boolean match = true;
            for (int j = 0; j < needle.length(); j++) {
                if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                    match = false;
                    break;
                }
            }
            if (match) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
        System.out.println(strStr("leetcode", "leeto"));
        System.out.println(strStr("", "leeto"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("leetcode", ""));
        System.out.println(strStr("leetcode", "et"));
        System.out.println(strStr("leetcode", "de"));
        System.out.println(strStr("aaa", "aaaa"));
    }

}
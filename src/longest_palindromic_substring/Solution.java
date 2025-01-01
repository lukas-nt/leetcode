package longest_palindromic_substring;

class Solution {

    public static String longestPalindrome(String s) {
        String longest = "";
        for (int i = 0; i < s.length(); i++) {
            int j = 0;
            String palindrome = "";
            while (i - j >= 0 && i + j < s.length() && s.charAt(i - j) == s.charAt(i + j)) {
                j++;
            }
            j--;
            palindrome = j >= 0 ? s.substring(i - j, i + j + 1) : "";
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }

            j = 0;
            while (i - j >= 1 && i + j < s.length() && s.charAt(i - j - 1) == s.charAt(i + j)) {
                j++;
            }
            j--;
            palindrome = j >= 0 ? s.substring(i - j - 1, i + j + 1) : "";
            if (palindrome.length() > longest.length()) {
                longest = palindrome;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        longestPalindrome("babad");
        longestPalindrome("cbbd");
        longestPalindrome("dbbd");
        longestPalindrome("abcd");
        longestPalindrome("asdfaabccbakjfhdsj");
        longestPalindrome("");
        longestPalindrome("efg");
        longestPalindrome("ee");
        longestPalindrome("aafeeefaaa");
        longestPalindrome("a123afeeefaa234a");
    }
}

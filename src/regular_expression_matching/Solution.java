package regular_expression_matching;

class Solution {

    public static boolean isMatch(String s, String p) {
        boolean match = true;
        for (int i = 0; i < s.length(); i++) {
            if (i >= p.length()) {
                match = false;
                break;
            };
            var pChar = p.charAt(i);
            var sChar = s.charAt(i);
            if (sChar == pChar) continue;
            else if (pChar == '.') continue;
            else if (pChar == '*') {
                if (p.charAt(i - 1) == sChar) {
                    if (i + 1 < s.length() && isMatch(s.substring(i + 1), sChar + p.substring(i))) {
                        return true;
                    }
                } else {
                    match = false;
                    break;
                }
            } else {
                match = false;
                break;
            }
        }
        System.out.printf("s: %s, p: %s, match: %s ---  ", s, p, match);
        return match;
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aa", "a"));
        System.out.println(isMatch("aa", "aa"));
        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("ab", "a*"));
        System.out.println(isMatch("abbbbb", "ab*"));
        System.out.println(isMatch("aaaaaaaa", "ab*"));
        System.out.println(isMatch("aaaaaaaa", "a*"));
        System.out.println(isMatch("aaaaaaaac", "a*."));
        System.out.println(isMatch("aaaaaaaaccccccc", "a*.*"));
    }
}
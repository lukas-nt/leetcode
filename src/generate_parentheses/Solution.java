package generate_parentheses;

import java.util.*;

class Solution {

    public static List<String> generateParenthesis(int n) {
        Set<String> results = new HashSet<>();
        if (n <= 0) return Collections.emptyList();
        if (n == 1) return List.of("()");
        var leftResult = generateParenthesis(n - 1);
        for (String parenthesis : leftResult) {
            for (int j = 0; j < parenthesis.length(); j++) {
                if (parenthesis.charAt(j) == '(') {
                    results.add(parenthesis.substring(0, j + 1) + "()" + parenthesis.substring(j + 1));
                }
            }
            results.add(parenthesis + "()");
        }
        return results.stream().toList();
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(1));
        System.out.println(generateParenthesis(2));
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(4));
        System.out.println(generateParenthesis(5));
        System.out.println(generateParenthesis(6));
        System.out.println(generateParenthesis(7));
        System.out.println(generateParenthesis(8));
    }
}

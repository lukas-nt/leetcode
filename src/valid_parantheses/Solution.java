package valid_parantheses;

import java.util.HashMap;
import java.util.Stack;

class Solution {

    private static final HashMap<Character, Character> brackets = new HashMap<>();

    static {
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
    }

    public static boolean isValid(String s) {
        boolean valid = true;
        var stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            var symbol = s.charAt(i);
            if (brackets.containsValue(symbol)) {
                stack.push(symbol);
            } else if (brackets.containsKey(symbol)) {
                if (stack.isEmpty() || brackets.get(symbol) != stack.pop()) {
                    valid = false;
                    break;
                }
            }
        }
        return valid && stack.isEmpty();
    }

    public static void main(String[] args) {
        isValid("()");
        isValid("()[]{}");
        isValid("(]");
        isValid("([])");
        isValid("(xc[123123]xc)");
        isValid("(xc{[123123]xc)");
        isValid("{{}");
        isValid("((");
        isValid("(())");
        isValid(")");
        isValid("]");
    }
}
